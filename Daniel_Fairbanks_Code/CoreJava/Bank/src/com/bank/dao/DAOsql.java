package com.bank.dao;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import com.bank.pojos.Account;
import com.bank.pojos.AccountType;
import com.bank.pojos.User;
import com.bank.util.ConnectionFactory;

public class DAOsql implements DAO {

	@Override
	public int addUser(User u) {
		
		if (getUser(u.getEmail(), u.getPassword()) != null)
			return -1;
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			conn.setAutoCommit(false);
			String sql = "INSERT INTO Users "
						 + "(Firstname, Lastname, Email, Password) " 
						 + "VALUES (?, ?, ?, ?)";
			String[] key = new String[1];
			key[0] = "UserID";
			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setString(1, u.getFirstname());
			ps.setString(2, u.getLastname());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getPassword());
			
			int numRowsAdded = ps.executeUpdate();
			int id = 0;
			ResultSet pk = ps.getGeneratedKeys();
			while (pk.next()) {
				id = pk.getInt(1);
			}
			conn.commit();
			return id;
			
		} catch (Exception e) {
			System.out.println("ERROR");
		}	
		return -1;
	}
	
	@Override
	public Account addAccount(Account a) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			conn.setAutoCommit(false);
			String sql = "INSERT INTO Account (UserID, TypeID, Active) "
					+"VALUES (?, ?, ?)";
			String[] key = new String[1];
			key[0] = "AccountID";
			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setInt(1, a.getOwner().getId());
			ps.setInt(2, a.getType().getId());
			ps.setInt(3, 1);
			ps.executeUpdate();
			int id = 0;
			ResultSet pk = ps.getGeneratedKeys();
			while (pk.next()) {
				id = pk.getInt(1);
			}
			conn.commit();
			return a;
		} catch (Exception e) {
			System.out.println("ERROR");
		}
		return null;
	}

	@Override
	public User editUser(int id, User u) {
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			conn.setAutoCommit(false);
			String sql = "{call updateUser(?, ?, ?, ?, ?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, u.getId());
			cs.setString(2, u.getFirstname());
			cs.setString(3, u.getLastname());
			cs.setString(4, u.getEmail());
			cs.setString(5, u.getPassword());
			cs.execute();
			conn.commit();
			return u;
			
		} catch (Exception e) {
			System.out.println("ERROR");
		}
		return null;
	}

	@Override
	public User getUser(String email, String password) {
		int id = 0;
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			String sql = "{? = call findUser(?, ?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, Types.NUMERIC);
			cs.setString(2, email);
			cs.setString(3, password);
			cs.execute();
			id = cs.getInt(1);
			
		} catch (Exception e) {
			System.out.println("ERROR");
		} 
		TreeMap<Integer, User> users = getAllUsers();
		return users.get(id);
	}

	@Override
	public TreeMap<Integer, User> getAllUsers() {
		TreeMap<Integer, User> users = new TreeMap<Integer, User>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			String sql = "SELECT u.UserID, u.Firstname, u.Lastname, u.Email, u.Password, a.Balance, t.Name "
					+ "FROM Users u "
					+ "LEFT JOIN Account a "
					+ "ON u.UserID = a.UserID "
					+ "LEFT JOIN AccountType t "
					+ "ON a.TypeID = t.TypeID";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt(1);
				String firstname = rs.getString(2);
				String lastname = rs.getString(3);
				String email = rs.getString(4);
				String password = rs.getString(5);
				User tmp = new User();
				tmp.setId(id);
				tmp.setFirstname(firstname);
				tmp.setLastname(lastname);
				tmp.setEmail(email);
				tmp.setPassword(password);
				users.put(id, tmp);
			}
		} catch (Exception e) {
			System.out.println("ERROR");
		}
		return users;
	}
	
	public BigDecimal getBalance(User u, int id) {
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			String sql = "{? = call getBalance(?, ?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, Types.DECIMAL);
			cs.setInt(2, u.getId());
			cs.setInt(3, id);
			cs.execute();
			BigDecimal bal = cs.getBigDecimal(1);
			return bal;
			
		} catch (Exception e) {
			System.out.println("ERROR");
		}
		return null;
	}
	
	public void setBalance(User u, int acct_id, BigDecimal amt) {
		
		BigDecimal total = getBalance(u, acct_id).add(amt);
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			conn.setAutoCommit(false);
			String sql = "{call updateBalance(?, ?, ?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, u.getId());
			cs.setBigDecimal(2, total);
			cs.setInt(3, acct_id);
			cs.execute();
			conn.commit();
			
		} catch (Exception e) {
			System.out.println("ERROR");
		}
	}
	
	public ArrayList<Account> getAllAccounts(User u) {
		ArrayList<Account> accounts = new ArrayList<Account>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			String sql = "SELECT a.AccountID, a.Balance, a.UserID, a.Active, t.Name " + 
						 "FROM Account a " + 
						 "LEFT JOIN AccountType t " + 
						 "ON a.TypeID = t.TypeID";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				if (rs.getInt(3) != u.getId())
					continue;
				if (rs.getInt(4) == 0)
					continue;
				int acct_id = rs.getInt(1);
				BigDecimal acct_bal = rs.getBigDecimal(2);
				String acct_type = rs.getString(5);
				Account tmp = new Account();
				AccountType t = new AccountType(acct_type);
				tmp.setId(acct_id);
				tmp.setBalance(acct_bal);
				tmp.setType(t);
				tmp.setOwner(u);
				accounts.add(tmp);
			}
		} catch (Exception e) {
			System.out.println("ERROR");
		}
		return accounts;
	}
	
	public void closeAccount(int acct_id) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			conn.setAutoCommit(false);
			String sql = "{call closeAcct(?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, acct_id);
			cs.execute();
			conn.commit();		
		} catch (Exception e) {
			System.out.println("ERROR");
		}
	}

}

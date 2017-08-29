package com.ex.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import com.ex.pojos.Account;
import com.ex.pojos.User;
import com.ex.util.ConnectionFactory;

/*
 * 
 */
public class DAOImpl implements DAO{
	
	static User u = new User();
	static Account acc;
	static ArrayList<Account> currentList;
	static double max = 100.00;
	
	/*
	 * PREPARED STATEMENT
	 * - Good for when you plan to use the SQL 
	 * - statements multiple times
	 */

	public int addUser(String fn, String ln, String em, String pass) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			
			String sql = "insert into bank_users (firstname, lastname, email, password) values (?,?,?,?)";
			String[] key = new String[1];
			key[0] = "userid";
			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setString(1, fn);  //it won't matter what is contained within the String
			ps.setString(2, ln);
			ps.setString(3, em);
			ps.setString(4, pass);
			
			ps.executeUpdate();
			
			int id = 0;
			ResultSet pk = ps.getGeneratedKeys();
			while(pk.next()) {
				id = pk.getInt(1);
			}
			conn.commit();
			return id;
		
		//catch has been tested & works
		} catch (SQLIntegrityConstraintViolationException e) {
    		System.out.println("The credentials are already taken.");
    		System.out.println("Please try again.");
    	} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public Account createAccount(User u, int typeid) {
		
		acc = new Account();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			
			String sql = "insert into bank_account(userid, typeid) " + 
						 "values (?,?)";
			
			String[] key = new String[1];
			key[0] = "accountid";
			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setInt(1, u.getUserid());
			ps.setInt(2, typeid);
			
			ps.executeUpdate();
			
			int id = 0;
			ResultSet pk = ps.getGeneratedKeys();
			while(pk.next()) {
				id = pk.getInt(1);
			}
			
			acc.setId(id);
			acc.setBalance(0);
			acc.setId(typeid);
			
			conn.commit();
			return acc;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * STATEMENT - GET ALL USERS
	 * -Good for general purpose access to the database
	 * -Cannot take parameters
	 * TO CHECK IF USERS ARE BEING ADDED CORRECTLY
	 */
	
	public ArrayList<User> getAll() {
		ArrayList<User> list = new ArrayList<User>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from bank_users";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String fn = rs.getString(2);
				String ln = rs.getString(3);
				String em = rs.getString(4);
				String pass = rs.getString(5);
				
				User temp = new User(id, fn, ln, em, pass);
				list.add(temp);
			}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return list;
	}
	
	/*
	 * STATEMENT - GET ALL USERS
	 * TO CHECK IF USERS ARE BEING ADDED CORRECTLY
	 */
	
	public ArrayList<Account> getAllAccs() {
		ArrayList<Account> alist = new ArrayList<Account>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from bank_account";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				int accid = rs.getInt(1);
				double balance = rs.getDouble(2);
				int userid = rs.getInt(3);
				int typeid = rs.getInt(4);
				
				Account temp = new Account(accid, balance, userid, typeid);
				alist.add(temp);
			}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return alist;
	}

	@Override
	public boolean doesUserWithEmailExist(String email) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from bank_users where email = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				return true;
			}
			else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<Account> getUserAccounts(User u) {
		int uid = u.getUserid();
		currentList = new ArrayList<Account>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from bank_account where userid = uid";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt(1);
				double balance = rs.getInt(2);
				int userid = rs.getInt(3);
				int typeid = rs.getInt(4);
				
				Account temp = new Account(id, balance, userid, typeid);
				currentList.add(temp);
			}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return currentList;
	}

	@Override
	public void updateUserFName(String email, String newFN) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			
			String sql = "update bank_users set firstname = ? where email = ?";
			
			String[] key = new String[1];
			key[0] = "userid";
			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setString(1, newFN);
			ps.setString(2, email);
			
			ps.executeUpdate();
			
			int id = 0;
			ResultSet pk = ps.getGeneratedKeys();
			while(pk.next()) {
				id = pk.getInt(1);
			}
			
			u.setFirstname(newFN);
			
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateUserLName(String email, String newLN) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			
			String sql = "update bank_users set lastname = ? where email = ?";
			
			String[] key = new String[1];
			key[0] = "userid";
			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setString(1, newLN);
			ps.setString(2, email);
			
			ps.executeUpdate();
			
			int id = 0;
			ResultSet pk = ps.getGeneratedKeys();
			while(pk.next()) {
				id = pk.getInt(1);
			}
			
			u.setLastname(newLN);
			
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//don't need this for now however, having this method 
	//may prove useful later
	@Override
	public void updateUserEmail(String email, String newEm) {
		
		
	}

	@Override
	public void updateUserPass(String email,String newPass) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			
			String sql = "update bank_users set password = ? where email = ?";
			
			//String[] key = new String[1];
			//key[0] = "userid";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newPass);
			ps.setString(2, email);
			
			ps.executeUpdate();
			
			int id = 0;
			ResultSet pk = ps.getGeneratedKeys();
			while(pk.next()) {
				id = pk.getInt(1);
			}
			
			u.setPassword(newPass);
			
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateUserAccount(double change, String email, String choice) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			
			String sql = "update bank_users set balance = ? where email = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			if(choice.equals("2")) {
				double newB = acc.getBalance() - change;
				ps.setDouble(1, newB);
				acc.setBalance(newB);
			}
			else {
				ps.setDouble(1, change);
			}
			ps.setString(2, email);
			
			ps.executeUpdate();
			
			int id = 0;
			ResultSet pk = ps.getGeneratedKeys();
			while(pk.next()) {
				id = pk.getInt(1);
			}
			
			acc.setBalance(change);
			
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Unlike the method above: updateUserAccount
	 * this method looks for all user accounts with the email
	 * 
	 */
	@Override
	public void updateUserAccounts(double change, String rFundsEmail, String aFundsEmail) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			
			Account acc1 = new Account();
			Account acc2 = new Account();
			
			String rFundsSql = "update bank_users set balance = ? where email = ?";
			String aFundsSql = "update bank_users set balance = ? where email = ?";
			
			PreparedStatement rps = conn.prepareStatement(rFundsSql);
			PreparedStatement aps = conn.prepareStatement(aFundsSql);
			
			rps.setDouble(1, acc1.getBalance() - change);
			rps.setString(2, rFundsEmail);
			rps.executeUpdate();
			
			aps.setDouble(1, acc2.getBalance() + change);
			aps.setString(2, aFundsEmail);
			aps.executeUpdate();
			
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void closeUserAccount(String cEmail) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			
			String sql = "insert into closed_on from bank_account values (current_timestamp) "
						 + "where email = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, cEmail);
			ps.executeUpdate();
			conn.commit();
			
	} catch (SQLException e) {
		e.printStackTrace();
	}
  }

	@Override
	public User setUserInfo(String email) {
		
		CallableStatement cstate = null;
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);

			String sql = "{call obtainUser(?,?,?,?)}";

			cstate = conn.prepareCall(sql);
			
			//binds the in parameter
			cstate.setString(1, email);
			
			cstate.registerOutParameter(2, java.sql.Types.VARCHAR);
			cstate.registerOutParameter(3, java.sql.Types.VARCHAR);
			cstate.registerOutParameter(4, java.sql.Types.VARCHAR);
			
			cstate.executeUpdate();
			
			u.setFirstname(cstate.getString(2));
			u.setLastname(cstate.getString(3));
			u.setPassword(cstate.getString(4));
			
			return u;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}

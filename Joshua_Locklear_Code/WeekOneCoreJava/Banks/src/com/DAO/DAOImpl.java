package com.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pojos.Account;
import com.pojos.AccountType;
import com.pojos.User;
import com.util.ConnectionFactory;

public class DAOImpl implements DAO {
	static User user = new User();
	static String sql;
	

	public int addUser(User user) {
		int id = -1;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			sql = "insert into users (firstname, lastname, email, password) " + 
						 "values (?, ?, ?, ?)";
			String[] key = new String[1];
			key[0] = "user_id";
			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setString(1, user.getFirstname());
			ps.setString(2, user.getLastname());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPassword());
			int numRowsAdded = ps.executeUpdate();
			ResultSet pk = ps.getGeneratedKeys();
			while(pk.next()) {
				id = pk.getInt(1);
			}
			conn.commit();
			//return id;
		} catch (SQLException e) { }
		return id;
	}
	
	public User getUser(int id) {
		//User user = new User();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			sql = "select * from users where user_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				user = new User(rs.getInt("user_Id"),rs.getString("firstname"),rs.getString("lastname"),
						rs.getString("email"),rs.getString("password"));
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	public User getUser(String email, String pass){
		//User user = new User();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			sql = "select * from users where"
					+ " email = ? AND "
					+ " password = ?";

			//setup prepared with sql and allocate space for key
			PreparedStatement ps = conn.prepareStatement(sql);
			//set values into sql string ?'s
			ps.setString(1, email);
			ps.setString(2, pass);

			
			//execute and get values
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				user = new User(rs.getInt("user_Id"),rs.getString("firstname"),rs.getString("lastname"),
						rs.getString("email"),rs.getString("password"));
			}
			conn.commit();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return user;
	}
	
	public int addAccount(int userid,int typeid) {
		int id = -1;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			sql = "insert into account (user_id,type_id) values (?,?)";


			String[] key = new String[1];
			key[0] = "account_id";

			
			PreparedStatement ps = conn.prepareStatement(sql,key);
			ps.setInt(1, userid);
			ps.setInt(2, typeid);

		
			ps.executeUpdate();


			ResultSet primaryKeys = ps.getGeneratedKeys();
			while(primaryKeys.next()){
				id = primaryKeys.getInt(1);
			}
			conn.commit();
		} catch (SQLException e) { }
		return id;
	}
	public Account getAccount(int accountid){
		Account account = new Account();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			sql = "select * from account where"
					+ " account_id = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, accountid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				account = new Account(rs.getInt("account_Id"),rs.getBigDecimal("balance"), rs.getInt("user_id"), rs.getInt("type_id"));
			}
			conn.commit();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return account;
	}
	
	public void updateUser(User user) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			sql = "update users set firstname = ?, lastname = ?, email = ?, password = ? where user_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getFirstname());
			ps.setString(2, user.getLastname());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPassword());
			ps.setInt(5, user.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteAccount(Account a) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			sql = "delete from account where account_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, a.getAccountID());
			ps.executeUpdate();
			//return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//return false;
	}
	
	public ArrayList<Account> getAccounts(int userid) {
		ArrayList<Account> accounts = new ArrayList<Account>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			sql = "select * from account where user_id = ?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, userid);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				//AccountType acc = new AccountType(rs.getInt(5));
				Account account = new Account(rs.getInt("account_Id"),rs.getBigDecimal("balance"), rs.getInt("user_id"), rs.getInt("type_id"));
				accounts.add(account);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}
	
	public void updateAccount(Account a) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			sql = "update account set balance = ? where account_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setBigDecimal(1, a.getBalance());
			ps.setInt(2, a.getAccountID());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//return false;
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}
	
}

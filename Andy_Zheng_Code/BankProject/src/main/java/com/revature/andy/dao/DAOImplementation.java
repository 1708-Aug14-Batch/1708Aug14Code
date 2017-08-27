package com.revature.andy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

import com.revature.andy.pojos.*;
import com.revature.andy.util.ConnectionFactory;

public class DAOImplementation implements DAOInterface {
	
	// prepared statement
	
	// Add Account
	public int addAccount(User u, int typeID) {
		
		try(Connection con = ConnectionFactory.getInstance().getConnection();){
			con.setAutoCommit(false);
			
			String sql = "INSERT INTO ACCOUNTS(USERID, TYPEID) VALUES(?,?)";
			
			String[] key = new String[1];
			key[0] = "ACCOUNTID";
			PreparedStatement ps = con.prepareStatement(sql, key);
			ps.setInt(1, u.getUserID());
			ps.setInt(2, typeID);
			
			ps.executeUpdate();
			
			int id = 0;
			ResultSet rs = ps.getGeneratedKeys();
			
			while(rs.next()) {
				id = rs.getInt(1);
			}
			
			con.commit();
			return id;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return -1;
		}
		
	}
	
	// Update Account
	public int updateAccount(User user, int accountID, double balance) {
		try(Connection con = ConnectionFactory.getInstance().getConnection();){
			con.setAutoCommit(false);
			String sql = "UPDATE ACCOUNTS SET BALANCE = ? WHERE ACCOUNTID = ? AND USERID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setDouble(1, balance);
			ps.setInt(2, accountID);
			ps.setInt(3, user.getUserID());
			
			ps.executeQuery();
			con.commit();
			return 1;
		}catch(SQLException e) {
			e.printStackTrace();
			return -1;
		}
	};

	// Add User by Pass object
	public int addUser(User u) {

		try(Connection con = ConnectionFactory.getInstance().getConnection();){
			con.setAutoCommit(false);
			String sql = "INSERT INTO USERS(FIRSTNAME, LASTNAME, EMAIL, PASSWORD) VALUES(?,?,?,?)";
			String[] key = new String[1];
			key[0] ="USERID";
			PreparedStatement ps = con.prepareStatement(sql,key);
			ps.setString(1, u.getFName());
			ps.setString(2, u.getLName());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getPassword());
			
			int id = 0;
			
			ResultSet rs = ps.getGeneratedKeys();
			while(rs.next()) {
				id=rs.getInt(1);
			}
			con.commit();
			return id;			
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return -1;
	}
	
	// Add User by Pass strings
	public int addUser(String fn, String ln, String email, String pwd) {
		
		try(Connection con = ConnectionFactory.getInstance().getConnection();){
			con.setAutoCommit(false);
			String sql = "INSERT INTO USERS(FIRSTNAME, LASTNAME, EMAIL, PASSWORD) VALUES(?,?,?,?)";
			String[] key = new String[1];
			key[0] ="USERID";
			PreparedStatement ps = con.prepareStatement(sql,key);
			ps.setString(1, fn);
			ps.setString(2, ln);
			ps.setString(3, email);
			ps.setString(4, pwd);

			ps.executeUpdate();
			
			int id = 0;
			
			ResultSet rs = ps.getGeneratedKeys();
			while(rs.next()) {
				id=rs.getInt(1);
			}
			con.commit();
			return id;
			
		}catch(SQLException e){
			e.printStackTrace();
			return -1;
		}
	}
	
	// Update User by pass object
	public int updateUser(User u) {
		try(Connection con = ConnectionFactory.getInstance().getConnection();){
			con.setAutoCommit(false);
			String sql = "UPDATE USERS SET FIRSTNAME = ?, LASTNAME = ?, "
					+ "EMAIL = ?, PASSWORD = ? WHERE USERID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, u.getFName());
			ps.setString(2,u.getLName());
			ps.setString(3,u.getEmail());
			ps.setString(4,u.getPassword());
			ps.setInt(5,u.getUserID());

			ps.executeUpdate();
			
			con.commit();
			return 1;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	// Get Specific User
	public User getUser(String email, String pwd) {
		
		try(Connection con = ConnectionFactory.getInstance().getConnection();){
			String sql = "SELECT * FROM USERS WHERE EMAIL = (?) AND PASSWORD = (?)";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,email);
			ps.setString(2,pwd);
			
			ResultSet rs = ps.executeQuery();
			
			User temp = null;
			
			while(rs.next()) {	
				temp = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			}
			return temp;
			
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		
	}
	
	// Return HashSet of Accounts
	public HashSet<Account> getAccounts(User user) {
		
		try(Connection con = ConnectionFactory.getInstance().getConnection();){
			String sql = "SELECT * FROM ACCOUNTS WHERE USERID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, user.getUserID());
			
			ResultSet rs = ps.executeQuery();
			
			HashSet<Account> accountList = new HashSet<>();
			
			while(rs.next()) {
				AccountType tempType = getAccountTypeFromID(rs.getInt(4));
				Account temp = new Account(rs.getInt(1), rs.getDouble(2), user, tempType);
				accountList.add(temp);
			}
			
			return accountList;
			
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		
	}
	
	// Get Account
	public Account getAccount(User user, int accountID) {
		try(Connection con = ConnectionFactory.getInstance().getConnection();){
			String sql = "SELECT * FROM ACCOUNTS WHERE ACCOUNTID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, accountID);
			
			ResultSet rs = ps.executeQuery();
			
			Account temp = null;
			
			while(rs.next()) {
				AccountType tempType = getAccountTypeFromID(rs.getInt(4));
				temp = new Account(rs.getInt(1), rs.getInt(2), user, tempType);
			}
			
			return temp;
			
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	
	// Return a AccountType Object From Look Up Table
	public AccountType getAccountTypeFromID(int accountTypeID) {
		
		try(Connection con = ConnectionFactory.getInstance().getConnection();){
			String sql = "SELECT * FROM ACCOUNTTYPE WHERE TYPEID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, accountTypeID);
			
			ResultSet rs = ps.executeQuery();

			AccountType tempType = new AccountType();
			
			while(rs.next()) {
				tempType = new AccountType(rs.getInt(1),rs.getString(2));
			}
			
			return tempType;
			
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
			
	}
	
	// Delete Account
	public int deleteAccount(User user, int accountID) {
		
		try(Connection con = ConnectionFactory.getInstance().getConnection();){
			con.setAutoCommit(false);
			String sql = "DELETE FROM ACCOUNTS WHERE ACCOUNTID = ? AND USERID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, accountID);
			ps.setInt(2, user.getUserID());
			
			ps.executeUpdate();
			
			con.commit();
			return 1;
			
		}catch(SQLException e){
			e.printStackTrace();
			return -1;
		}
	}
}
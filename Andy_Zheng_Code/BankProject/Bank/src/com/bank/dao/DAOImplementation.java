package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bank.pojos.Account;
import com.bank.pojos.User;
import com.bank.util.ConnectionFactory;

public class DAOImplementation {
	
	// prepared statement
	
	public Account addAccount(User u, int typeID) {
		
		Account a = null;
		
		try(Connection con = ConnectionFactory.getInstance().getConnection();){
			con.setAutoCommit(false);
			String sql = "INSERT INTO ACCOUNTS(USERID, TYPEID) VALUES(?,?)";
			String[] key = new String[1];
			key[0] = "ACCOUNTID";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, u.getUserid());
			ps.setInt(2, typeID);
		
			ps.executeUpdate();
			int id = 0;
			ResultSet rs = ps.getGeneratedKeys();
			while(rs.next()) {
				id = rs.getInt(1);
			}
			
			a.setAccountID(id);
			a.setBalance(0);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return a;
	}
	
	public void addAccount(int userID, int typeID) {
		try(Connection con = ConnectionFactory.getInstance().getConnection();){
			con.setAutoCommit(false);
			String sql = "INSERT INTO ACCOUNTS(USERID, TYPEID) VALUES (?,?)";
			String[] key = new String[2];
			key[0] ="ACCOUNTID";
			// ???
			//key[1] ="BALANCE";
			PreparedStatement ps = con.prepareStatement(sql,key);
			ps.setInt(1, userID);
			ps.setInt(2, typeID);
			con.commit();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateAccount(int accountID, double balance) {
		try(Connection con = ConnectionFactory.getInstance().getConnection();){
			con.setAutoCommit(false);
			String sql = "UPDATE ACCOUNTS SET BALANCE = ? WHERE ACCOUNTID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setDouble(1, balance);
			ps.setInt(2, accountID);
			
			ps.executeQuery();
			con.commit();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	};

	public int addUser(User u) {

		try(Connection con = ConnectionFactory.getInstance().getConnection();){
			con.setAutoCommit(false);
			String sql = "INSERT INTO USERS(FIRSTNAME, LASTNAME, EMAIL, PASSWORD) VALUES(?,?,?,?)";
			String[] key = new String[1];
			key[0] ="USERID";
			PreparedStatement ps = con.prepareStatement(sql,key);
			ps.setString(1, u.getFname());
			ps.setString(2, u.getLname());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getPassword());
			
			con.commit();
			
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return -1;
	}
	
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
		}
				
		return -1;
	}
	
	public void updateUser(User u) {
		try(Connection con = ConnectionFactory.getInstance().getConnection();){
			con.setAutoCommit(false);
			String sql = "UPDATE USERS SET FIRSTNAME = ?, LASTNAME = ?, "
					+ "EMAIL = ?, PASSWORD = ? WHERE USERID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, u.getFname());
			ps.setString(2,u.getLname());
			ps.setString(3,u.getEmail());
			ps.setString(4,u.getPassword());
			ps.setInt(5,u.getUserid());
			
			ps.executeQuery();
			con.commit();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public User getUser(String email, String pwd) {
		
		
		try(Connection con = ConnectionFactory.getInstance().getConnection();){
			String sql = "SELECT * FROM USERS WHERE EMAIL = ? AND PASSWORD = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,email);
			ps.setString(2, pwd);
			
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			//while(rs.next()){
			User temp = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			//}
			
			return temp;
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ArrayList<Account> getAccount(int userID) {
		
		try(Connection con = ConnectionFactory.getInstance().getConnection();){
			String sql = "SELECT * FROM ACCOUNTS WHERE USERID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userID);
			
			ResultSet rs = ps.executeQuery();
			
			ArrayList<Account> accountList = new ArrayList<>();
			
			while(rs.next()) {
				//Account temp = new Account(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4));
				//accountList.add(temp);
			}
			
			return accountList;
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	/*
	public ArrayList<User> getAllUsers(){
		
		try(Connection con = ConnectionFactory.getInstance().getConnection();){
			String sql = "SELECT * FROM USERS";
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return null;
	}
	*/
}
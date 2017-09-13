package com.resort.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.resort.pojos.User;
import com.resort.util.ConnectionFactory;

public class UserDAOImpl implements UserDAO {
	
	public HashMap<Integer, String> getEmails(){
		
		HashMap<Integer, String> emails = new HashMap<Integer, String>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "select user_id, email from resort_users";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){
				int id = rs.getInt(1);
				String email = rs.getString(2);
				emails.put(id, email);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emails;
	}
	
	public User getUserById(int id){
		User u = new User();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "select * from resort_users where user_id =  ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			
			while(info.next()){
				u.setUserid(info.getInt(1));
				u.setFirstname(info.getString(2));
				u.setLastname(info.getString(3));
				u.setEmail(info.getString(4));
				u.setPassword(info.getString(5));
				u.setIsManager(info.getInt(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return u;
	}
	
public ArrayList<User> getUsers() {
		
		ArrayList<User> currUsersList = new ArrayList<User>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			Statement statement = conn.createStatement();
			String procedure = "select * from resort_users";
			
			ResultSet rs = statement.executeQuery(procedure);
			
			while(rs.next()) {
				int uid = rs.getInt(0);
				String ufname = rs.getString(1);
				String ulname = rs.getString(2);
				String email = rs.getString(3);
				String password = rs.getString(4);
				
				User temp = new User(uid, ufname, ulname, email, password);
				currUsersList.add(temp);
			}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return currUsersList;
	}
	
	public int addUser(String fn, String ln, String em, String pass) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			
			String sql = "insert into resort_users (first_name, last_name, email, password) values (?,?,?,?)";
			String[] key = new String[1];
			key[0] = "user_id";
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

}

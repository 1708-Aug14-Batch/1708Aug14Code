package com.reimbursement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.reimbursement.pojos.User;
import com.reimbursement.util.ConnectionFactory;

public class DAOImpl implements DAO {

	
	public ArrayList<User> getUsers() {
		ArrayList<User> list = new ArrayList<User>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			String sql = "select * from users";
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String fn = rs.getString(2);
				String ln = rs.getString(3);
				String em = rs.getString(4);
				String pw = rs.getString(5);
				int isM = rs.getInt(6);
				
				User u = new User(id,fn,ln,em,pw,isM);
				list.add(u);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
		
	}
	public void createUser() {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String sql = "insert into users(firstname,lastname,email,password,isManager) " + 
					"values(?,?,?,?,?) ";
			
			String [] keys = new String[1];
			keys[0] = "user_id";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void createReimbursement(User u) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String sql = "insert into Reimbursement(submit_id, submit_date, description, amount) " + 
					"values(?,CURRENT_TIMESTAMP, ?, ?) ";
			String[] keys = new String[1];
			keys[0] = "re_id";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, u.getUserId());
//			ps.setDate(2, x);
//			ps.setString(3, );
//			ps.setInt(4, x);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
}

package com.reimbursement.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

import com.reimbursement.pojos.Reimbursement;
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
	
	@Override
	public void createReimbursement(User u) {
		int amount = 0;
		Date date = new Date(Calendar.getInstance().getTime().getTime());
		String description = " ";
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String sql = "insert into Reimbursement(submit_id, submit_date, description, amount) " + 
					"values(?,?, ?, ?) ";
			String[] keys = new String[1];
			keys[0] = "re_id";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, u.getUserId());
			ps.setDate(2, date);
			ps.setString(3, description);
			ps.setInt(4, amount);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public ArrayList<Reimbursement> getReimbursement(){
		ArrayList<Reimbursement> list = new ArrayList<Reimbursement>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			String sql = "select * from reimbursement";
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt(1);
				int sID = rs.getInt(2);
				int rID = rs.getInt(3);
				int statusID = rs.getInt(4);
				String desc = rs.getString(5);
				String notes = rs.getString(6);
				int amount = rs.getInt(7);
				
				Reimbursement r = new Reimbursement(id,sID,rID,statusID,desc,notes,amount);
				list.add(r);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
		
	}
	
	
}

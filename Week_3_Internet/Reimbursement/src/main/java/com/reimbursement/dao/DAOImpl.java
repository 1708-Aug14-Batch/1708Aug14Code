package com.reimbursement.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
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
	public void getSingleUser(User u) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "select firstname, lastname, email from users " + 
					"where user_id = ?";
			PreparedStatement state = conn.prepareStatement(sql);
			state.setInt(1, u.getUserId());
			ResultSet rs = state.executeQuery();
			while(rs.next()) {
				System.out.println("Name: " + rs.getString(1) + " " + rs.getString(2) + "\n"
				+ "Email: " + rs.getString(3));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
	
	
	public void UpdateUser(User u) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String sql = "update users " + 
					"set firstname = ?, lastname = ?, email = ?, password = ? " + 
					"where user_id = ? ";
			
			PreparedStatement state = conn.prepareStatement(sql);
			state.setInt(5, u.getUserId());
			state.setString(1, u.getFirstname());
			state.setString(2, u.getLastname());
			state.setString(3, u.getEmail());
			state.setString(4, u.getPassword());
			state.executeUpdate();
			conn.commit();
			System.out.println("Update success?");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void createReimbursement(User u ,int amt, String desc) {
	
		int amount = amt;
		
		String description = desc;
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String sql = "insert into Reimbursement(submit_id, submit_date, description, amount) " + 
					"values(?,CURRENT_TIMESTAMP,?, ?) ";
			String[] keys = new String[1];
			keys[0] = "re_id";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, u.getUserId());
			
			ps.setString(2, description);
			ps.setInt(3, amount);
			ps.executeUpdate();
			
			conn.commit();
			System.out.println("Submittal Successful");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public ArrayList<Reimbursement> getAllReimbursements(){
		
		ArrayList<Reimbursement> list = new ArrayList<Reimbursement>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			String sql = "select * from reimbursement";
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt(1);
				int sID = rs.getInt(2);
				int rID = rs.getInt(3);
				Timestamp sDate = rs.getTimestamp(4);
				Timestamp rDate = rs.getTimestamp(5);
				int statusID = rs.getInt(6);
				String desc = rs.getString(7);
				String notes = rs.getString(8);
				int amount = rs.getInt(9);
				
				Reimbursement r = new Reimbursement(id,sID,rID,sDate,rDate,statusID,desc,notes,amount);
				list.add(r);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
		
	}
	
	public ArrayList<Reimbursement> getReimbursement(User u) {
		
		
		
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			ArrayList<Reimbursement> list = new ArrayList<Reimbursement>();
			
			String sql = "select users.firstname, users.lastname, Reimbursement.RE_ID, Reimbursement.SUBMIT_DATE, Reimbursement.DESCRIPTION, Reimbursement.AMOUNT, R_status.name from users " + 
					"Left Join Reimbursement inner join R_status on Reimbursement.STATUS_ID = R_Status.st_id on users.user_id = reimbursement.submit_id " + 
					"Where users.user_id = ? ";
			PreparedStatement state = conn.prepareStatement(sql);
			state.setInt(1, u.getUserId());
			ResultSet rs = state.executeQuery();
			System.out.println("Here");
			while(rs.next()) {
				System.out.println("Name: " + rs.getString(1) + " " + rs.getString(2) 
				+ " ReimbursmentID: " + rs.getInt(3)
				+ " Date Submitted: " + rs.getDate(4)
				+ " Description: " + rs.getString(5)
				+ " Amount: " + rs.getInt(6)
				+ " Status: " + rs.getString(7) + "\n");
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public void getPendingReimbursements() {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "select users.firstname, users.lastname, Reimbursement.RE_ID, Reimbursement.SUBMIT_DATE, Reimbursement.DESCRIPTION, Reimbursement.AMOUNT, R_status.name from users " + 
					"Left Join Reimbursement inner join R_status on Reimbursement.STATUS_ID = R_Status.st_id on users.user_id = reimbursement.submit_id " + 
					"where R_status.name = ?";
			
			PreparedStatement state = conn.prepareStatement(sql);
			state.setString(1, "Pending");
			ResultSet rs = state.executeQuery();
			while(rs.next()) {
				System.out.println("Name: " + rs.getString(1) + " " + rs.getString(2) 
				+ " ReimbursmentID: " + rs.getInt(3)
				+ " Date Submitted: " + rs.getDate(4)
				+ " Description: " + rs.getString(5)
				+ " Amount: " + rs.getInt(6)
				+ " Status: " + rs.getString(7) + "\n");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void getResolvedReimbursements() {
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "select users.firstname, users.lastname, Reimbursement.RE_ID, Reimbursement.SUBMIT_DATE, Reimbursement.DESCRIPTION, Reimbursement.AMOUNT, R_status.name from users " + 
					"Left Join Reimbursement inner join R_status on Reimbursement.STATUS_ID = R_Status.st_id on users.user_id = reimbursement.submit_id " + 
					"where R_status.name = ? or R_status.name = ?";
			
			PreparedStatement state = conn.prepareStatement(sql);
			state.setString(1, "Approved");
			state.setString(2, "Denied");
			ResultSet rs = state.executeQuery();
			while(rs.next()) {
				System.out.println("Name: " + rs.getString(1) + " " + rs.getString(2) 
				+ " \nReimbursmentID: " + rs.getInt(3)
				+ " \nDate Submitted: " + rs.getDate(4)
				+ " \nDescription: " + rs.getString(5)
				+ " \nAmount: " + rs.getInt(6)
				+ " \nStatus: " + rs.getString(7) + "\n\n");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void ApproveOrDeny(int resId, String notes, int r_id, int re_id) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			Date date = new Date(Calendar.getInstance().getTime().getTime());
			String sql = "update reimbursement " + 
					"set status_id = ?, resolved_date = CURRENT_TIMESTAMP ,notes = ? , resolver_id = ?" + 
					"where re_id = ? ";
			PreparedStatement state = conn.prepareStatement(sql);
			state.setInt(1,r_id);
			
			state.setString(2, notes);
			state.setInt(3, resId);
			state.setInt(4, re_id);
			state.executeUpdate();
			
			System.out.println("Updated!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
}

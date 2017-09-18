package com.reimbursments.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
//import java.util.logging.Logger;

//import com.bank.pojos.Account;
import com.reimbursments.pojos.Reimburs;
import com.reimbursments.pojos.Status;
import com.reimbursments.pojos.Users;
import com.reimbursments.util.ConnectionFactory;
import org.apache.log4j.*;

public class DAOImpl implements DAO {
	private static Logger log = Logger.getLogger(DAOImpl.class);
	public ArrayList<Users> getUsers() {
		ArrayList<Users> list = new ArrayList<Users>();
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
				
				Users u = new Users(id,fn,ln,em,pw,isM);
				list.add(u);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
		
	}
	public void getSingleUser(Users u) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "select firstname, lastname, email from users " + 
					"where userid = ?";
			PreparedStatement state = conn.prepareStatement(sql);
			state.setInt(1, u.getUserid());
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
	public void createUser(String fname, String lname, String email, String password) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String sql = "insert into users(firstname,lastname,email,userpassword,isManager) " + 
					"values(?,?,?,?,?) ";
			
			String [] keys = new String[1];
			keys[0] = "user_id";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, email);
			ps.setString(4, password);
			ps.setInt(5, 0);
			ps.executeUpdate();
			System.out.println("New user entered");
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	public void UpdateUser(Users u) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String sql = "update users " + 
					"set firstname = ?, lastname = ?, email = ?, userpassword = ? " + 
					"where userid = ? ";
			
			PreparedStatement state = conn.prepareStatement(sql);
			state.setInt(5, u.getUserid());
			state.setString(1, u.getFirstName());
			state.setString(2, u.getLastName());
			state.setString(3, u.getEmail());
			state.setString(4, u.getPassword());
			state.executeUpdate();
			conn.commit();
			log.debug("Update success?");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void createReimbursement(Users u ,double amt, String desc) {
	
		log.debug("in createReimbursement");
		//int amount = amt;
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String sql = "insert into Reimburse(submitter_id, description, amount) " + 
					"values(?, ?, ?) ";
			String[] keys = new String[1];
			keys[0] = "re_id";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, u.getUserid());
			
			ps.setString(2, desc);
			ps.setDouble(3, amt);
			int rowsInserted = ps.executeUpdate();
			
			log.debug("rowsInserted= "+rowsInserted);
			
			conn.commit();
			log.debug("Submittal Successful");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public ArrayList<Reimburs> getAllReimbursements(){
		
		ArrayList<Reimburs> list = new ArrayList<Reimburs>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			String sql = "select * from reimburse";
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
				double amount = rs.getDouble(9);
				
				Reimburs r = new Reimburs(id,sID,rID,sDate,rDate,statusID,desc,notes,amount);
				list.add(r);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
		
	}
	
	public ArrayList<Reimburs> getReimbursement(Users u) {
		
		
		
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			ArrayList<Reimburs> list = new ArrayList<Reimburs>();
			
			String sql = "select users.firstname, users.lastname, Reimburse.R_ID, Reimburse.SUBMIT_DATE, Reimburse.DESCRIPTION, Reimburse.AMOUNT, status.name from users " + 
					"Left Join Reimburse inner join status on Reimburse.STATUS_ID = status.status_id on users.userid = reimburse.submitter_id " + 
					"Where users.userid = ? ";
			PreparedStatement state = conn.prepareStatement(sql);
			state.setInt(1, u.getUserid());
			ResultSet rs = state.executeQuery();
			log.debug("Here");
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
			String sql = "select users.firstname, users.lastname, Reimburse.R_ID, Reimburse.SUBMIT_DATE, Reimburse.DESCRIPTION, Reimburse.AMOUNT, status.name from users " + 
					"Left Join Reimburse inner join status on Reimburse.STATUS_ID = Status.status_id on users.userid = reimburse.submitter_id " + 
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
			String sql = "select users.firstname, users.lastname, Reimburse.R_ID, Reimburse.SUBMIT_DATE, Reimburse.DESCRIPTION, Reimburse.AMOUNT, status.name from users " + 
					"Left Join Reimburse inner join status on Reimburse.STATUS_ID = Status.status_id on users.user_id = reimburse.submitter_id " + 
					"where status.name = ? or status.name = ?";
			
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
			String sql = "update reimburse " + 
					"set status_id = ?, resolved_date = CURRENT_TIMESTAMP ,resolve_notes = ? , resolver_id = ?" + 
					"where r_id = ? ";
			PreparedStatement state = conn.prepareStatement(sql);
			state.setInt(1,r_id);
			
			state.setString(2, notes);
			state.setInt(3, resId);
			state.setInt(4, re_id);
			state.executeUpdate();
			
			log.debug("Updated!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	

//	@Override
//	public Reimburs createReimburs(Users u, int amount) {
//		// TODO Auto-generated method stub
//		
//		return null;
//	}

//	@Override
//	public ArrayList<Reimburs> getAccountsByUser(Users u) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public ArrayList<Reimburs> getAccountsByUser(Users u) {
//		// TODO Auto-generated method stub
//		ArrayList<Reimburs> re = new ArrayList<Reimburs>();
//		try(Connection conn = ConnectionFactory
//				.getInstance().getConnection();){
//			String sql = "select acc.account_id, acc.balance, t.name"
//					+ " from account acc inner join users on users.user_id = acc.user_id"
//					+ " inner join accounttype t on t.type_id = acc.type_id where users.user_id = ?";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setInt(1, u.getUserid());
//			ResultSet info = ps.executeQuery();
//			
//			while(info.next()){
//				Reimburs temp = new Reimburs();
//				temp.setId(info.getInt(1));
//				System.out.println("Account " + temp.getId());
//				temp.setBalance(info.getDouble(2));
//				temp.setUser(u);
//				temp.setType(info.getString(3));
//				re.add(temp);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		
//		
//		
//		return re;
//	}
}
	

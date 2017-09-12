package com.Reburse.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.Reburse.pojos.Reimbursement;
import com.Reburse.pojos.User;
import com.Reburse.util.ConnectionFactory;

public class DAOimplementation implements DAO {

	public User getUserByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public User getUser(String email, String password) {
		User u = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select userid, firstname, lastname, email, password, ismanager from users where email = ? and password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String fn = rs.getString(2);
				String ln = rs.getString(3);
				String em = rs.getString(4);
				String pass = rs.getString(5);
				int Mng = rs.getInt(6);
				if(Mng == 0) {
					u = new User(id, fn, ln, em, pass, false);
				}
				else {
					u = new User(id, fn, ln, em, pass, true);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	
	public ArrayList<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean addUser(User u) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean updateUser(User u) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			CallableStatement cs = conn.prepareCall("{call upd_Emp(?,?,?,?,?)}");
			cs.setInt(1, u.getUserID());
			cs.setString(2, u.getEmail());
			cs.setString(3, u.getFirstName());
			cs.setString(4, u.getLastName());
			cs.setString(5, u.getPassword());
			cs.executeUpdate();
			System.out.println("Updated Emp Settings Added");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<Reimbursement> getUserReimbursements(User u) {
		ArrayList<Reimbursement> rem = new ArrayList<Reimbursement>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select Reimbursements.R_ID, Users1.FIRSTNAME || ' ' || users1.LASTNAME, users2.FIRSTNAME || ' ' || users2.LASTNAME, " + 
					"Reimbursements.SUBDATE, Reimbursements.RESDATE, Reimbursements.STATUSID, Reimbursements.DESCRIPTION, Reimbursements.RESNOTE, Reimbursements.AMOUNT " + 
					"from Reimbursements " + 
					"left join USERS Users1 " + 
					"on Reimbursements.SUB_ID = USERS1.USERID " + 
					"left join USERS Users2 " + 
					"on Reimbursements.RES_ID = USERS2.USERID " + 
					"where SUB_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, u.getUserID());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String subName = rs.getString(2);
				String resName = rs.getString(3);
				Timestamp subdate = rs.getTimestamp(4);
				String subDateStr = subdate.toLocalDateTime().toString();
				Timestamp resdate = rs.getTimestamp(5);
				String resDateStr = "";
				if(resdate != null) {
					resDateStr = resdate.toLocalDateTime().toString();
				}
				int stID = rs.getInt(6);
				String desc = rs.getString(7);
				String note = rs.getString(8);
				double amount = rs.getDouble(9);
				rem.add(new Reimbursement(id, subName, resName, subDateStr, resDateStr, stID, desc, note, amount));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rem;
	}

	public ArrayList<Reimbursement> getAllReimbursements() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addReimbursement(int SubID, String desc, double Amt) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			CallableStatement cs = conn.prepareCall("{call add_Reim(?,?,?)}");
			cs.setInt(1, SubID);
			cs.setString(2, desc);
			cs.setDouble(3, Amt);
			cs.executeUpdate();
			System.out.println("New Reim Added");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateReimbursement(Reimbursement r) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<String> getAllEmails() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

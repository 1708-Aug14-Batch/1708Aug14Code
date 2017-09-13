package com.reimbursement.dao;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;

import com.reimbursement.pojos.Reimbursement;
import com.reimbursement.pojos.ReimbursementStatus;
import com.reimbursement.pojos.User;
import com.reimbursement.util.ConnectionFactory;

public class DAOsql implements DAO {
	
	public int addUser(String fname, String lname, String email, String password, boolean isMgr) {
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			conn.setAutoCommit(false);
			String sql = "INSERT INTO Users "
						 + "(Firstname, Lastname, Email, Password, IsMgr) " 
						 + "VALUES (?, ?, ?, ?, ?)";
			String[] key = new String[1];
			key[0] = "UserID";
			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, email);
			ps.setString(4, password);
			ps.setInt(5, isMgr == true ? 1 : 0);
			
			int numRowsAdded = ps.executeUpdate();
			int id = 0;
			ResultSet pk = ps.getGeneratedKeys();
			while (pk.next()) {
				id = pk.getInt(1);
			}
			conn.commit();
			return id;
			
		} catch (SQLException e) {
			System.out.println("ERROR: DAOsql - addUser");
		}	
		return -1;
	}

	public User getUser(String email) {
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "SELECT * FROM Users";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String mail = rs.getString(4);
				if (mail.equals(email)) {
					int id = rs.getInt(1);
					String fname = rs.getString(2);
					String lname = rs.getString(3);
					String pword = rs.getString(5);
					boolean isMgr = rs.getInt(6) == 0 ? false : true;
					User u = new User(id, fname, lname, mail, pword, isMgr);
					return u;
				}
			}	
		} catch (SQLException e) {
			System.out.println("ERROR: DAOsql - getUser");
		} 
		return null;
	}
	
	public int editUser(User u) {
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			conn.setAutoCommit(false);
			String sql = "{call editUser(?, ?, ?, ?, ?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, u.getId());
			cs.setString(2, u.getFirstname());
			cs.setString(3, u.getLastname());
			cs.setString(4, u.getEmail());
			cs.setString(5, u.getPassword());
			cs.execute();
			conn.commit();
			return 1;
			
		} catch (SQLException e) {
			System.out.println("ERROR: DAOsql - editUser");
		}
		return -1;
	}
	
	public HashMap<Integer, Reimbursement> getEmployeeReimbursements(User u) {
		
		HashMap<Integer, Reimbursement> requests = new HashMap<Integer, Reimbursement>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
	
			String sql = "SELECT r.RID, r.Amount, r.Description, r.ResolvedNotes, "
					+ "r.SubmitDate, r.ResolveDate, u.Firstname, u.Lastname, r.StatusID, r.ResolverID "
					+ "FROM Reimbursements r "
					+ "LEFT JOIN Users u "
					+ "ON u.UserID = r.ResolverID "
					+ "WHERE SubmitterID = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, u.getId());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				BigDecimal amt = rs.getBigDecimal(2);
				String desc = rs.getString(3);
				String notes = rs.getString(4);
				Timestamp submitDate = rs.getTimestamp(5);
				Timestamp resolveDate = rs.getTimestamp(6);
				String rFname = rs.getString(7);
				String rLname = rs.getString(8);
				int status = rs.getInt(9);
				int rid = rs.getInt(10);
				Reimbursement tmp = new Reimbursement();
				tmp.setId(id);
				tmp.setAmount(amt);
				tmp.setDescription(desc);
				tmp.setResolve_notes(notes);
				tmp.setSubmit_date(submitDate);
				tmp.setResolve_date(resolveDate);
				User resolver = new User();
				resolver.setId(rid);
				resolver.setFirstname(rFname);
				resolver.setLastname(rLname);
				tmp.setResolver(resolver);
				tmp.setStatus(status);
				requests.put(id, tmp);
			}
		} catch (Exception e) {
			System.out.println("ERROR: DAOsql - getEmployeeReimbursements");
		}	
		return requests;
	}
	
	public HashMap<Integer, User> getAllEmployees() {
		
		HashMap<Integer, User> users = new HashMap<Integer, User>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			String sql = "SELECT * FROM Users";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt(1);
				String fname = rs.getString(2);
				String lname = rs.getString(3);
				String email = rs.getString(4);
				String pword = rs.getString(5);
				boolean isMgr = rs.getInt(6) == 0 ? false : true;
				User tmp = new User(id, fname, lname, email, pword, isMgr);
				users.put(id, tmp);
			}
		} catch (Exception e) {
			System.out.println("ERROR: DAOsql - getAllEmployees");
		}
		return users;
	}
	
	public int addRequest(Reimbursement r) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			conn.setAutoCommit(false);
			/*String sql = "INSERT INTO Reimbursements "
						 + "(Amount, Description, StatusID, SubmitterID) " 
						 + "VALUES (?, ?, ?, ?)";*/
			String sql = "{call addRequest(?, ?, ?, ?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setBigDecimal(1, r.getAmount());
			cs.setString(2, r.getDescription());
			cs.setInt(3, r.getStatus());
			cs.setInt(4, r.getSubmitterId());
			cs.execute();
			conn.commit();
			return 1;
			/*
			String[] key = new String[1];
			key[0] = "RID";
			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setBigDecimal(1, r.getAmount());
			ps.setString(2, r.getDescription());
			ps.setInt(3, r.getStatus());
			ps.setInt(4, r.getSubmitterId());
			
			int numRowsAdded = ps.executeUpdate();
			int id = 0;
			ResultSet pk = ps.getGeneratedKeys();
			while (pk.next()) {
				id = pk.getInt(1);
			}
			conn.commit();
			return id;*/
			
		} catch (SQLException e) {
			System.out.println("ERROR: DAOsql - addReimbursementRequest");
		}	
		return -1;
	}
	
	public int resolveRequest(Reimbursement r) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			conn.setAutoCommit(false);
			String sql = "{call resolveRequest(?, ?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, r.getId());
			cs.setInt(2, r.getStatus());
			cs.execute();
			conn.commit();
			return 1;
			
		} catch (SQLException e) {
			System.out.println("ERROR: DAOsql - editUser");
		}
		return -1;
	}
	
	public ArrayList<Reimbursement> getAllRequests() {
		
		ArrayList<Reimbursement> requests = new ArrayList<Reimbursement>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			String sql = "SELECT r.RID, r.Amount, r.Description, r.ResolvedNotes, "
					+ "r.SubmitDate, r.ResolveDate, ur.Firstname, ur.Lastname, r.StatusID, r.ResolverID, "
					+ "r.SubmitterID, us.Firstname, us.Lastname, us.Email "
					+ "FROM Reimbursements r "
					+ "LEFT JOIN Users ur "
					+ "ON ur.UserID = r.ResolverID "
					+ "LEFT JOIN Users us "
					+ "ON us.UserID = r.SubmitterID";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				BigDecimal amt = rs.getBigDecimal(2);
				String desc = rs.getString(3);
				String notes = rs.getString(4);
				Timestamp submitDate = rs.getTimestamp(5);
				Timestamp resolveDate = rs.getTimestamp(6);
				String rFname = rs.getString(7);
				String rLname = rs.getString(8);
				int status = rs.getInt(9);
				int rid = rs.getInt(10);
				int sid = rs.getInt(11);
				String sFname = rs.getString(12);
				String sLname = rs.getString(13);
				String sEmail = rs.getString(14);
				Reimbursement tmp = new Reimbursement();
				tmp.setId(id);
				tmp.setAmount(amt);
				tmp.setDescription(desc);
				tmp.setResolve_notes(notes);
				tmp.setSubmit_date(submitDate);
				tmp.setResolve_date(resolveDate);
				User resolver = new User();
				resolver.setId(rid);
				resolver.setFirstname(rFname);
				resolver.setLastname(rLname);
				tmp.setResolver(resolver);
				User submitter = new User();
				submitter.setId(sid);
				submitter.setFirstname(sFname);
				submitter.setLastname(sLname);
				submitter.setEmail(sEmail);
				tmp.setSubmitter(submitter);
				tmp.setStatus(status);
				requests.add(tmp);
			}
		} catch (Exception e) {
			System.out.println("ERROR: DAOsql - getAllRequests");
		}
		return requests;
	}
	
}

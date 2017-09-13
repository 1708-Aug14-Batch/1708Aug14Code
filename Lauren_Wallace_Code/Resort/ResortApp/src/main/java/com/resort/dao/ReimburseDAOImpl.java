package com.resort.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;

import com.resort.pojos.Reimbursement;
import com.resort.util.ConnectionFactory;

public class ReimburseDAOImpl implements ReimburseDAO {

	@Override
	public Reimbursement getReimById(int rid) {
		Reimbursement reim = new Reimbursement();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "select * from reimbursement where reimburse_id =  ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, rid);
			ResultSet info = ps.executeQuery();
			
			while(info.next()){
				reim.setReimburseId(info.getInt(1));
				reim.setType_Id(info.getInt(2));
				reim.setAmount(info.getDouble(3));
				reim.setRequesterId(info.getInt(4));
				reim.setResolverId(info.getInt(5));
				reim.setStatus_Id(info.getInt(6));
				reim.setReason(info.getString(7));
				reim.setReceipt(info.getString(8));
				reim.setrNotes(info.getString(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return reim;
	}
	
	public ArrayList<Reimbursement> getUserReimbursements(int uid) {
		ArrayList<Reimbursement> currentList = new ArrayList<Reimbursement>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String procedure = "select * from reimbursement where user_id = uid";
			Statement statement = conn.prepareCall(procedure);
			
			ResultSet rs = statement.executeQuery(procedure);
			
			while(rs.next()) {
				int reimid = rs.getInt(1);
				int reqid = rs.getInt(2);
				int resid = rs.getInt(3);
				int statid = rs.getInt(4);
				String receipt = rs.getString(5);
				String reason = rs.getString(6);
				String rnotes = rs.getString(7);
				double amount = rs.getDouble(8);
				int typeid = rs.getInt(9);
				
				Reimbursement temp = new Reimbursement(reimid, reqid, resid, statid, receipt, reason, rnotes, amount, typeid);
				currentList.add(temp);
			}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return currentList;
	}
	
	public ArrayList<Reimbursement> getReimbursements() {
		
		ArrayList<Reimbursement> currentList = new ArrayList<Reimbursement>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			Statement statement = conn.createStatement();
			String procedure = "select * from reimbursement";
			
			ResultSet rs = statement.executeQuery(procedure);
			
			while(rs.next()) {
				int reimid = rs.getInt(1);
				int reqid = rs.getInt(2);
				int resid = rs.getInt(3);
				int statid = rs.getInt(4);
				String receipt = rs.getString(5);
				String reason = rs.getString(6);
				String rnotes = rs.getString(7);
				double amount = rs.getDouble(8);
				int typeid = rs.getInt(9);
				
				Reimbursement temp = new Reimbursement(reimid, reqid, resid, statid, receipt, reason, rnotes, amount, typeid);
				currentList.add(temp);
			}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return currentList;
	}

	@Override
	public int addReimbursement(int requester, double amount, int rtype) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			
			String sql = "insert into reimbursement (requester_id, amount, type_id) values (?,?,?)";
			String[] key = new String[1];
			key[0] = "reimbursement_id";
			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setInt(1, requester);  //it won't matter what is contained within the String
			ps.setDouble(2, amount);
			ps.setInt(3, rtype);
			
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
    		System.out.println("A reimbursement with that information already exists.");
    		System.out.println("Please try again.");
    	} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public int addDetailReimbursement(int requester, String reason, double amount, int rtype) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			
			String sql = "insert into reimbursement (requester_id, reason, amount, type_id) values (?,?,?,?)";
			String[] key = new String[1];
			key[0] = "reimbursement_id";
			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setInt(1, requester);  //it won't matter what is contained within the String
			ps.setString(2, reason);
			ps.setDouble(3, amount);
			ps.setInt(4, rtype);
			
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
    		System.out.println("A reimbursement with that information already exists.");
    		System.out.println("Please try again.");
    	} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void updateReimbursementStatus(int rid, int stat, int resid) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			
			String sql = "update reimbursement set status_id = ?, resolver_id = ? where reimbursement_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, stat);  //it won't matter what is contained within the String
			ps.setInt(2, resid);
			ps.setInt(3, rid);
			
			ps.executeUpdate();
			
			conn.commit();
			
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		
	}
	
	public void updateReimbursementNotes(int rid, String notes) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			
			String sql = "update reimbursement set resolver_notes = ? where reimbursement_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, notes);  //it won't matter what is contained within the String
			ps.setInt(2, rid);
			
			ps.executeUpdate();
			
			conn.commit();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}

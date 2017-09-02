package com.project1.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.project1.util.ConnectionFactory;

public class DaoImpl implements DAO {

	@Override
	public int getUserID(String username, String pw) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "select userid from users where username = ? and password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, pw);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			} else {
				return -1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public void registerEmp(int id) {
		
	}

	@Override
	public void viewAllEmp() {
	// A Manager can view all Employees
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "select firstname, lastname, email, username from users where ismgr = 1";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				//output return rows here
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void viewPendingRequests() {
	// A Manager can view all pending requests from all employees
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "select r.DESCRIPTION, r.SUBMIT_DATE, r.AMOUNT, u.FIRSTNAME || \" \" || u.LASTNAME as Name" + 
					" from Reimbursements r, R_Status s, Users u" + 
					" where r.status_id = s.status_id" + 
					" and r.SUBMITTER_ID = u.USERID" + 
					" and s.name = 'Pending'" + 
					" and u.ISMGR = 1";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				//output return rows here
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void viewResolvedRequests() {
	// A Manager can view all resolved requests from all employees and see which manager resolved it
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "select r.DESCRIPTION, r.AMOUNT, r.SUBMIT_DATE, r.RESOLVED_DATE, u.FIRSTNAME || \" \" || u.LASTNAME as Resolver, r.RESOLUTION_NOTES" + 
					" from Reimbursements r, R_Status s, Users u" + 
					" where r.status_id = s.status_id" + 
					" and r.RESOLVER_ID = u.USERID" + 
					" and (s.name = 'Denied' OR s.name = 'Approved')";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				//output return rows here
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void viewEmpRequest(int id) {
	// A Manager can view reimbursement requests from a single Employee
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "select r.DESCRIPTION, r.AMOUNT, r.SUBMIT_DATE, r.RESOLVED_DATE, s.NAME as Status, r.RESOLUTION_NOTES" + 
					" from Reimbursements r, R_Status s, Users u" + 
					" where r.status_id = s.status_id" + 
					" and r.SUBMITTER_ID = u.USERID" + 
					" and u.ISMGR = 1" + 
					" and u.USERID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				//output return rows here
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
}

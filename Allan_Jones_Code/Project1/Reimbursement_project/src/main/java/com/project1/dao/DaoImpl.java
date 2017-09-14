package com.project1.dao;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.project1.pojos.Users;
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
				return rs.getInt("userid");
			} else {
				return -1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public Users getUser(int id) {
		Users user = new Users();

		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "select firstname, lastname, email, username, password from users where userid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user.setFirstName(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));
				user.setEmail(rs.getString("email"));
				user.setUserName(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public boolean registerEmp(String fn, String ln, String un, String em) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "{call registerEmp(?,?,?,?)}";
			CallableStatement stmt = conn.prepareCall(sql);
			conn.setAutoCommit(false);
			stmt.setString(1, fn);
			stmt.setString(2, ln);
			stmt.setString(3, un);
			stmt.setString(4, em);
			stmt.executeUpdate();
			conn.commit();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public void submitRequest(int submitterid, String description, double amt) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			String sql = "insert into reimbursements " +
						 "(submitter_id, submit_date, status_id, description, amount)" +
						 " values " +
						 " (?, sysdate, 0, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, submitterid);
			ps.setString(2, description);
			ps.setDouble(3, amt);
			ps.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Users> viewAllEmp() {
	// A Manager can view all Employees
		ArrayList<Users> employees = new ArrayList<>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "select firstname, lastname, username, email from users where ismgr = 0";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Users user = new Users();
				user.setFirstName(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));
				user.setUserName(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				employees.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	@Override
	public void viewPendingRequestsByMgr() {
	// A Manager can view all pending requests from all employees
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "select r.DESCRIPTION, r.SUBMIT_DATE, r.AMOUNT, u.FIRSTNAME || \" \" || u.LASTNAME as Name" + 
					" from Reimbursements r, R_Status s, Users u" + 
					" where r.status_id = s.status_id" + 
					" and r.SUBMITTER_ID = u.USERID" + 
					" and s.name = 'Pending'";
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
	public void viewResolvedRequestsByMgr() {
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
	public void viewPendingRequestsByEmp(int id) {
	// An Employee can view their pending reimbursement requests
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "select r.DESCRIPTION, r.SUBMIT_DATE, r.AMOUNT, u.FIRSTNAME || \" \" || u.LASTNAME as Name" + 
					" from Reimbursements r, R_Status s, Users u" + 
					" where r.status_id = s.status_id" + 
					" and r.SUBMITTER_ID = u.USERID" + 
					" and s.name = 'Pending'" + 
					" and u.userid = ?";
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

	@Override
	public void viewResolvedRequestsByEmp(int id) {
	// An Employee can view their resolved reimbursement requests
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "select r.DESCRIPTION, r.AMOUNT, r.SUBMIT_DATE, r.RESOLVED_DATE, u.FIRSTNAME || \" \" || u.LASTNAME as Resolver, r.RESOLUTION_NOTES" + 
					" from Reimbursements r, R_Status s, Users u" + 
					" where r.status_id = s.status_id" + 
					" and r.RESOLVER_ID = u.USERID" + 
					" and (s.name = 'Denied' OR s.name = 'Approved')" +
					" and userid = ?";
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
		
	@Override
	public void viewEmpRequest(int id) {
	// A Manager can view reimbursement requests from a single Employee (if isMgr = 1)
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "select r.DESCRIPTION, r.AMOUNT, r.SUBMIT_DATE, r.RESOLVED_DATE, s.NAME as Status, r.RESOLUTION_NOTES" + 
					" from Reimbursements r, R_Status s, Users u" + 
					" where r.status_id = s.status_id" + 
					" and r.SUBMITTER_ID = u.USERID" + 
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

	@Override
	public void viewEmployee(int id) {
	// An Employee can view their information
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "select firstname, lastname, email, username, password from users where userid = ?";
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

	@Override
	public boolean isMgr(int id) {
	// determine if person logging in is a manager or not
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "select * from users where userid = ? and isMgr = 1";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}

package com.project1.dao;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.project1.dto.DTO;
import com.project1.pojos.Reimbursements;
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
	public ArrayList<DTO> viewPendingRequestsByMgr() {
	// A Manager can view all pending requests from all employees
		ArrayList<DTO> dto = new ArrayList<>();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "select r.DESCRIPTION, to_char(r.SUBMIT_DATE, 'dd-MON-yyyy') as submit_date, " +
					" r.AMOUNT, u.FIRSTNAME || ' ' || u.LASTNAME as Employee" + 
					" from Reimbursements r, R_Status s, Users u" + 
					" where r.status_id = s.status_id" + 
					" and r.SUBMITTER_ID = u.USERID" + 
					" and s.name = 'Pending'";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				DTO r = new DTO();
				r.setEmployee(rs.getString("Employee"));
				r.setDescription(rs.getString("description"));
				r.setAmount(rs.getDouble("amount"));
				r.setSubmit_date(rs.getString("submit_date"));
				dto.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public void viewResolvedRequestsByMgr() {
	// A Manager can view all resolved requests from all employees and see which manager resolved it
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "select r.DESCRIPTION, r.AMOUNT, to_char(r.SUBMIT_DATE, 'dd-MON-yyyy') as submit_date," +
					" to_char(r.RESOLVED_DATE, 'dd-MON-yyyy') as resolved_date, " +
					" u.FIRSTNAME || ' ' || u.LASTNAME as Resolver, r.RESOLUTION_NOTES" + 
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
	public ArrayList<Reimbursements> viewPendingRequestsByEmp(int id) {
	// An Employee can view their pending reimbursement requests
		ArrayList<Reimbursements> reimbursements = new ArrayList<>();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "select r.DESCRIPTION, to_char(r.SUBMIT_DATE, 'dd-MON-yyyy') as submit_date, r.AMOUNT" + 
					" from Reimbursements r, R_Status s, Users u" + 
					" where r.status_id = s.status_id" + 
					" and r.SUBMITTER_ID = u.USERID" + 
					" and s.name = 'Pending'" + 
					" and u.userid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Reimbursements r = new Reimbursements();
				r.setDescription(rs.getString("description"));
				r.setSubmit_date(rs.getString("submit_date"));
				r.setAmount(rs.getDouble("amount"));
				reimbursements.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;
	}

	@Override
	public ArrayList<Reimbursements> viewResolvedRequestsByEmp(int id) {
	// An Employee can view their resolved reimbursement requests
		ArrayList<Reimbursements> reimbursements = new ArrayList<>();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "select r.DESCRIPTION, to_char(r.SUBMIT_DATE, 'dd-MON-yyyy') as submit_date, r.AMOUNT," + 
					" to_char(r.RESOLVED_DATE, 'dd-MON-YYYY') as resolved_date, " +
					" r.RESOLUTION_NOTES," +
					" s.STATUS_ID" +
					" from Reimbursements r, R_Status s, Users u" + 
					" where r.status_id = s.status_id" + 
					" and r.SUBMITTER_ID = u.USERID" + 
					" and (s.name = 'Approved' OR s.name = 'Denied')" + 
					" and u.userid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Reimbursements r = new Reimbursements();
				r.setDescription(rs.getString("description"));
				r.setSubmit_date(rs.getString("submit_date"));
				r.setAmount(rs.getDouble("amount"));
				r.setResolved_date(rs.getString("resolved_date"));
				r.setResolution_notes(rs.getString("resolution_notes"));
				r.setStatusID(rs.getInt("status_id"));
				reimbursements.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;
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

	@Override
	public void updateEmployee(int id, String fn, String ln, String em, String un, String pw) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			String sql = "update users set firstname = ?, lastname = ?, email = ?, username = ?, password = ? " +
						 " where userid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, fn);
			ps.setString(2, ln);
			ps.setString(3, em);
			ps.setString(4, un);
			ps.setString(5, pw);
			ps.setInt(6, id);
			ps.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

package com.project.one.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import com.project.one.pojos.Employee;
import com.project.one.pojos.Reimbursement;
import com.project.one.pojos.Status;
import com.project.one.util.ConnectionFactory;


public class DaoImpl {

	public String getEmployee(String usr) {
		String info = null;
		Connection connect = null;
		CallableStatement cs = null;
		try {
			connect = ConnectionFactory.getInstance().getConnection();
			String sql = "{? = call get_employee(?)}";
			cs = connect.prepareCall(sql);
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.setString(2, usr);
			cs.execute();
			info = cs.getString(1);
		}
		catch(SQLException e) {
			e.printStackTrace();	
		}
		finally {
			try {
				cs.close();
				connect.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return info;
	}

	public int addReimbursement(int empl, double amount, String desc) {
		int id =0;
		Connection connect;
		PreparedStatement ps;
		try {
			connect = ConnectionFactory.getInstance().getConnection();
			connect.setAutoCommit(false);
			String sql = "insert into reimbursement(Employee, amount, description) values (?,?,?)";
			String[] keys = {"ID"};
			ps = connect.prepareStatement(sql,keys);
			ps.setInt(1, empl);
			ps.setDouble(2, amount);
			ps.setString(3, desc);
			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			while(rs.next()) {
				id = rs.getInt(1);
			}
			connect.commit();
			ps.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

//	public ArrayList<Reimbursement> getRequests(int emplid) {
//		Connection connect;
//		PreparedStatement ps;
//		String info;
//		int id;
//		Employee mngr;
//		double amount;
//		String desc;
//		Date submitDate;
//		Status status;
//		Date rslv;
//		String reason;
//		Reimbursement rem;
//		ArrayList<Reimbursement> reqs = new ArrayList<Reimbursement>();
//		try {
//			connect = ConnectionFactory.getInstance().getConnection();
//			String sql = "select r.id, m.employeeid, m.firstname, m. lastname,"
//					+ "r.amount, r. description, r.submitdate, r.status, r.resolvedate, r. reason"
//					+ " from reimbursement r left join employee m on"
//					+ " m.employeeid = manager where employee = ?)";
//			ps = connect.prepareStatement(sql);
//			ps.setInt(1, emplid);
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()) {
//				id = rs.getInt(1);
//				mngr = new Employee(rs.getInt(2), rs.getString(3), rs.getString(4));
//				amount = rs.getDouble(5);
//				desc = rs.getString(6);
//				submitDate = rs.getDate(7);
//				status = new Status(rs.getInt(8));
//				rslv = rs.getDate(9);
//				reason = rs.getString(10);
//				rem = new Reimbursement(id,null, mngr, amount, desc, submitDate,status, rslv, reason);
//				reqs.add(rem);		
//				}
//			ps.close();
//		}
//		
//		catch(SQLException e) {
//			e.printStackTrace();
//		}
//		return reqs;
//	}

	public ArrayList<Reimbursement> getRequests() {
		Connection connect;
		Statement state;
		String info;
		int id;
		Employee mngr;
		Employee empl;
		double amount;
		String desc;
		Date submitDate;
		Status status;
		Date rslv;
		String reason;
		Reimbursement rem;
		ArrayList<Reimbursement> reqs = new ArrayList<Reimbursement>();
		try {
			connect = ConnectionFactory.getInstance().getConnection();
			String sql = "select r.id, e.employeeid, e.firstname, e.lastname, m.employeeid, m.firstname, m. lastname, "
					+ "r.amount, r. description, r.submitdate, r.status, r.resolvedate, r. reason"
					+ " from reimbursement r join employee e on e.employeeid = r.employee left join employee m on m.employeeid = manager";
			state = connect.createStatement();
			ResultSet rs = state.executeQuery(sql);
			while(rs.next()) {
				id = rs.getInt(1);
				empl = new Employee(rs.getInt(2), rs.getString(3), rs.getString(4));
				mngr = new Employee(rs.getInt(5), rs.getString(6), rs.getString(7));
				amount = rs.getDouble(8);
				desc = rs.getString(9);
				submitDate = rs.getDate(10);
				status = new Status(rs.getInt(11));
				rslv = rs.getDate(12);
				reason = rs.getString(13);
				rem = new Reimbursement(id, empl, mngr, amount, desc, submitDate,status, rslv, reason);
				reqs.add(rem);		
			}
			state.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return reqs;
	}

	public void updateEmpl(int id, String fn, String ln, String email, String pwd){
		Connection connect = null;
		CallableStatement cs = null;
		try {
			connect = ConnectionFactory.getInstance().getConnection();
			connect.setAutoCommit(false);
			String sql = "{call update_employee(?,?,?,?,?)}";
			cs = connect.prepareCall(sql);
			cs.setInt(1, id);
			cs.setString(2, fn);
			cs.setString(3, ln);
			cs.setString(4, email);
			cs.setString(5, pwd);
			cs.execute();
			connect.commit();
		}
		catch(SQLException e) {
			e.printStackTrace();	
		}
		finally {
			try {
				cs.close();
				connect.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}		
	}

	public void updateReimbursement(int id, int stat, int mngr, String reason) {
		Connection connect = null;
		CallableStatement cs = null;
		System.out.println(id+" "+stat+" "+mngr+" "+reason);
		try {
			connect = ConnectionFactory.getInstance().getConnection();
			connect.setAutoCommit(false);
			String sql = "{call update_reimbursement(?,?,?,?)}";
			cs = connect.prepareCall(sql);
			cs.setInt(1, id);
			cs.setInt(2, stat);
			cs.setInt(3, mngr);
			cs.setString(4, reason);
			cs.execute();
			connect.commit();
		}
		catch(SQLException e) {
			e.printStackTrace();	
		}
		finally {
			try {
				cs.close();
				connect.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}		
	}

	
	public ArrayList<Employee> getEmployees() {
		Connection connect;
		Statement state;
		String info;
		int id;
		String fn;
		String ln;
		String email;
		Employee empl;
		ArrayList<Employee> empls = new ArrayList<Employee>();
		try {
			connect = ConnectionFactory.getInstance().getConnection();
			String sql = "select employeeid, firstname, lastname, email from employee where ismanager = 0";
			state = connect.createStatement();
			ResultSet rs = state.executeQuery(sql);
			while(rs.next()) {
				id = rs.getInt("employeeid");
				fn = rs.getString("firstname");
				ln = rs.getString("lastname");
				email = rs.getString("email");
				empl = new Employee(id, fn, ln, email);
				empls.add(empl);		
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return empls;		
	}

	
	public void addEmployee(String fn, String ln, String email, String pwd, int mngr) {
		Connection connect;
		PreparedStatement ps;
		try {
			connect = ConnectionFactory.getInstance().getConnection();
			connect.setAutoCommit(false);
			String sql = "insert into employee(firstname, lastname, email, password, ismanager) values (?,?,?,?,?)";
			ps = connect.prepareStatement(sql);
			ps.setString(1, fn);
			ps.setString(2, ln);
			ps.setString(3, email);
			ps.setString(4, pwd);
			ps.setInt(5, mngr);
			ps.executeUpdate();
			connect.commit();
			ps.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}	
	}

}

package com.reimbursement.service;

import java.util.HashMap;

import com.reimbursement.dao.DAOsql;
import com.reimbursement.pojos.Reimbursement;
import com.reimbursement.pojos.ReimbursementStatus;
import com.reimbursement.pojos.User;

public class Service {

	private DAOsql dao = new DAOsql();
	
	public User validateEmail(String email) {
		return dao.getUser(email);
	}
	
	public void submitRequest(Reimbursement r) {
		dao.addRequest(r);
	}
	
	public int updateInfo(User u) {
		if (dao.getUser(u.getEmail()) != null)
			return -1;
		return dao.editUser(u);
	}
	
	public int resolveRequest(Reimbursement r) {
		return dao.resolveRequest(r);
	}
	
	public HashMap<Integer, User> getAllEmployees() {
		return dao.getAllEmployees();
	}
	
	public HashMap<Integer, Reimbursement> getRequestsByEmployee(User u) {
		return dao.getEmployeeReimbursements(u);
	}
	
	public HashMap<Integer, Reimbursement> getAllRequests() {
		return dao.getAllRequests();
	}
	
	public int registerEmployee(String fname, String lname, String email, String password, boolean isMgr) {
		return dao.addUser(fname, lname, email, password, isMgr);
	}
}

package com.reimbursement.service;

import java.util.ArrayList;
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
		return dao.editUser(u);
	}
	
	public int resolveRequest(int id, int status, String notes, int resolverId) {
		return dao.resolveRequest(id, status, notes, resolverId);
	}
	
	public ArrayList<User> getAllEmployees() {
		return dao.getAllEmployees();
	}
	
	public ArrayList<Reimbursement> getRequestsByEmployee(User u) {
		return dao.getEmployeeReimbursements(u);
	}
	
	public Reimbursement getReimbursementById(int id) {
		return dao.getReimbursementById(id);
	}
	
	public ArrayList<Reimbursement> getAllRequests() {
		return dao.getAllRequests();
	}
	
	public int registerEmployee(String fname, String lname, String email, String password, boolean isMgr) {
		return dao.addUser(fname, lname, email, password, isMgr);
	}
}

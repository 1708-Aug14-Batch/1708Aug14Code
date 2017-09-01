package com.reimbursement.service;

import com.reimbursement.dao.DAOsql;
import com.reimbursement.pojos.User;

public class Service {
	
	private DAOsql Dao = new DAOsql();
	
	public User validateEmail(String email) {
		return Dao.getUser(email);
	}
	
	public void validatePassword() {
		
	}
	
	public User login() {
		return null;
	}
	
	public void submitRequest() {
		
	}
	
	public void getPending() {
		
	}
	
	public void getResolved() {
		
	}
	
	public void updateInfo() {
		
	}
	
	public void resolveRequest() {
		
	}
	
	public void getAllPending() {
		
	}
	
	public void getAllResolved() {
		
	}
	
	public void getAllEmployees() {
		
	}
	
	public void getRequestsByEmployee() {
		
	}
	
	public void registerEmployee() {
		
	}
}

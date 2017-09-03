package com.reimbursement.service;


import java.util.ArrayList;

import com.reimbursement.dao.DAO;
import com.reimbursement.dao.DAOImpl;
import com.reimbursement.pojos.Reimbursement;
import com.reimbursement.pojos.User;


public class Service {
	
	
	static DAO test = new DAOImpl();
	
	
	public void submitReimbursement() {
		ArrayList<User> list = test.getUsers();
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		ArrayList<User> pass = test.getUsers();
		User temp = new User();
		for(User u: pass) {
			if(u.getUserId() == 1) {
				temp = new User(u.getUserId(), u.getFirstname(), u.getLastname(), u.getEmail(), u.getPassword(), u.getIsManager());
			}
		}
		
		test.ApproveOrDeny(2,23, "Denied. Try Again later");
		
	}
	
	

}

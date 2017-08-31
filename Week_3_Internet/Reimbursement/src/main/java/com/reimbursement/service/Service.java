package com.reimbursement.service;


import java.util.ArrayList;

import com.reimbursement.dao.DAO;
import com.reimbursement.dao.DAOImpl;
import com.reimbursement.pojos.User;


public class Service {
	
	
	static DAO test = new DAOImpl();
	
	
	public void submitReimbursement() {
		ArrayList<User> list = test.getUsers();
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		System.out.println(test.getUsers().toString());
	}
	
	

}

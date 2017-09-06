package com.reimbursement.service;


import java.util.ArrayList;

import com.reimbursement.dao.DAO;
import com.reimbursement.dao.DAOImpl;
import com.reimbursement.pojos.Reimbursement;
import com.reimbursement.pojos.User;


public class Service {
	
	String email;
	
	static DAO test = new DAOImpl();
	
	
	public void submitReimbursement() {
		ArrayList<User> list = test.getUsers();
		
		
		
		
		
	}
	
	public boolean checkEmail(String email) {
		ArrayList<User> list = test.getUsers();
		for(User u: list) {
			if(u.getEmail().equals(email)) {
				return true;
			}
		}
		return false;


	}

	public boolean checkPassword(String email, String password) {
		ArrayList<User> list = test.getUsers();
		for(User u: list) {
			if(u.getEmail().equals(email)) {
				if(u.getPassword().equals(password)) {
					
					return true;
				}
					
			}
		}
		return false;
	}
	
	//This is used to establish the User to pass through the session.
	//It uses the same checker as the username/password to set up the user.
	//When ran through a main method it properly creates the user.
	public User loginUser(String email) {
		ArrayList<User> list = test.getUsers();
		User user = new User();
		for(User u: list) {
			if(u.getEmail().equals(email)) {
				user.setUserId(u.getUserId());
				user.setFirstname(u.getFirstname());
				user.setLastname(u.getLastname());
				user.setEmail(u.getEmail());
				user.setPassword(u.getPassword());
				user.setIsManager(u.getIsManager());
				System.out.println(user.toString());
				return user;
			}
		}
		return null;
	}
	
	
	public static void main(String[] args) {
//		User temp = new User();
//		temp = loginUser("ctest123@gmail.com");
//		System.out.println(temp.toString());

	}
	
	

}

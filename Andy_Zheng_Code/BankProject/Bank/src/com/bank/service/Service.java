package com.bank.service;

import java.util.ArrayList;

import com.bank.dao.DAOImplementation;
import com.bank.pojos.Account;
import com.bank.pojos.User;

public class Service {

	private boolean loggedIn = false;
	
	static DAOImplementation dao = new DAOImplementation();
	
	//User u = new User();
	
	ArrayList<Account> accountList = new ArrayList<>();
	
	// validate email
	
	
	public User createUser(String fname, String lname, String email, String pwd) {
		
		int id = dao.addUser(fname,lname,email,pwd);
		User u = new User(fname,lname,email,pwd);
		return u;
	}
	
	public void login(String email, String pwd) {
		if(dao.getUser(email, pwd)!=null) {
			loggedIn = true;
			//u = dao.getUser(email, pwd);
		}else {
			System.out.println("User Not Found");
		}
	}
	
	public void showUserAccounts(int userID) {
		if(dao.getAccount(userID)!=null) {
			accountList = dao.getAccount(userID);	
		}else {
			System.out.println("No Accounts Found");
		}
	}
	
	public void logout() {
		loggedIn = false;
		dao = null;
		//u = null;
		accountList = null;
	}
	
	public void checkBalance(int num) {
		
	}
	
	
}

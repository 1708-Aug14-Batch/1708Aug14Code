package com.bank.service;

import com.bank.dao.Dao_TextImplementation;
import com.bank.pojos.User;

public class Service {

	private Dao_TextImplementation dao = new Dao_TextImplementation();
	private User user = null;
	private int AccountAmount = 0;
	
	public Service() {
		
	}
	
	public void manageAccount() {
		// TODO add account options
		System.out.println("You have logged on!");
	}
	
	public boolean attemptLogin(String username, String password) {
		int tempID = -1;
		if((tempID = dao.getUserID(username)) >= 0) {
			user = dao.getUser(tempID);
			if(user != null && user.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean checkAccounts(String username) {
		if(dao.getUsername(username)) {
			return true;
		}
		return false;
	}
	
	public void createUser(String firstname, String lastname, String username, String password, double balance) {
		AccountAmount = dao.getAccountAmount();
		user = new User(AccountAmount, firstname, lastname, username, password, balance);
		dao.addUser(user);
	}
	
}

package com.bank.service;

import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.bank.dao.DAOImplementation;
import com.bank.dao.DAOInterface;
import com.bank.pojos.Account;

public class Service {

	DAOImplementation dao = new DAOImplementation();
	
	private boolean loggedIn = false;
	Account user = new Account();
	
	public boolean createAccount(String fname, String lname, String email, String pwd) {
		
			
		Account user = new Account(dao.newID(),fname,lname,email,pwd);
		dao.addAccount(user);
		
		return true;
		
	}
	
	public void deleteAccount(String email, String pwd) {
		
	}
	
	public void login(String email, String pwd) {
		
		if(dao.getAccount(email, pwd)!=null) {
			setLoggedIn(true);	
			user = dao.getAccount(email, pwd);
			System.out.println("Welcome back " + user.getFname() + " " + user.getLname());
		}else {
			setLoggedIn(false);	
		}
	}
	
	public void logout() {
		user = null;
		setLoggedIn(false);
		System.out.println("You have logged out");	
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public BigDecimal getBalance() {
		
		return user.getBalance();
	}
	
	public BigDecimal withdraw(BigDecimal amt) {
		
		
		
		return null;
	}
	
	public BigDecimal deposit(BigDecimal amt) {

		return null;
	}
	
	// logging functionality
	// what do you want to do?
	
	// deposit/withdraw
	// change data
	
	
	
}

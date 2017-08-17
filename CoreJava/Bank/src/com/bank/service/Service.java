package com.bank.service;

import java.math.BigDecimal;
import com.bank.dao.DAOImplementation;
import com.bank.pojos.Account;

public class Service {
	
	DAOImplementation dao = new DAOImplementation();
	
	private boolean loggedIn = false;
	Account user = new Account();
	
	public boolean createAccount(String fname, String lname, String email, String pwd) {
		
		Account user = new Account(dao.newID(),fname,lname,email,pwd,new BigDecimal(0.00));
		dao.addAccount(user);
		
		return true;
	}
	
	public void deleteAccount(String email, String pwd) {
		dao.deleteAccount(email, pwd);
		setLoggedIn(false);
		System.out.println("Account Deleted");
	}
	
	public void changeFName(String fname) {
		user.setFname(fname);
		dao.editAccount(user);
		System.out.println("First Name Updated");
	}
	
	public void changeLName(String lname) {
		user.setLname(lname);
		dao.editAccount(user);
		System.out.println("Last Name Updated");
	}

	public void changeEmail(String email) {
		user.setEmail(email);
		dao.editAccount(user);
		System.out.println("Email Updated");
	}
	
	public void changePwd(String pwd) {
		user.setPwd(pwd);
		dao.editAccount(user);
		System.out.println("Password Updated");
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
		System.out.println("You Have Logged Out");	
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public void getBalance() {
		
		System.out.println("Your Current Balance is: " + user.getBalance());
	}
	
	public void withdraw(BigDecimal amt) {
		
		user.setBalance(user.getBalance().subtract(amt));
		System.out.println("You Have Withdrawn: " + amt);
		dao.editAccount(user);
	}
	
	public void deposit(BigDecimal amt) {

		user.setBalance(user.getBalance().add(amt));
		System.out.println("You Have Deposited: " + amt);
		System.out.println(user.toString());
		dao.editAccount(user);
	}
	
	// logging functionality
	// what do you want to do?
	
	// deposit/withdraw
	// change data
	
	
	
}

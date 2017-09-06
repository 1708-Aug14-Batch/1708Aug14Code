package com.revature.andy.service;

import java.util.HashSet;

import com.revature.andy.dao.DAOImplementation;
import com.revature.andy.pojos.Account;
import com.revature.andy.session.PseudoSession;

public class Service {

	static DAOImplementation dao = new DAOImplementation();
	
	
	// Create User
	public boolean createUser(String fname, String lname, String email, String pwd) {
		
		int x = dao.addUser(fname,lname,email,pwd);
		if(x > 1) {
			return true;
		}else {
			return false;
		}
	}
	
	// Create Account
	public boolean createAccount(int typeID) {
		int x = dao.addAccount(PseudoSession.getCurrentUser(), typeID);
		if(x > 1) {
			return true;
		}else {
			return false;
		}
	}
	
	// Get User Information from session
	public void getUser() {
		System.out.println(PseudoSession.getCurrentUser().toString());
	}
	
	// Get Accounts
	public HashSet<Account> getAccounts() {
		HashSet<Account> accountList = 	dao.getAccounts(PseudoSession.getCurrentUser());
		if(accountList.isEmpty()) {
			System.out.println("No Accounts");
			return null;
		}else {
			System.out.println("\n------------------------------------------------------------------------"); 
			for(Account x: accountList) {
				System.out.println(x.toString());
			}	
			System.out.println("------------------------------------------------------------------------");
			return accountList;
		}
	}
	
	// Change User info
	public boolean changeInformation(int position, String change) {
		
		position = position-1;
		
		switch(position) {
		case 1:
			PseudoSession.getCurrentUser().setFName(change);
			break;
		case 2:
			PseudoSession.getCurrentUser().setLName(change);
			break;
		case 3:
			PseudoSession.getCurrentUser().setEmail(change);
			break;
		case 4:
			PseudoSession.getCurrentUser().setPassword(change);
			break;
		default:
			return false;
		}
		
		int x = dao.updateUser(PseudoSession.getCurrentUser());
		if(x == 1) {
			return true;
		}else {
			return false;
		}
	}
	
	// Change Balance
	public boolean changeBalance(int accountID, double amt, boolean w) {
		if(w) {
			amt = amt * -1;
		}
		amt = amt + dao.getAccount(PseudoSession.getCurrentUser(), accountID).getBalance();
		if(amt < 0) {
			return false;
		}
		int x = dao.updateAccount(PseudoSession.getCurrentUser(), accountID, amt);
		if(x == 1) {
			return true;
		}else {
			return false;
		}
	}
	
	// Transfer Funds
	public boolean transferFunds(int accountID1, int accountID2, double amt) {
		
		int x;
		int y;
		
		// Check if enough to withdraw
		if(dao.getAccount(PseudoSession.getCurrentUser(), accountID2).getBalance()-amt < 0) {
			return false;
		}else {
			x =dao.updateAccount(PseudoSession.getCurrentUser(), accountID1, 
					dao.getAccount(PseudoSession.getCurrentUser(), accountID1).getBalance() + amt);
			y = dao.updateAccount(PseudoSession.getCurrentUser(), accountID2, 
					dao.getAccount(PseudoSession.getCurrentUser(), accountID2).getBalance() - amt);
			
		}
		
		if(x == 1 && y == 1) {
			return true;
		}else {
			return false;
		}
		
	}
	
	// Delete Account
	public boolean deleteAccount(int accountID) {
		int x = dao.deleteAccount(PseudoSession.getCurrentUser(), accountID);
		if(x == 1) {
			return true;
		}else {
			return false;
		}
	}
	
}

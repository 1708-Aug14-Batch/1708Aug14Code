package com.revature.andy.service;

import java.util.HashSet;

import com.revature.andy.dao.DAOImplementation;
import com.revature.andy.pojos.ReimStatus;
import com.revature.andy.pojos.Reimbursement;
import com.revature.andy.pojos.User;
import com.revature.andy.session.PseudoSession;

public class Service {

	static DAOImplementation dao = new DAOImplementation();
	boolean isLoggedIn = false;
	User currentUser = null;
	
	public int login(String email, String pwd) {
		currentUser = dao.getUser(email, pwd);
		if(currentUser != null && currentUser.getUserID()!=0){
			isLoggedIn = true;
			return 1;
		}else {
			return validateLogin(email);
		}
	}
	
	public int validateLogin(String email) {
		
		HashSet<User> users = dao.getUsers();
		
		for(User x:users) {
			if(x.getEmail().equalsIgnoreCase(email)) {
				return 2;
			}
		}
		return 0;
		}
	
	public void logout() {
		isLoggedIn = false;
		currentUser = null;
	}
	
	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
	
	public boolean getIsLoggedIn(){
		return isLoggedIn;
	}
	
	// Create User
	public boolean createUser(String fname, String lname, String email, String pwd, int isManager) {
		
		int x = dao.addUser(fname,lname,email,pwd,isManager);
		if(x > 1) {
			return true;
		}else {
			return false;
		}
	}
	
	// Create Reimbursement
	public boolean createReimbursement(User u, String description, int amount) {
		int x = dao.addReimbursement(PseudoSession.getCurrentUser(), description, amount);
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
	
	public HashSet<User> getAllUsers(){
		return dao.getUsers();
	}
	
	// Get User's Reimbursements
	public boolean getUserReimbursement(int userID) {
		HashSet<Reimbursement> userReims = dao.getReimbursement(userID);
		
		return false;
	}
	
	// Get Reimbursements of certain status
	public boolean getReimbursementsOfStatus(int statusID) {
		HashSet<Reimbursement> reimOfStatus = dao.getReimbursements(statusID);
		
		return false;
	}
	
	// Get User's Reimbursements by status
	public boolean getUserReimbursementOfStatus(int userID, int statusID ) {
		HashSet<Reimbursement> userReimOfStatus = dao.getUserReimbursements(userID, statusID);
		
		return false;
	}
	
	// Update user information
	public boolean updateUserInfo(int position, String change) {

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
			/* promotion?
		case 5:
			PseudoSession.getCurrentUser().setIsManager(change);
			*/
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
	
	public boolean updateReimbursements(int reimID, int statusID, String notes) {
		
		int x = dao.updateReimbursement(reimID, PseudoSession.getCurrentUser(), dao.getReimStatusFromID(statusID), notes);
		if(x == 1) {
			return true;
		}else {
			return false;
		}
	}
	
	/*
	
	// Get Accounts
	public void getAccounts() {
		HashSet<Reimbursement> accountList = 	dao.getAccounts(PseudoSession.getCurrentUser());
		if(accountList.isEmpty()) {
			System.out.println("No Accounts");
		}else {
			System.out.println("\n------------------------------------------------------------------------"); 
			for(Reimbursement x: accountList) {
				System.out.println(x.toString());
			}	
			System.out.println("------------------------------------------------------------------------");
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
	
	*/
}

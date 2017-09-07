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
	
	public User getUserByID(int userID) {
		return dao.getUser(userID);
	}

/*
	public User getCurrentUser() {
		return currentUser;
	}
	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
	*/
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
		int x = dao.addReimbursement(u, description, amount);
		if(x > 1) {
			return true;
		}else {
			return false;
		}
	}
	
	/*
	// Get User Information from session
	public void getUser() {
		System.out.println(PseudoSession.getCurrentUser().toString());
	}
	*/
	
	public HashSet<User> getAllUsers(){
		return dao.getUsers();
	}
	
	// Get User's Reimbursements
	public HashSet<Reimbursement> getUserReimbursement(int userID) {
		HashSet<Reimbursement> userReims = dao.getReimbursement(userID);
		
		return userReims;
	}
	
	// Get Reimbursements of certain status
	public HashSet<Reimbursement> getReimbursementsOfStatus(int statusID) {
		HashSet<Reimbursement> reimOfStatus = dao.getReimbursements(statusID);
		
		return reimOfStatus;
	}
	
	// Get User's Reimbursements by status
	public HashSet<Reimbursement> getUserReimbursementOfStatus(int userID, int statusID ) {
		HashSet<Reimbursement> userReimOfStatus = dao.getUserReimbursements(userID, statusID);
		
		return userReimOfStatus;
	}
	
	// Update user information
	public boolean updateUserInfo(User u, int position, String change) {

		position = position-1;
		
		switch(position) {
		case 1:
			u.setFName(change);
			break;
		case 2:
			u.setLName(change);
			break;
		case 3:
			u.setEmail(change);
			break;
		case 4:
			u.setPassword(change);
			break;
			/* promotion?
		case 5:
			PseudoSession.getCurrentUser().setIsManager(change);
			*/
		default:
			return false;
		}
		
		int x = dao.updateUser(u);
		if(x == 1) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean updateReimbursements(int reimID, User u, int statusID, String notes) {
		
		int x = dao.updateReimbursement(reimID, u, dao.getReimStatusFromID(statusID), notes);
		if(x == 1) {
			return true;
		}else {
			return false;
		}
	}
}

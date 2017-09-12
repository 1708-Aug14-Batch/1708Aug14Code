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
	
	public User login(String email, String pwd) {
		
		User newUser = null;
		return newUser = dao.getUser(email, pwd);}
	
	public int validateLogin(String email, String pwd) {
		
		HashSet<User> users = dao.getUsers();
		for(User x:users) {
			if(x.getEmail().equalsIgnoreCase(email)) {
				if(login(email, pwd) == null){
					return 2;
				}else{
					return 1;
				}
			}
		}
		return 0;
	}
	
	public User getUserByID(int userID) {
		return dao.getUser(userID);
	}

	public boolean getIsLoggedIn(){
		return isLoggedIn;
	}
	
	// Create User
	public boolean createUser(User user) {
		
		int x = dao.addUser(user);
		if(x > 1) {
			return true;
		}else {
			return false;
		}
	}
	
	// Create Reimbursement
	public boolean createReimbursement(User u, String description, double amount) {
		int x = dao.addReimbursement(u, description, amount);
		if(x > 1) {
			return true;
		}else {
			return false;
		}
	}
		
	public HashSet<User> getAllUsers(){
		return dao.getUsers();
	}
	
	public HashSet<Reimbursement> getReimbursements(){
		HashSet<Reimbursement> reims = dao.getReims();
		return reims;
	}
	
	// Get User's Reimbursements
	public HashSet<Reimbursement> getUserReimbursement(int userID) {
		HashSet<Reimbursement> userReims = dao.getUserReim(userID);
		
		return userReims;
	}
	
	// Get Reimbursements of certain status
	public HashSet<Reimbursement> getReimbursementsOfStatus(int statusID) {
		HashSet<Reimbursement> reimOfStatus = dao.getStatusReim(statusID);
		
		return reimOfStatus;
	}
	
	// Get User's Reimbursements by status
	public HashSet<Reimbursement> getUserReimbursementOfStatus(int userID, int statusID ) {
		HashSet<Reimbursement> userReimOfStatus = dao.getUserStatusReim(userID, statusID);
		
		return userReimOfStatus;
	}
	
	// Update user information
	public boolean updateUserInfo(User u) {
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
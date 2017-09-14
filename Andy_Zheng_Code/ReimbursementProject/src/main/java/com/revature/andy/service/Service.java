package com.revature.andy.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;

import com.revature.andy.dao.DAOImplementation;
import com.revature.andy.pojos.Reimbursement;
import com.revature.andy.pojos.User;
import com.revature.andy.util.ConnectionFactory;

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
		
	public HashSet<User> getEmployees(){
		return dao.getEmployees();
	}
	
	public HashSet<Reimbursement> getReimbursements(){
		Connection con = ConnectionFactory.getInstance().getConnection();
		HashSet<Reimbursement> reims;
		try {
			reims = dao.getReims(con);
			return reims;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
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
	
	public boolean updateReimbursements(int reimID, User u, String status, String notes) {
		
		int statusID = 0;
		if(status.equals("Pending")) {
			statusID = 0;
		}else if(status.equals("Approved")) {
			statusID = 1;
		}else if(status.equals("Denied")) {
			statusID = 2;
		}
		int x = dao.updateReimbursement(reimID, u, dao.getReimStatusFromID(statusID), notes);
		if(x == 1) {
			return true;
		}else {
			return false;
		}
	}
}

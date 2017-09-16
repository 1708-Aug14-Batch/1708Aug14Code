package com.revature.andy.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;

import org.apache.log4j.Logger;

import com.revature.andy.dao.DAOImplementation;
import com.revature.andy.pojos.Reimbursement;
import com.revature.andy.pojos.User;
import com.revature.andy.util.ConnectionFactory;

public class Service {

	final static Logger log = Logger.getLogger(Service.class);
	
	static DAOImplementation dao = new DAOImplementation();
	
	public User login(String email, String pwd) {
		
		User newUser = null;
		newUser = dao.getUser(email, pwd);
		log.debug("Login User\t" + newUser);
		return newUser;
	}
	
	public int validateLogin(String email, String pwd) {
		
		HashSet<User> users = dao.getUsers();
		for(User x:users) {
			if(x.getEmail().equalsIgnoreCase(email)) {
				log.debug("Database Email \t" + x.getEmail());
				log.debug("User Email\t" + email);
				if(login(email, pwd) == null){
					log.debug("Login Valid\t" + login(email,pwd));
					return 2;
				}else{
					log.debug("Invalid Password\t"+ login(email,pwd));
					return 1;
				}
			}
		}
		log.debug("Invalid Credentials\t");
		return 0;
	}
	
	public User getUserByID(int userID) {
		log.debug("User by Id\t" + dao.getUser(userID));
		return dao.getUser(userID);
	}
	
	// Create User
	public boolean createUser(User user) {
		log.debug("User to Create\t" + user);
		int x = dao.addUser(user);
		if(x > 1) {
			log.debug("User Created");
			return true;
		}else {
			log.debug("User Creation Failed");
			return false;
		}
	}
	
	// Create Reimbursement
	public boolean createReimbursement(User u, String description, double amount) {
		log.debug("Reimbursement User\t" + u);
		log.debug("Reimbursement Description\t" + description);
		log.debug("Amount\t" + amount);
		int x = dao.addReimbursement(u, description, amount);
		if(x > 1) {
			log.debug("Reimbursement Created");
			return true;
		}else {
			log.debug("Reimbursement Created Failed");
			return false;
		}
	}
		
	public HashSet<User> getEmployees(){
		log.debug("Employees");
		for(User e: dao.getEmployees()) {
			log.debug(e);
		}
		return dao.getEmployees();
	}
	
	public HashSet<Reimbursement> getReimbursements(){
		Connection con = ConnectionFactory.getInstance().getConnection();
		HashSet<Reimbursement> reims;
		try {
			reims = dao.getReims(con);
			log.debug("Reimbursements");
			for(Reimbursement r: reims) {
				log.debug(r);
			}
			return reims;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// Get User's Reimbursements
	public HashSet<Reimbursement> getUserReimbursement(int userID) {
		HashSet<Reimbursement> userReims = dao.getUserReim(userID);

		log.debug("User's Reimbursements");
		for(Reimbursement r: userReims) {
			log.debug(r);
		}
		
		return userReims;
	}

	// Update user information
	public boolean updateUserInfo(User u) {
		log.debug("User Update Info\t" + u);
		int x = dao.updateUser(u);
		if(x == 1) {
			log.debug("User Updated");
			return true;
		}else {
			log.debug("User Update Failed");
			return false;
		}
	}
	
	public boolean updateReimbursements(int reimID, User u, String status, String notes) {
		log.debug("");
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
			log.debug("Reimbursement Updated");
			return true;
		}else {
			log.debug("Reimbursement Update Failed");
			return false;
		}
	}
	
	/* Not used
	 * 
	
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
	 * 
	 */
}

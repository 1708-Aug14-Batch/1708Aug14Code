package com.pone.service;

import java.util.ArrayList;

import com.pone.dao.DAOImpl;
import com.pone.pojos.AUser;
import com.pone.pojos.Reimbursement;

public class Service {

	DAOImpl dao = new DAOImpl();
	// create an array list of the reimbursements
	// create an array list of the users
	// create an array list of the reimbursement types?
	
	
	/*
	 * Methods for propogating all of the 3 array lists
	 */
	
	
	
	/*
	 * username to id
	 */
	public int getUID(String userName) {
		int uid = dao.nameToId(userName);
		return uid;
	}
	
	
	
	/*
	 * Validate User
	 */
	public int validateUser(String userName) {
		int theUid = dao.nameToId(userName);
		if(theUid>0) {
			return theUid;
		}
		else {
			return -1;
		}
	}
	
	
	
	/*
	 * Login
	 */
	public AUser login(int theUid,String password) {
		if(theUid>0) {
			AUser theUser = dao.getAUser(theUid);
			if(theUser.getU_id()==theUid&&theUser.getPassword().equals(password)) {
				return theUser;
			}
		}
		return null;
	}
	
	
	
	/*
	 * addUser
	 */
	public AUser addUser(String fn,String ln, String userName, String email, String password) {
		int id = dao.addUser(fn, ln, userName, email, password);
		AUser au = new AUser(fn,ln,userName,email,password);
		au.setU_id(id);
		au.setIsManager(0);
		return au;
	}
	
	
	
	/*
	 * addReimbursement
	 */
	public Reimbursement addReimbursement(int submitterId,String description, double amount) {
		Reimbursement rem = dao.addReimbursement(submitterId, description, amount);
		return rem;
	}
	
	
	
	/*
	 * addReimbursementType
	 */
	
	
	
	/*
	 * Edit a user methods
	 */
	
	
	
	/*
	 * Get methods for whatever aspects of whatever
	 */
	
	
	
	/*
	 * Get user/request/reimbursementtype - use the arrays to get an individual one
	 */
	
	/////////////////////////// DO ////////////////////////////
	// getUserReimbursements
	public ArrayList<Reimbursement> getUserReimbursements(AUser theUser){
		ArrayList<Reimbursement> theReimbursements = dao.getUserReimbursements(theUser.getU_id());;
		return theReimbursements;
	}
	
	public ArrayList<Reimbursement> getAllReimbursements(){
		ArrayList<Reimbursement> allReimbursements = dao.allReimbursements();
		return allReimbursements;
	}
	
	
	
}

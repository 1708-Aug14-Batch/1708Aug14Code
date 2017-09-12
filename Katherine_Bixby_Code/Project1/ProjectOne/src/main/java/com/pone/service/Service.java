package com.pone.service;

import java.util.ArrayList;

import com.pone.dao.DAOImpl;
import com.pone.pojos.AUser;
import com.pone.pojos.RStatus;
import com.pone.pojos.Reimbursement;

public class Service {

	DAOImpl dao = new DAOImpl();
	static ArrayList<Reimbursement> reimbArr;
	static ArrayList<AUser> userArr;
	static ArrayList<RStatus> statArr;
	
	
	
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
	 * Edit Reimbursement Methods
	 */
	public void editResolverId(int resId, int solverId) {
		dao.editResolverId(resId, solverId);
	}
	public void  editResolveDate(int resId) {
		dao.editResolveDate(resId);
	}
	public void editStatusId(int resId, int statId) {
		dao.editStatusId(resId, statId);
	}
	public void editResolveNotes(int resId,String resNotes) {
		dao.editResolveNotes(resId, resNotes);
	}
	
	
	/*
	 * Edit a user methods
	 */
	public void editFirstName(int theUID, String newFn) {
		dao.editFirstName(theUID, newFn);
	}
	public void editLastName(int theUID, String newLn) {
		dao.editLastName(theUID, newLn);
	}
	public void editUserName(int theUID, String newUName) {
		dao.editUserName(theUID, newUName);
	}
	public void editEmail(int theUID, String email) {
		dao.editEmail(theUID, email);
	}
	public void editPassword(int theUID, String password) {
		dao.editPassword(theUID, password);
	}
	
	
	
	/*
	 * 
	 */
	public String idToName(int theUID) {
		userArr = dao.getAllUsers();
		String fullName = "";
		for(AUser i:userArr) {
			if(i.getU_id()==theUID) {
				fullName = i.getFirstName()+" "+i.getLastName();
			}
		}
		return fullName;
	}
	
	
	
	/*
	 * Get user/request/reimbursementtype - use the arrays to get an individual one
	 */
	public AUser getUser(int theUID) {
		AUser theUser = dao.getAUser(theUID);
		//System.out.println("The User: "+theUser.toString());
		return theUser;
	}
	
	// getUserReimbursements
	public ArrayList<Reimbursement> getUserReimbursements(AUser theUser){
		ArrayList<Reimbursement> theReimbursements = dao.getUserReimbursements(theUser.getU_id());;
		return theReimbursements;
	}
	
	public ArrayList<Reimbursement> getAllReimbursements(){
		ArrayList<Reimbursement> allReimbursements = dao.allReimbursements();
		return allReimbursements;
	}
	
	public ArrayList<RStatus> getReimbursementStatuses(){
		ArrayList<RStatus> allStatus = dao.getReimbursementStatuses();
		return allStatus;
	}
	
	
	
}

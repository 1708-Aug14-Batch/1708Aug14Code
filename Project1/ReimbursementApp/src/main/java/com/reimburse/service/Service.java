package com.reimburse.service;

import java.util.ArrayList;

import com.reimburse.dao.DAO;
import com.reimburse.dao.ReimburseDAO;
import com.reimburse.pojos.Reimbursement;
import com.reimburse.pojos.User;

public class Service {

	/*
	 * The logic before the information is passed to DAO.
	 * Functionality with the user.
	 * 
	 */

	private DAO dao; 

	public Service(){
		dao = new ReimburseDAO();
	}

	/*
	 * add a new user to users if username is available
	 * return id = -1 if user not found
	 */
	public User addUser(User user){
		int id  = dao.addUser(user);
		user.setUserId(id);
		return user;
	}
	
	/*
	 * get the user with a particular id
	 * empty user if not found
	 */
	public User getUser(int id) {
		User user = dao.getUser(id);
		return user;
	}
	
	/*
	 * find user with given username and password
	 * return user if found
	 * empty user if not found
	 */
	public User getUser(String username, String password){
		User user = dao.getUser(username, password);
		//return null if none found
		return user;
	}
	
	/*
	 * find user with given email and password
	 * return user if found
	 * empty user if not found
	 */
	public User getUserUseEmail(String email, String password){
		User user = dao.getUserUseEmail(email, password);
		//return null if none found
		return user;
	}
	
	/*
	 * find if username exists in db
	 */
	public boolean existsUsername(String username){
		//return null if none found
		return dao.existsUsername(username);
	}
	
	/*
	 * find if email exists in db
	 */
	public boolean existsEmail(String email){
		//return null if none found
		return dao.existsEmail(email);
	}
	
	
	/*
	 * update info functions
	 */

	public void updateUser(User user){
		//get user from all users, then change info, then rewrite
		dao.updateUser(user);
	};
	
	/*
	 * Delete user
	 */
	public void deleteUser(User user){
		dao.deleteUser(user);
	}
	
	/*
	 * Get All employees in db (isManager = 0)
	 */
	public ArrayList<User> getAllEmployees(){
		return dao.getAllEmployees();
	}
	
	/*
	 * Get reimbursement functions
	 */
	
	public ArrayList<Reimbursement> getEmployeeReimbursements(int userid){
		return dao.getEmployeeReimbursements(userid);
	}
	public ArrayList<Reimbursement> getEmployeePendingReimbursements(int userid){
		return dao.getEmployeePendingReimbursements(userid);
	}
	public ArrayList<Reimbursement> getEmployeeResolvedReimbursements(int userid){
		return dao.getEmployeeResolvedReimbursements(userid);
	}
	public ArrayList<Reimbursement> getAllPending(){
		return dao.getAllPending();
	}
	public ArrayList<Reimbursement> getAllResolved(){
		return dao.getAllResolved();
	}
	
	/*
	 * Singular reimbursement functions, add/get/resolve/delete
	 */
	public Reimbursement getReimbursement(int id){
		return dao.getReimbursement(id);
	}
	public int addReimbursement(Reimbursement r){
		return dao.addReimbursement(r);
	}
	public void resolveReimbursement(Reimbursement r){
		dao.resolveReimbursement(r);
	}
	public void deleteReimbursement(Reimbursement r){
		dao.deleteReimbursement(r);
	}
}

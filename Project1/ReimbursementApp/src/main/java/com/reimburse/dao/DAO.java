package com.reimburse.dao;

import java.util.ArrayList;

import com.reimburse.pojos.Reimbursement;
import com.reimburse.pojos.User;

public interface DAO {

	/*
	 * The contract we make for the information that
	 * we will need to send to and receive from the data source.
	 * 
	 */

	int addUser(User user); //add a new user to users table
	void deleteUser(User user); //remove user from users table
	ArrayList<User> getAllEmployees(); //returns all employees
	User getUser(int id); //get user object based on id
	User getUser(String usr, String pwd); //get user based on username, password
	User getUserUseEmail(String email, String pwd); //get user based on email, password
	boolean existsUsername(String username); //checks for existing username
	boolean existsEmail(String email); //checks for existing email
	void updateUser(User user); //updates user in DB with the user object sent
	
	int addReimbursement(Reimbursement r);  //add new reimbursement
	Reimbursement getReimbursement(int id); //get a reimbursement based on id
	ArrayList<Reimbursement> getEmployeeReimbursements(int userID); //get all reimbursements via employee ID
	ArrayList<Reimbursement> getEmployeePendingReimbursements(int userID); //get pending reimbursements via employee ID
	ArrayList<Reimbursement> getEmployeeResolvedReimbursements(int userID); //get resolved reimbursements via employee ID
	ArrayList<Reimbursement> getAllPending(); //returns all pending reimbursements
	ArrayList<Reimbursement> getAllResolved(); //returns all pending reimbursements
	void resolveReimbursement(Reimbursement r); //takes reimbursement and updates info within table
	void deleteReimbursement(Reimbursement r); //remove this reimbursement from table
	
	
}

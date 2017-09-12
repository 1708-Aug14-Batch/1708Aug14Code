package com.Reburse.dao;

import java.util.ArrayList;

import com.Reburse.pojos.Reimbursement;
import com.Reburse.pojos.User;

public interface DAO {

	public User getUserByID(int id);
	public User getUser(String email, String password);
	public ArrayList<User> getAllUsers();
	public boolean addUser(User u);
	public boolean updateUser(User u);
	public ArrayList<Reimbursement> getUserReimbursements(User u);
	public ArrayList<Reimbursement> getAllReimbursements();
	public boolean addReimbursement(int SubID, String desc, double Amt);
	public boolean updateReimbursement(Reimbursement r);
	public ArrayList<String> getAllEmails();
	
}

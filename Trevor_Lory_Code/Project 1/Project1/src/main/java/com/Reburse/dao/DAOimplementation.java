package com.Reburse.dao;

import java.util.ArrayList;

import com.Reburse.pojos.Reimbursement;
import com.Reburse.pojos.User;

public class DAOimplementation implements DAO {

	public User getUserByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public User getUser(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean addUser(User u) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean updateUser(User u) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<Reimbursement> getUserReimbursements(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Reimbursement> getAllReimbursements() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addReimbursement(Reimbursement r) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateReimbursement(Reimbursement r) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<String> getAllEmails() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

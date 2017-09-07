package com.reimburse.services;

import java.util.ArrayList;
import java.util.HashMap;

import com.reimburse.dao.DAO;
import com.reimburse.dao.DAOImpl;
import com.reimburse.pojos.Reimbursement;
import com.reimburse.pojos.User;

public class Services {
	
	DAO dao = new DAOImpl();
	
	public int validateUser(String email){
		int id = -1;
		HashMap<Integer, String> users = dao.getEmails();
		for(Integer n: users.keySet()){
			if(users.get(n).equalsIgnoreCase(email)){
				id = n;
			}
		}
		
		return id;
		
	}
	
	
	public User login(int id, String pwd){
		User u = dao.getUserById(id);
		if(u.getPassword().equalsIgnoreCase(pwd)){
			return u;
		}
		else
			return null;
	}
	
	public User addUser(User u){
		int id = dao.addUser(u.getFirstname(), u.getLastname(), u.getEmail(), u.getPassword());
		u.setId(id);
		return u;
		
	}
	
	public Reimbursement addReimbursement(User u, String desc, double amt){
		return dao.addReimbursement(u, desc, amt);
	}
	
	public ArrayList<Reimbursement> getUserReimbursement(User u){
		return dao.getReimburseByUser(u);
	}
}
 
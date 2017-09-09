package com.resort.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.resort.dao.ReimburseDAO;
import com.resort.dao.ReimburseDAOImpl;
import com.resort.dao.UserDAO;
import com.resort.dao.UserDAOImpl;
import com.resort.pojos.Reimbursement;
import com.resort.pojos.User;

public class Service {
	
	private static UserDAOImpl udao;
	private static ReimburseDAOImpl rdao; 
	
	//this is known as dependency injection in a constructor
	public Service(UserDAOImpl udao, ReimburseDAOImpl rdao) {
		this.udao = udao;
		this.rdao = rdao; 
	}
	
	/*
	 * Returns -1 if user is not found
	 * Otherwise returns the user id
	 */
	public int validateUser(String email){
		
		int id = -1;
		HashMap<Integer, String> users = udao.getEmails();

		for(Integer n:users.keySet()){
			if(users.get(n).equalsIgnoreCase(email)){
				id = n;
			}
		}

		return id;
	}
	
	/*
	 * 
	 */
	public User login(int id, String pass){
		User u = udao.getUserById(id);
		if(u.getPassword().equalsIgnoreCase(pass)){
			return u;
		}
		else return null;
	}
	
	public User addUser(User u){
		if(u.getEmail().equals("") || u.getFirstname().equals("") || u.getLastname().equals("") || u.getPassword().equals("")) {
			return null;
		}
		else {
		int id = udao.addUser(u.getFirstname(), u.getLastname(), u.getEmail(), u.getPassword());
		u.setUserid(id);
		return u;
		}
	}
	
	public int addReimbursement(User u, double amount, int rtype){
		return rdao.addReimbursement(u.getUserid(), amount, rtype);
	}
	
	public int addReasonReimbursement(User u, String reason, double amount, int rtype){
		return rdao.addDetailReimbursement(u.getUserid(), reason, amount, rtype);
	}
	
	public void updateReimbursement(int rid, int nstat, User u) {
		rdao.updateReimbursementStatus(rid, nstat, u.getUserid());
	}
	
	public void updateReimbursementNote(int rid, String notes) {
		rdao.updateReimbursementNotes(rid, notes);
	}
	
	public User getUser(int id) {
		return udao.getUserById(id);
	}
	
	public ArrayList<User> getUsers() {
		return udao.getUsers();
	}

	public ArrayList<Reimbursement> getUserReimbursements(User u, int uid) {
		if (u.getIsManager() == 0) {
				return rdao.getUserReimbursements(u.getUserid());
		}
			return rdao.getUserReimbursements(uid);
	}
	
}

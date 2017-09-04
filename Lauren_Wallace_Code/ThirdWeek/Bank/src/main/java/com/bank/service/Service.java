package com.bank.service;

import java.util.HashMap;

import com.bank.dao.DAO;
import com.bank.dao.DAOImpl;
import com.bank.pojos.User;

import oracle.net.aso.u;
//import com.ex.pojos.User;

public class Service {
	
	private static DAO dao = new DAOImpl();
	
	/* 
	 * Creates a Service object that will be called in BankRun
	 * The service object creates a new DAOImpl object
	 * The DAOImpl object will communicate the following changes
	 * - adding user/account - updating user/account(s)
	 * to the Bank DataBase (DB)  
	 */
	
	public Service() {
	}
	
	/*
	 * Returns -1 if user is not found
	 * Otherwise returns the user id
	 * 
	 */
	public int validateUser(String email){
		int id = -1;
		HashMap<Integer, String> users = dao.getEmails();

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
		User u = dao.getUserById(id);
		if(u.getPassword().equalsIgnoreCase(pass)){
			return u;
		}
		else return null;
	}

}

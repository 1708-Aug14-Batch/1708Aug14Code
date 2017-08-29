package com.bank.service;

import java.util.HashMap;

import com.bank.dao.DAO;
import com.bank.dao.DAOImpl;
import com.bank.pojos.User;

public class Service {

	static DAO dao = new DAOImpl();

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

	public User login(int id, String pass){
		User u = dao.getUserById(id);
		if(u.getPassword().equalsIgnoreCase(pass)){
			return u;
		}
		else return null;
	}

}

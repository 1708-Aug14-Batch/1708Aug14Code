package com.bank.service;

import com.bank.dao.DAO;
import com.bank.dao.DAOImpl;
import com.bank.pojos.User;

public class Service {
	
	static DAO dao = new DAOImpl();

	public User addUser(String fn, String ln, String email, String pass){
		// validate email address
		int id = dao.addUser(fn, ln, email, pass);
		User u = new User(fn, ln, email, pass);
		u.setId(id);
		return u;
	}
}

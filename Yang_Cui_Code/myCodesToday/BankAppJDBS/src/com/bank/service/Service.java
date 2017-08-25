package com.bank.service;

import com.bank.dao.DAO;
import com.bank.dao.DaoImpl;
import com.bank.pojos.User;

public class Service {
	
	static public DAO dao = new DaoImpl();
	// login functionality
	// what do you want to do functionality
	public User addUser(String fn, String ln, String email, String pwd){
		int id =dao.addUser(fn, ln, email, pwd);
		User u=new User(id,fn,ln,email,pwd);
		return null;
	}
}

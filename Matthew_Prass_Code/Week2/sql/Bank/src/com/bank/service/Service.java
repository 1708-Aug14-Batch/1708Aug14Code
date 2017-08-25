package com.bank.service;

import com.bank.daoimpl.DaoImpl;
import com.bank.pojos.User;

import Dao.DAO;

public class Service 
{
	static DAO dao = new DaoImpl();

	public User addUser(String fn,String ln,String email,String pw) {
		//validate email
		int id   = dao.addUser(fn, ln, email, pw);
		User u = new User(fn,ln,email,pw);
		u.setId(id);
		return u;
	}
}

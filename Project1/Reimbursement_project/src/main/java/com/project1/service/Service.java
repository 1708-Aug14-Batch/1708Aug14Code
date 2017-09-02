package com.project1.service;

import com.project1.dao.DAO;
import com.project1.dao.DaoImpl;

public class Service {
	static int id;
	DAO dao = new DaoImpl();

	public int validateUser(String username, String pw) {
		id = dao.getUserID(username, pw);
		System.out.println("the userid from service is: " + id);
		return id;
	}


	public void logout() {
//		System.out.println("Logging out, Bye");
//		login = false;
	}

}

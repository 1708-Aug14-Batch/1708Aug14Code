package com.project1.service;

import org.apache.log4j.Logger;

import com.project1.dao.DAO;
import com.project1.dao.DaoImpl;

public class Service {
	static int id;
	final static Logger logger = Logger.getLogger(Service.class);
	DAO dao = new DaoImpl();

	public int validateUser(String username, String pw) {
		id = dao.getUserID(username, pw);
		logger.info("An attempt to validate user login was made. (username: " + username + ")");
		return id;
	}
	
	public boolean isMgr(int id) {
		return dao.isMgr(id);
	}


	public void logout() {
//		System.out.println("Logging out, Bye");
//		login = false;
	}

}

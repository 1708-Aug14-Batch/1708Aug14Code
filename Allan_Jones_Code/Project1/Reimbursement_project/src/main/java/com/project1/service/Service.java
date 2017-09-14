package com.project1.service;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.project1.dao.DAO;
import com.project1.dao.DaoImpl;
import com.project1.pojos.Users;

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
	
	public boolean registerEmp(String fn, String ln, String un, String email) {
		return dao.registerEmp(fn, ln, un, email);
	}
	
	public Users getUser(int id) {
		return dao.getUser(id);
	}
	
	public ArrayList<Users> getEmployees() {
		return dao.viewAllEmp();
	}
	
	public void submitRequest(int submitterid, String description, double amt) {
		dao.submitRequest(submitterid, description, amt);
	}

}

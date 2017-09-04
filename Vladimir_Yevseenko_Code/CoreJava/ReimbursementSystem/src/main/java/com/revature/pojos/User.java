package com.revature.pojos;

import org.apache.log4j.Logger;

import com.revature.logging.Logging;

public class User {
	private int id;
	private String first, last, email, password;
	boolean isManager;
	
	private static Logger log = Logging.getLogger();
	
	public User() {
		log.debug("User() created");
	}
	
	public User(int id, String first, String last, String email, String password, boolean isManager) {
		this.id = id;
		this.first = first;
		this.last = last;
		this.email = email;
		this.password = password;
		this.isManager = isManager;
		log.debug("User(...) created");
	}
	
	public int getId() {
		return id;
	}
	
	public String getFirst() {
		return first;
	}
	
	public String getLast() {
		return last;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public boolean getIsManager() {
		return isManager;
	}
}

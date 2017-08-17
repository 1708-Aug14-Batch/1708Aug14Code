package com.bank.dao;

import java.util.ArrayList;

import com.bank.pojos.User;

public interface DAO {
	
	// The contract we make for the information that
	// we will need to send to and receive from the data source
	
	// addUser
	// editUser - change fn, ln, email, PW, or balance
	// getuser
	
	public void addUser(User user);
	
	public void editUser(User user);
	
	public ArrayList<User> getUser(User user);
	
	public int getUserID(String fn, String ln);
}
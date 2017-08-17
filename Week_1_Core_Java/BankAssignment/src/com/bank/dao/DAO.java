package com.bank.dao;

import java.util.ArrayList;

import com.bank.pojos.User;

public interface DAO {

	/*
	 * The contract we make for the information that 
	 * we will need to send to and receive from the data source
	 * 
	 */
	
	void addUser(User u);
	ArrayList<User> readUser();
	void editUser();
	void deleteUser();
	
	
	//addUser
	//readUser
	//editUser - change name, email, password, or balance
	//deleteUser - use ID to delete?
	
}

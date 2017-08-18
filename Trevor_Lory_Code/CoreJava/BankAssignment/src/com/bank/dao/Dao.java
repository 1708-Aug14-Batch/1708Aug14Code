package com.bank.dao;

import com.bank.pojos.User;

public interface Dao {

	//The contract we make for the information that we will need to send to and receive from the data source
	
	//addUser
	//editUser - change fn, ln, username, PW, or balance
	//getUser
	
	public void addUser(User user);
	public void updateUsers(String[] Users);
	public void editUser(User user);
	public void deleteUser(int ID);
	public User getUser(int ID);
	
}

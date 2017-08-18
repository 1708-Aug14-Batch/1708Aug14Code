package com.bank.dao;

import com.bank.pojos.User;

public interface DAO {

	//the contract we make for the info that we will need to send to and receive from the data source
	
	public User addUser(User u);
	public User editUser(User u);
	public User getUser(String email, String pass);
}

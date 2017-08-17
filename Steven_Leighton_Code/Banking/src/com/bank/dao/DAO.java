package com.bank.dao;

import java.util.List;

import com.bank.pojo.User;

public interface DAO {

	/*
	 * The contract we make for the information that
	 * we will need to send to and receive from the data source.
	 * 
	 * 
	 * addUser  - new user added to the data
	 * getUsers - grab all users
	 * rewriteUsers - takes list of users and enters all information 
	 */
	
	void addUser(User user);
	List<User> getUsers();
	void rewriteUsers(List<User> users);
}

package com.bank.dao;

import pojos.User;

public interface Dao {
	
	// Send and receive from data source
		
	public boolean addUser(User user);
	public boolean editUser(User user);
	public User getUser(int userId);
	public User getUser(String email);
	public boolean hasUser(String email);
}

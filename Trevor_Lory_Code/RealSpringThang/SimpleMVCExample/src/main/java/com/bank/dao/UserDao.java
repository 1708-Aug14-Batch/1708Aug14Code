package com.bank.dao;

import com.bank.domain.User;

public interface UserDao {

	User findUserByUsername(String username);
	
	void createUser(User user);
	
}
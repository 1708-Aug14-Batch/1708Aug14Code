package com.ex.dao;

import com.ex.domain.User;

public interface UserDao {
	
	public User findUserByUsername(String username);
	public void createUser(User user);
	
	
	
}

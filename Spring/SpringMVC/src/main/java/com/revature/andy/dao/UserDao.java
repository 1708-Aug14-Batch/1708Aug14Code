package com.revature.andy.dao;

import com.revature.andy.model.User;

public interface UserDao {

	User findUserByUserName(String username);
	
	User createUser(User u);
	
}

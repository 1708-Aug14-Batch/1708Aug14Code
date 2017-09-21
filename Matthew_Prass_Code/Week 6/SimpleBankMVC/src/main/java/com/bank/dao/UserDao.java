package com.bank.dao;

import com.bank.domain.User;

public interface UserDao {

	User findByUsername(String username);
	void createUser(User user);
}

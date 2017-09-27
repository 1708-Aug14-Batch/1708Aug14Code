package com.ex.service;

import java.util.List;

import com.ex.model.User;

public interface UserService {

	void create(User user);
	
	void update(User user);
	
	void delete(User user);
	
	List<User> getAll();
	
	User findById(int id);
	
	User findByName(String name);
	
	boolean exists(User user);
}

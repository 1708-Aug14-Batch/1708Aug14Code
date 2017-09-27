package com.ex.service;

import java.util.List;

import com.ex.model.User;

public interface UserService {
	
	boolean create(User user);
	
	User read(int userId);
	User read(String username);
	
	boolean update(User user);
	
	boolean delete(User user);
	
	List<User> readAllUser();
	
	boolean exists(User user);

}

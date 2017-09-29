package com.revature.service;

import com.revature.dto.UserDTO;
import com.revature.model.User;

public interface UserService {
	
	UserDTO authenticate(UserDTO userData);
	
	public User createUser(UserDTO userData);

}

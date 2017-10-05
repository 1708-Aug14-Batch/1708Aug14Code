package com.bank.service;

import com.bank.dto.UserDTO;

public interface UserService {

	public UserDTO authenticateUser(UserDTO userDto);
	
	public void createUser(UserDTO userDto);
	
	
}
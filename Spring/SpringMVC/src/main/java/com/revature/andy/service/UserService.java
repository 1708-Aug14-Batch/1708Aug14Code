package com.revature.andy.service;

import com.revature.andy.dto.UserDto;

public interface UserService {

	public UserDto authenticateUser(UserDto userDto);
	
	public void createUser(UserDto userDto);
	
}

package com.ex.service;

import com.ex.dto.UserDto;

public interface UserService {

	public UserDto authenticateUser(UserDto userDto);
	
	public void createUser(UserDto userDto);
	
}

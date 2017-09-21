package com.bank.service;

import com.bank.dto.UserDto;

public interface UserService {

	public UserDto authenticateUser(UserDto dto);
	public void createUser(UserDto dto);
}

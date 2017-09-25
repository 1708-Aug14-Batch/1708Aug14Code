package com.bank.test;

import com.bank.dto.UserDto;
import com.bank.service.UserServiceImpl;

public class MainTest {

	public static void main(String[] args) {
		
		UserServiceImpl service = new UserServiceImpl();
		
		UserDto u = new UserDto();
		u.setUsername("test1");
		u.setPassword("test2");
		u.setAuthenticated(false);
		
		service.createUser(u);
		
	}
}

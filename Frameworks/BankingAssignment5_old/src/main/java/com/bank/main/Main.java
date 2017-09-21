package com.bank.main;

import com.bank.dao.UserDaoImpl;
import com.bank.domain.User;
import com.bank.dto.UserDto;
import com.bank.service.UserServiceImpl;

public class Main {

	public static void main(String[] args) {
		
		UserDaoImpl dao = new UserDaoImpl();
		User user = new User();
		user.setUsername("Robert");
		user.setPassword("password");
		dao.createUser(user);
		
		/*
		UserServiceImpl service = new UserServiceImpl();
		
		UserDto userDto = new UserDto();
		
		service.createUser(userDto);
		*/
	}

}

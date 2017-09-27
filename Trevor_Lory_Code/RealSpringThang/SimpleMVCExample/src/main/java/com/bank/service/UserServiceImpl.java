package com.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.dao.UserDao;
import com.bank.domain.User;
import com.bank.dto.UserDto;

@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	private UserDao userDaoImpl;
	
	
	public void setUserDaoImpl(UserDao userDaoImpl) {
		this.userDaoImpl = userDaoImpl;
	}

	public UserDto authenticateUser(UserDto userDto) {
		User user = userDaoImpl.findUserByUsername(userDto.getUsername());
		if(user != null && 
				(user.getPassword().equals(userDto.getPassword()))) {
			userDto.setAuthenticated(true);
		}else {
			return null;
		}
		return userDto;
	}

	public void createUser(UserDto userDto) {
		// need username validation 
		User user = new User();
		user.setUsername(userDto.getUsername());
		user.setPassword(userDto.getPassword());
		userDaoImpl.createUser(user);
	}

}
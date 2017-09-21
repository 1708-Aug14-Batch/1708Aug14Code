package com.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.dao.UserDao;
import com.bank.domain.User;
import com.bank.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDaoImpl;

	public void setDao(UserDao userDaoImpl) {
		this.userDaoImpl = userDaoImpl;
	}

	@Override
	public UserDto authenticateUser(UserDto userDto) {
		User user = userDaoImpl.findUserByUsername(userDto.getUsername());
		if (user != null && user.getPassword().equals(userDto.getPassword())) {
			userDto.setAuthenticated(true);
			return userDto;
		}
		else return null;
		
	}

	// Returns true if a user was created
	@Override
	public boolean createUser(UserDto userDto) {
		
		// Username validation
		User temp = userDaoImpl.findUserByUsername(userDto.getUsername());
		if (temp == null) {	// Username is not taken yet
			User user = new User();
			user.setUsername(userDto.getUsername());
			user.setPassword(userDto.getPassword());
			userDaoImpl.createUser(user);
			
			return true;
		} else return false;
		
	}

}

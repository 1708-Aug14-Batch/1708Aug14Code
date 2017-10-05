package com.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.dao.UserDAO;
import com.bank.domain.User;
import com.bank.dto.UserDTO;

@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	private UserDAO userDaoImpl;

	public void setUserDaoImpl(UserDAO userDaoImpl) {
		this.userDaoImpl = userDaoImpl;
	}

	@Override
	public UserDTO authenticateUser(UserDTO userDto) {
		User user = userDaoImpl.findUserByUsername(userDto.getUsername());
		if(user != null && 
				(user.getPassword().equals(userDto.getPassword()))) {
			userDto.setAuthenticated(true);
		}else {
			return null;
		}
		return userDto;
	}

	@Override
	public void createUser(UserDTO userDto) {
		// need username validation 
		User user = new User();
		user.setUsername(userDto.getUsername());
		user.setPassword(userDto.getPassword());
		
	}

}
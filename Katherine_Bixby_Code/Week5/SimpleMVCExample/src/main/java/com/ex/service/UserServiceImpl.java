package com.ex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.dao.UserDao;
import com.ex.domain.User;
import com.ex.dto.UserDto;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDaoImpl;
	
	
	public void setDao(UserDao userDaoImpl) {
		this.userDaoImpl = userDaoImpl;
	}


	@Override
	public UserDto authenticateUser(UserDto userDto) {
		User user = userDaoImpl.findUserByUsername(userDto.getUsername());
		if(user!=null && (user.getPassword().equals(userDto.getPassword()))){
			userDto.setAuthenticated(true);
		}
		else {
			return null;
		}
		return userDto;
	}

	
	@Override
	public void createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUsername(userDto.getUsername());
		user.setPassword(userDto.getPassword());
		
	}

}

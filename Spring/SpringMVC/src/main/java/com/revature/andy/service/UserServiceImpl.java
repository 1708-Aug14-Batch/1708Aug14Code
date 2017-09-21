package com.revature.andy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.andy.dao.UserDao;
import com.revature.andy.dto.UserDto;
import com.revature.andy.model.User;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDaoImpl;
	
	public void setDao(UserDao dao) {
		this.userDaoImpl = dao;
	}
	
	@Override
	public UserDto authenticateUser(UserDto userDto) {
		User user = userDaoImpl.findUserByUserName(userDto.getUsername());
		if(user != null && (user.getPassword().equals(userDto.getPassword()))) {
			userDto.setAuthenticated(true);
		}else {
			return null;
		}
		return userDto;
	}

	@Override
	public void createUser(UserDto userDto) {
		User user = new User();
		user.setUsername(userDto.getUsername());
		user.setPassword(userDto.getPassword());
	}

}

package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.UserDAO;
import com.revature.dto.UserDTO;
import com.revature.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO dao;
	
	private static final boolean AUTHENTICATED = true;
	private static final boolean NOT_AUTHENTICATED = false;
	
	@Override
	public UserDTO authenticate(UserDTO userData) {
		User user = this.dao.findUserByUsername(userData.getUsername());
		if (user != null) {
			if (user.getPassword().equals(userData.getPassword())) {
				userData.setAuthenticated(AUTHENTICATED);
				return userData;
			}
		}
		return null;
	}

	@Override
	public User createUser(UserDTO userData) {
		User user = new User();
		user.setUsername(userData.getUsername());
		user.setPassword(userData.getPassword());
		return user;
	}

	public UserDAO getDao() {
		return dao;
	}

	public void setDao(UserDAO dao) {
		this.dao = dao;
	}
	
}

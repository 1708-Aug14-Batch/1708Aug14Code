package com.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.dao.UserDao;
import com.bank.domain.User;
import com.bank.dto.UserDto;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao dao;
	
	public void setDao(UserDao dao) {
		this.dao = dao;
	}
	
	
	@Override
	public UserDto authenticateUser(UserDto dto) {
		User user = dao.findByUsername(dto.getUsername());
		if(user == null && (user.getPassword().equals(dto.getPassword()))){
			dto.setAuthenticatred(true);
		}else {
			return null;
		}
		return dto;
	}

	@Override
	public void createUser(UserDto dto) {
		User user = new User();
		user.setEmail(dto.getUsername());
		user.setPassword(dto.getPassword());
		
	}

}

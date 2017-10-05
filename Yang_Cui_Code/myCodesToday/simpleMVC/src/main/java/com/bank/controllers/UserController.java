package com.bank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bank.dto.UserDTO;
import com.bank.service.UserService;

@RestController
@RequestMapping(value="/user")
public class UserController {
	@Autowired
	private UserService userServiceImpl;

	public UserService getUserServiceImpl() {
		return userServiceImpl;
	}

	public void setUserServiceImpl(UserService userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}
	
	@RequestMapping(value="/auth",method=(RequestMethod.POST), consumes=(MediaType.APPLICATION_JSON_VALUE), produces=(MediaType.APPLICATION_JSON_VALUE))
	public ResponseEntity<UserDTO>authentation(@RequestBody UserDTO userdto){
		return new ResponseEntity<UserDTO>(userServiceImpl.authenticateUser(userdto),HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/register",method=(RequestMethod.POST), consumes=(MediaType.APPLICATION_JSON_VALUE), produces=(MediaType.APPLICATION_JSON_VALUE))
	public ResponseEntity<UserDTO> regUser(@RequestBody UserDTO userdto){
		userServiceImpl.createUser(userdto);
		return null;
	}
}

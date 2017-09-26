package com.ex.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ex.dto.UserDto;
import com.ex.service.UserService;

@RestController
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	private UserService userServiceImpl;

	public void setUserService(UserService userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}
	
	@RequestMapping(value="/auth", method = {RequestMethod.POST},
			consumes= {MediaType.APPLICATION_JSON_VALUE},
			produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserDto> authenticateUser(@RequestBody UserDto userDto){
		return new ResponseEntity<UserDto>(userServiceImpl.authenticateUser(userDto),HttpStatus.OK);
	}
	
	@RequestMapping(value="/register", method = {RequestMethod.POST},
			consumes= {MediaType.APPLICATION_JSON_VALUE},
			produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto){
		System.out.println("Creating new user");
		userServiceImpl.createUser(userDto);
		return new ResponseEntity<UserDto>(userServiceImpl.authenticateUser(userDto),HttpStatus.OK);
	}
	
}

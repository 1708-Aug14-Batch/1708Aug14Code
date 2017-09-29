package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dto.UserDTO;
import com.revature.model.User;
import com.revature.service.UserService;

@RestController
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserService service;

	public UserService getService() {
		return service;
	}

	public void setService(UserService service) {
		this.service = service;
	}
	
	@RequestMapping(value="/auth", method= {RequestMethod.POST}, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserDTO> authenticateUser(@RequestBody UserDTO dto) {
		System.out.println("AUTHENTICATING");
		return new ResponseEntity<UserDTO>(this.service.authenticate(dto), HttpStatus.OK);
	}
	
	@RequestMapping(value="/register", method= {RequestMethod.POST}, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<User> registerUser(@RequestBody UserDTO dto) {
		System.out.println("REGISTERING");
		return new ResponseEntity<User>(this.service.createUser(dto), HttpStatus.OK);
	}

}

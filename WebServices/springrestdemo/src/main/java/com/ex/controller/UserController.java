package com.ex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ex.model.User;
import com.ex.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> getAll(){
		List<User> users = userService.getAll();
		if(users == null || users.isEmpty()){
			return new ResponseEntity<List<User>>(HttpStatus.I_AM_A_TEAPOT);
		}
		
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	

}

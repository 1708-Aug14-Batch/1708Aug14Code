package com.revature.andy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.revature.andy.model.User;
import com.revature.andy.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.POST, value="{name}")
	public ResponseEntity<Void> create(@RequestBody User user, UriComponentsBuilder ucBuilder){
		if(userService.exists(user)) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		userService.create(user);
		
		HttpHeaders header = new HttpHeaders();
		
		header.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
		
		return new ResponseEntity<Void>(header, HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> getAll(){
		
		List<User> users = userService.getAll();
		if(users == null || users.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.I_AM_A_TEAPOT);
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") int id){
		User user = userService.findById(id);
		if(user == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") int id){
		User user = userService.findById(id);
		
		if(user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="{id}")
	public ResponseEntity<User> update(@PathVariable("id") int id, @RequestBody User user){
		
		User currentUser = userService.findById(id);

		if(user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		currentUser.setName(user.getName());
		userService.update(currentUser);
		
		return new ResponseEntity<User>(currentUser, HttpStatus.OK);
	}
	
}

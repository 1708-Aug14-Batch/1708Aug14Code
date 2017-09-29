package com.rest.controller;

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

import com.rest.model.User;
import com.rest.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> getAll() {
		List<User> users = this.userService.getAll();
		if (users == null || users.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.I_AM_A_TEAPOT);
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}")
	public ResponseEntity<User> get(@PathVariable("id") int id) {
		User user = this.userService.findById(id);
		if (user == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody User user, UriComponentsBuilder ucBuilder) {
		if (this.userService.exists(user)) {
			System.out.println("User already exists");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		this.userService.create(user);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") int id) {
		System.out.println("Deleting user");
		User user = this.userService.findById(id);
		if (user == null) {
			System.out.println("User DNE");
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		this.userService.delete(user);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.PUT)
	public ResponseEntity<User> update(@PathVariable int id, @RequestBody User user) {
		User currentUser = this.userService.findById(id);
		if (currentUser == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		//currentUser.setId(user.getId());
		currentUser.setUserName(user.getUserName());
		this.userService.update(currentUser);
		return new ResponseEntity<User>(currentUser, HttpStatus.OK);
	}

}

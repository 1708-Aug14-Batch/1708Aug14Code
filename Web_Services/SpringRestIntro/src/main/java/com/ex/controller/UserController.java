package com.ex.controller;

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

import com.ex.model.User;
import com.ex.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> getAll(){
		List<User> users = userService.readAllUser();
		
		if(users == null || users.isEmpty()){
			return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="id")
	public ResponseEntity<User> get(@PathVariable("id") int id) {
		User user = userService.read(id);
		
		if (user == null)
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody User user,
			UriComponentsBuilder ucBuilder) {
		
		if (userService.exists(user)) {
			System.out.println("User already exists");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		else {
			userService.create(user);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") int id) {
		System.out.println("Deleting user...");
		
		User user = userService.read(id);
		
		if (user == null) {
			System.out.println("User DNE");
			return new ResponseEntity<Void> (HttpStatus.NOT_FOUND);
		} else {
			boolean deleted = userService.delete(user);
			if (deleted)
				return new ResponseEntity<Void>(HttpStatus.OK);
			else return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.PUT)
	public ResponseEntity<User> update(@PathVariable int id,
			@RequestBody User user) {
		
		User thisUser = userService.read(id);
		
		if (thisUser == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		} else {
			
			thisUser.setUsername(user.getUsername());
			
			userService.update(thisUser);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
	}

}

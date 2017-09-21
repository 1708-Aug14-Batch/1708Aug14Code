package com.bank.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bank.model.BankUser;
import com.bank.service.BankService;

/* This class provides RESTful endpoints for our application
/* @RequestBody marshals the incoming JSON in the request body into our POJO 
 * @ResponseBody unmarshals the returning object into a JSON.
 * */
@Controller
public class UserInfoController {

	@Autowired
	private BankService service;
	

	public UserInfoController(){}
	
	@RequestMapping("/login")
	public @ResponseBody BankUser login(@RequestBody BankUser user){
		String inEmail = user.getEmail();
		BankUser check = service.getUserByUsername(inEmail);
		if(check==null) return null;
		else {
			if(user.getPassword().equals(check.getPassword())){
				return check;
			}
			else{
				return null;
			}
		}
	}
	
}

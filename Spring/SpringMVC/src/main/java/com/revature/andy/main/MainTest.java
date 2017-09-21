package com.revature.andy.main;

import com.revature.andy.dao.UserDaoImpl;
import com.revature.andy.model.User;

public class MainTest {

	public static void main(String[] args) {
		UserDaoImpl dao = new UserDaoImpl();
		User u = new User();
		
		u.setUsername("Tacos");
		u.setPassword("Hello");
		
	}
	
}

package com.bank.test;

import com.bank.dao.UserDAOImpl;
import com.bank.domain.User;

public class MainTest {

	public static void main(String[] args) {
		
		UserDAOImpl dao = new UserDAOImpl();
		User u = new User();
		u.setUsername("test");
		u.setPassword("test");
		
		dao.createUser(u);
		
	}

}
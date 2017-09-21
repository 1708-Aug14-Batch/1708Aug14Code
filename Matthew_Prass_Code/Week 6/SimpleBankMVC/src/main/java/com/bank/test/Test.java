package com.bank.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bank.dao.UserDaoImpl;
import com.bank.domain.User;

public class Test {

	public static void main(String[] args) {
		//ApplicationContext ac = new ClassPathXmlApplicationContext("mvc.xml");
		UserDaoImpl dao = new UserDaoImpl();
		
		User u = new User();
		u.setEmail("test");
		u.setPassword("test");
		dao.createUser(u);
				
				
	}
}

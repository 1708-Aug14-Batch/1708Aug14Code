package com.bank.test;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bank.pojos.User;
import com.bank.dao.DAOImpl;

public class Test {
	public static void main(String[] args) {

		AbstractApplicationContext ac = 
				new ClassPathXmlApplicationContext("beans.xml");
		
		DAOImpl dao = (DAOImpl) ac.getBean("myDao");
//		
//		User u = new User();
//		u.setFirstname("Test");
//		u.setLastname("User");
//		u.setEmail("testing@email.com");
//		u.setPassword("12345");
//		
//		dao.addUser(u);
		List<User> users = dao.getUsers();
		for(User u: users) {
			System.out.println(u);
		}
		
		
	}

}

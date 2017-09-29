package com.revature.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.dao.DAO;
import com.revature.model.BankUser;

public class Main {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		DAO dao = (DAO) context.getBean("myDAO");
		BankUser user = new BankUser();
		user.setFirstName("Dwight");
		user.setLastName("Schrute");
		user.setEmail("dschrute@mailinator.com");
		user.setPassword("123");
		dao.addUser(user);
	}

}

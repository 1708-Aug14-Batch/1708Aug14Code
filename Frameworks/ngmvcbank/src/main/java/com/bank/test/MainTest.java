package com.bank.test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bank.beans.BankUser;
import com.bank.dao.Dao;

public class MainTest {
	public static void main(String[] args) {

		AbstractApplicationContext ac = 
				new ClassPathXmlApplicationContext("beans.xml");
		
		Dao dao = (Dao) ac.getBean("myDao");
		
		BankUser u = new BankUser();
		u.setFirstname("Test");
		u.setLastname("User");
		u.setEmail("testing@email.com");
		u.setPassword("12345");
		
		dao.addUser(u);
		
	}

}

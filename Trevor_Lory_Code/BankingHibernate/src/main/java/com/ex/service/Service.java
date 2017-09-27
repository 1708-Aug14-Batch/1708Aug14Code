package com.ex.service;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bank.beans.User;
import com.bank.dao.DAO;

public class Service {

	AbstractApplicationContext con = new ClassPathXmlApplicationContext("beans.xml");
	
	DAO dao = (DAO) con.getBean("myDao");
	
	public boolean validateEmail(String em) {
		List<String> thing = dao.getAllEmails();
		for(int i = 0; i < thing.size(); i++) {
			System.out.println(thing.get(i));
			if(em.equalsIgnoreCase(thing.get(i))) {
				System.out.println("NOPE");
				return false;
			}
		}
		return true;
	}
	
	public User addUser(User u) {
		return dao.addUserNew(u);
	}
	
}

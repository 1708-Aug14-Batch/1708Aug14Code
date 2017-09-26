package com.bank.service;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bank.beans.User;
import com.bank.dao.HibDAO;

public class Service {

	AbstractApplicationContext ac = new ClassPathXmlApplicationContext("Beans.xml");
	
	HibDAO dao = (HibDAO) ac.getBean("myDao");
	
	public boolean validateEmail(String email) {
		List<String> emails = dao.getEmails();
		for(String e:emails) {
			if(e.equalsIgnoreCase(email)) return false;
		}
		return true;
	}
	
	public User addUser(User u) {
		if(validateEmail(u.getEmail())) {
			dao.addUser(u);
			return u;
		}
		else return null;
	}
}

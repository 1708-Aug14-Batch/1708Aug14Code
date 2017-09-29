package com.revature.service;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.dao.DAO;

public class Service {
	
	private AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	private DAO dao = (DAO) context.getBean("myDAO");
	
	// TODO Write getEmails method in DAOImpl
//	public boolean validateEmail(String email) {
//		List<String> emails = dao.getEmails();
//		for (String currentEmail : emails) {
//			if (currentEmail.equalsIgnoreCase(email)) {
//				return false;
//			}
//		}
//		return true;
//	}

}

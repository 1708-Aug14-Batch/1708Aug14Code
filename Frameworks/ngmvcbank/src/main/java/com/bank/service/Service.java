package com.bank.service;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bank.beans.BankUser;
import com.bank.dao.Dao;

public class Service {

	static AbstractApplicationContext ac = 
			new ClassPathXmlApplicationContext("beans.xml");
	
	static Dao dao = (Dao) ac.getBean("myDao");
	
	public static boolean validateEmail(String email){
		List<String> emails = dao.getEmails();
		for(String e : emails){
			if(e.equalsIgnoreCase(email)) return false;
		}
		return true;
	}
	
	public BankUser addUser(BankUser u){
		if(validateEmail(u.getEmail())) {
			dao.addUser(u);
			return u;
		}
		else return null;
	}
	
}

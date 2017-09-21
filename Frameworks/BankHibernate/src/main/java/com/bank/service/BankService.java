package com.bank.service;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bank.beans.Account;
import com.bank.beans.AccountType;
import com.bank.beans.User;
import com.bank.dao.DAO;
import com.bank.dao.HibernateDAO;

public class BankService {

	private DAO dao;

	public BankService() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");

		DAO dao = (DAO) ac.getBean("myDAO");
		this.dao = dao;
	}

	public boolean addUser(User user) {
		if(dao.existsUsername(user.getUsername())) {
			return false; 
		}
		else {
			dao.addUser(user);
		}
		return true;
	}
	
	public AccountType addType(AccountType type) {
		return dao.addType(type);
	}
	
	public Account addAccount(Account account) {
		return dao.addAccount(account);
	}
}

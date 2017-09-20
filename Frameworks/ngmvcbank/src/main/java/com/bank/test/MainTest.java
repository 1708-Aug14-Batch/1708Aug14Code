package com.bank.test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bank.beans.Account;
import com.bank.beans.AccountType;
import com.bank.beans.BankUser;
import com.bank.dao.Dao;

public class MainTest {
	public static void main(String[] args) {

		AbstractApplicationContext ac = 
				new ClassPathXmlApplicationContext("beans.xml");
		
		Dao dao = (Dao) ac.getBean("myDao");
		
		BankUser u = new BankUser();
		u.setFirstname("Gen");
		u.setLastname("Bonds");
		u.setEmail("12345@email.com");
		u.setPassword("12345");
		
		dao.addUser(u);
		
		
		AccountType savings = new AccountType();
		savings.setType("Savings");
		AccountType checking = new AccountType();
		checking.setType("Checking");
		AccountType credit = new AccountType();
		credit.setType("Credit");
		
		dao.addType(savings);
		dao.addType(checking);
		dao.addType(credit);
		
		Account acc = new Account();
		acc.setBalance(1000000);
		acc.setOwner(u);
		acc.setType(checking);
		dao.addAccount(acc);
		
		
		
	}

}

package com.revature.andy.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.andy.beans.Account;
import com.revature.andy.beans.AccountType;
import com.revature.andy.beans.User;
import com.revature.andy.dao.DAOImplementation;
import com.revature.andy.dao.DAOInterface;

public class MainTest {
	public static void main(String[] args) {
		
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		DAOInterface dao = (DAOInterface) context.getBean("dao");
		
		User u = new User("Andy","Why","az@email.com","az");
		
		AccountType at1 = new AccountType(1,"Checking");
		AccountType at2 = new AccountType(2,"Saving");
		AccountType at3 = new AccountType(3,"Credit");
				
		dao.addUser(u);
		
		dao.addAccountType(at1);
		dao.addAccountType(at2);
		dao.addAccountType(at3);
		
		Account a = new Account(100,u,at1);
		
		dao.addAccount(a);
		
		//DAOImplementation dao = new DAOImplementation();
		
		//User u = new User("Andy","Zheng","az@email.com","az");
		
		//dao.addUser(u);
		
		//AccountType at1 = new AccountType(1,"Checking");
		//AccountType at2 = new AccountType(2,"Saving");
		//AccountType at3 = new AccountType(3,"Credit");
		
		/*
		dao.addAccountType(at1);
		dao.addAccountType(at2);
		dao.addAccountType(at3);
		*/
		
		//Account a = new Account(0.00,u,at1);
		
		//AccountType atTemp = dao.getAccountType(1);
		
		//System.out.println(atTemp.toString());
		
	}
}

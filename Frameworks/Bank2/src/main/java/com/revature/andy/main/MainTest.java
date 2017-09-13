package com.revature.andy.main;

import com.revature.andy.beans.Account;
import com.revature.andy.beans.AccountType;
import com.revature.andy.beans.User;
import com.revature.andy.dao.DAOImplementation;

public class MainTest {
	public static void main(String[] args) {
		
		DAOImplementation dao = new DAOImplementation();
		
		User u = new User("Andy","Zheng","az@email.com","az");
		
		//dao.addUser(u);
		
		AccountType at1 = new AccountType(1,"Checking");
		AccountType at2 = new AccountType(2,"Saving");
		AccountType at3 = new AccountType(3,"Credit");
		
		/*
		dao.addAccountType(at1);
		dao.addAccountType(at2);
		dao.addAccountType(at3);
		*/
		
		//Account a = new Account(0.00,u,at1);
		
		AccountType atTemp = dao.getAccountType(1);
		
		System.out.println(atTemp.toString());
		
	}
}

package com.bank.test;

import java.util.ArrayList;

import com.bank.dao.DAOImpl;
import com.bank.pojos.Account;
import com.bank.pojos.User;
import com.bank.service.Service;

public class Test {
	public static void main(String[] args) {
		DAOImpl dao = new DAOImpl();
		Service serve = new Service();
		User u = serve.addUser("fn1", "ln1", "username", "pwd");
		
		
		//System.out.println("user: "+ u);
//	//	System.out.println(serve.addAccount(u, 1));
//	//	serve.addAccount(u, 2);
//	//	serve.addAccount(u, 3);
//		ArrayList<Account> accnts = serve.getOpenAccounts(u);
//		for(Account a:accnts) {
//			System.out.println(a.toString());
//		}
//		System.out.println(dao.getUser("us8ernam9e"));
//		System.out.println(serve.deposit(accnts.get(0), 4));
//		System.out.println(serve.withdraw(accnts.get(0), 1));
//		
		
	}

}

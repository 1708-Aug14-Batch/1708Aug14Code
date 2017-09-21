package com.bank.test;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bank.beans.Account;
import com.bank.beans.AccountType;
import com.bank.beans.User;
import com.bank.dao.DAO;
import com.bank.dao.HibernateDAO;
import com.bank.service.BankService;

public class MainTest {

	public static void main(String[] args) {
		BankService service = new BankService();
		
		AccountType t1 = new AccountType(1,"Checkings");
		AccountType t2 = new AccountType(2,"Savings");
		AccountType t3 = new AccountType(3,"Credit");
		
		User user = new User();
		user.setFirstname("Steven");
		user.setLastname("Leighton");
		user.setUsername("serka");
		user.setPassword("pass");
		
		Account account = new Account();
		account.setBalance(BigDecimal.valueOf(0));
		account.setUser(user);
		account.setType(t1);
		
		service.addType(t1);
		service.addType(t2);
		service.addType(t3);

		service.addAccount(account);

		System.out.println(service.addUser(user));
		System.out.println(user.toString());
		System.out.println(service.addUser(user));
		
		System.out.println(user.toString());
		System.out.println(account.toString());
//		User user = dao.getUser("serka", "pass");
//		System.out.println(user.toString());
//		
//		List<Account> accounts = dao.getAccountsByUser(user);
//		for(Account a : accounts){
//			System.out.println(a.toString());
//		}
		
		
	}
}

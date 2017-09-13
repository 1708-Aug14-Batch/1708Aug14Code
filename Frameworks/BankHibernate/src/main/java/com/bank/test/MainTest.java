package com.bank.test;

import java.util.List;

import com.bank.beans.Account;
import com.bank.beans.User;
import com.bank.dao.HibernateDAO;

public class MainTest {

	public static void main(String[] args) {
		HibernateDAO dao = new HibernateDAO();

//		AccountType t1 = new AccountType(1,"Checkings");
//		AccountType t2 = new AccountType(2,"Savings");
//		AccountType t3 = new AccountType(3,"Credit");
//		
//		User user = new User();
//		user.setFirstname("Steven");
//		user.setLastname("Leighton");
//		user.setUsername("serka");
//		user.setPassword("pass");
//		
//		Account account = new Account();
//		account.setBalance(BigDecimal.valueOf(0));
//		account.setUser(user);
//		account.setType(t1);
//		
//		dao.addType(t1);
//		dao.addType(t2);
//		dao.addType(t3);
//		
//		dao.addUser(user);
//		dao.addAccount(account);
		
		User user = dao.getUserByCredentials("serka", "pass");
		System.out.println(user.toString());
		
		List<Account> accounts = dao.getAccountsByUser(user);
		for(Account a : accounts){
			System.out.println(a.toString());
		}
		
		
	}
}

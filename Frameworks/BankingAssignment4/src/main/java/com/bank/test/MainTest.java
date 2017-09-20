package com.bank.test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bank.beans.*;
import com.bank.dao.Dao;
import com.bank.dao.HibernateDao;

public class MainTest {
	
	public static void main(String[] args) {
		
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
		Dao dao = (Dao) ac.getBean("myDao");
		
		Person per1 = new Person("Mike", "Walter", "mikey@mail.com");
		Person per2 = new Person("Luana", "Quet", "Louie@mail.com");
		BankUser user = new BankUser(per1, "mikey", "password");
		Clerk cler = new Clerk(per2, "pass word");
		AccountType checking = new AccountType("CHECKING");
		AccountType savings = new AccountType("SAVINGS");
		AccountType credit = new AccountType("CREDIT");
		AccountLevel bronze = new AccountLevel("BRONZE");
		AccountLevel silver = new AccountLevel("SILVER");
		AccountLevel gold = new AccountLevel("GOLD");
		Account acc1 = new Account(user, checking, bronze);
		Account acc2 = new Account(user, savings, silver);
		Account acc3 = new Account(user, credit, gold);
		
		dao.create(per1);
		dao.create(per2);
		dao.create(user);
		dao.create(cler);
		dao.create(checking);
		dao.create(savings);
		dao.create(credit);
		dao.create(bronze);
		dao.create(silver);
		dao.create(gold);
		dao.create(acc1);
		dao.create(acc2);
		dao.create(acc3);

		dao.addPerson(p);
		dao.addBankUser(u);
		
		System.out.println("End of main");
		
		((ConfigurableApplicationContext) ac).close();
	}
	
	public void createHibernateObjects() {
		HibernateDao<Object> dao = new HibernateDao<Object>();

		Person per1 = new Person("Mike", "Walter", "mikey@mail.com");
		Person per2 = new Person("Luana", "Quet", "Louie@mail.com");
		BankUser user = new BankUser(per1, "mikey", "password");
		Clerk cler = new Clerk(per2, "pass word");
		AccountType checking = new AccountType("CHECKING");
		AccountType savings = new AccountType("SAVINGS");
		AccountType credit = new AccountType("CREDIT");
		AccountLevel bronze = new AccountLevel("BRONZE");
		AccountLevel silver = new AccountLevel("SILVER");
		AccountLevel gold = new AccountLevel("GOLD");
		Account acc1 = new Account(user, checking, bronze);
		Account acc2 = new Account(user, savings, silver);
		Account acc3 = new Account(user, credit, gold);
		
		dao.create(per1);
		dao.create(per2);
		dao.create(user);
		dao.create(cler);
		dao.create(checking);
		dao.create(savings);
		dao.create(credit);
		dao.create(bronze);
		dao.create(silver);
		dao.create(gold);
		dao.create(acc1);
		dao.create(acc2);
		dao.create(acc3);
	}

}

package com.bank.test;

import com.bank.beans.Account;
import com.bank.beans.Account.accountType;
import com.bank.beans.BankUser;
import com.bank.beans.Clerk;
import com.bank.beans.Person;
import com.bank.dao.HibernateDao;

public class MainTest {
	
	public static void main(String[] args) {
		
		HibernateDao<Object> dao = new HibernateDao<Object>();

		Person per1 = new Person("Mike", "Walter", "mikey@mail.com");
		Person per2 = new Person("Luana", "Quet", "Louie@mail.com");
		BankUser user = new BankUser(per1, "mikey", "password");
		Clerk cler = new Clerk(per2, "pass word");
		Account acc1 = new Account(user, accountType.CHECKING);
		Account acc2 = new Account(user, accountType.SAVINGS);
		Account acc3 = new Account(user, accountType.CREDIT);
		
		dao.create(per1);
		dao.create(per2);
		dao.create(user);
		dao.create(cler);
		dao.create(acc1);
		dao.create(acc2);
		dao.create(acc3);
		
	}

}

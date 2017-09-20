package com.bank.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.bank.beans.*;

public interface Dao {
	
	public void setSessionFactory(SessionFactory sessionFactory);
	
	public void addPerson(Person p);
	public void addBankUser(BankUser u);
	public Account addAccount(Account a);
	public void addType(AccountType at);
	public void addType(AccountLevel al);
	
	public List<BankUser> reallAllUsers();
	
	public List<String> readAllEmails();

}

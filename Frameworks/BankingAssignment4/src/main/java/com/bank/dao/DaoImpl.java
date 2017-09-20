package com.bank.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.bank.beans.*;

@Transactional
public class DaoImpl implements Dao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void addPerson(Person p) {
		sessionFactory.getCurrentSession().save(p);
	}

	public void addBankUser(BankUser u) {
		// Check that associated person exists, maybe create person
		sessionFactory.getCurrentSession().save(u);
	}
	
	public void addBankUser(Clerk c) {
		// Check that associated person exists, maybe create person
		sessionFactory.getCurrentSession().save(c);
	}
	public void addBankUser(Account a) {
		// Check that associated user exists, maybe create person
		sessionFactory.getCurrentSession().save(a);
	}
	public void addBankUser(AccountType at) {
		sessionFactory.getCurrentSession().save(at);
	}
	public void addBankUser(AccountLevel al) {
		sessionFactory.getCurrentSession().save(al);
	}
	
		
	public List<BankUser> reallAllUsers() {
		Session s = sessionFactory.getCurrentSession();
		List<BankUser> users = new ArrayList<BankUser>();
		return s.createQuery("from BankUser").list();
	}

	public Account addAccount(Account a) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addType(AccountType at) {
		// TODO Auto-generated method stub
		
	}

	public void addType(AccountLevel al) {
		// TODO Auto-generated method stub
		
	}

	public List<String> readAllEmails() {
		// TODO Auto-generated method stub
		return null;
	}

}

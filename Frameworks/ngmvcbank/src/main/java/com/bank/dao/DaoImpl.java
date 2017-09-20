package com.bank.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.bank.beans.Account;
import com.bank.beans.AccountType;
import com.bank.beans.BankUser;

@Transactional
public class DaoImpl implements Dao {
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public BankUser addUser(BankUser u) {
		Session s = sessionFactory.getCurrentSession();
		s.save(u);
		return u;
		
	}
	
	public void addType(AccountType at) {
		Session s = sessionFactory.getCurrentSession();
		s.save(at);
		
	}
	
	public List<String> getEmails(){
		List<String> emails = sessionFactory.getCurrentSession()
				.createQuery("select email from BankUser").list();
		return emails;
	}
	
	public List<BankUser> getUsers(){
		Session s = sessionFactory.getCurrentSession();
		List<BankUser> users = new ArrayList<BankUser>();
		users = s.createQuery("from BankUser").list();
		return users;
	}
	
	public List<Account> getAllAccounts(){
		
		List<Account> accounts = 
				sessionFactory.getCurrentSession()
				.createCriteria(Account.class).list();
		return accounts;
	}
	
	public List<Account> getAccountsByUser(BankUser u){
		List<Account> accounts = 
				(List<Account>) sessionFactory.getCurrentSession()
				.get(Account.class, u.getId());
		return accounts;
	}
	
	@Transactional
	public Account addAccount(Account a){
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(a.getOwner());
		session.saveOrUpdate(a.getType());
		session.save(a);
		return a;
	}
	
	

}

package com.bank.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.bank.beans.Account;
import com.bank.beans.AccountType;
import com.bank.beans.User;

@Transactional
public class HibDAOImpl implements HibDAO{

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	public User addUser(User u) {
		Session s = sessionFactory.getCurrentSession();
		s.save(u);
		return u;
	}
	
	public AccountType addType(AccountType at) {
		Session s = sessionFactory.getCurrentSession();
		s.save(at);
		return at;
	}
	
	
	public List<User> getUsers(){
		Session s = sessionFactory.getCurrentSession();
		List<User> users = new ArrayList<User>();
		users = s.createQuery("from Users").list();
		return users;
	}
	
	@Transactional
	public Account addAccount(Account a) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(a.getOwner());
		session.saveOrUpdate(a.getType());
		session.save(a);
		return a;
	}
	
	public List<String> getEmails(){
		List<String> emails = sessionFactory.getCurrentSession()
				.createQuery("select email from Users").list();
		return emails;
	}
	
	public List<Account> getAllAccounts(){
		
		List<Account> accounts = sessionFactory.getCurrentSession().createCriteria(Account.class).list();
		return accounts;
	}
	
	public List<Account> getAccountsByUser(User u){
		List<Account> accounts = 
				(List<Account>) sessionFactory.getCurrentSession()
				.get(Account.class, u.getId());
		return accounts;
	}
	
	
	
}

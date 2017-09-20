package com.revature.andy.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.revature.andy.beans.Account;
import com.revature.andy.beans.AccountType;
import com.revature.andy.beans.User;
import com.revature.andy.util.ConnectionUtil;

@Transactional
public class DAOImplementation implements DAOInterface{
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public User addUser(User u) {
		Session s = sessionFactory.getCurrentSession();
		s.save(u);
		return u;
	}
	
	@Override
	public AccountType addAccountType(AccountType at) {
		Session s = sessionFactory.getCurrentSession();
		s.save(at);
		return at;
	}
	
	@Override	
	public List<User> getAllUsers(){
		Session s = sessionFactory.getCurrentSession();
		List<User> u = new ArrayList<User>();
		u = s.createQuery("from User").list();
		return u;
	}

	@Override	
	public List<Account> getAllAccounts(){
		List<Account> ats = sessionFactory.getCurrentSession().createCriteria(Account.class).list();
		return ats;
	}

	/// noooooooooooooooooooooooooooooooooooo???
	@Override	
	public List<Account> getAccountsByUser(User u){
		//List<Account> uats = (List<Account>) sessionFactory.getCurrentSession().get(Account.class, u.getId());
		List<Account> uats = sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("User", u)).list();
		return uats;
	}
	
	@Override
	public Account addAccount(Account a) {
		Session s = sessionFactory.getCurrentSession();
		s.saveOrUpdate(a.getU());
		s.saveOrUpdate(a.getAt());
		s.save(a);
		return a;
	}
	
	/*
	public void addUser(User user) {
		Session session = ConnectionUtil.getSession();
		
		try {
		Transaction tx = (Transaction) session.beginTransaction();
		session.save(user);
		tx.commit();
		}finally {
			session.close();
		}
	}

	public void addAccount(double amount, int userId, int typeId) {
		Session session = ConnectionUtil.getSession();
		
		try {
		Transaction tx = (Transaction) session.beginTransaction();
		User uTemp = getUser(userId);
		AccountType atTemp = getAccountType(typeId);
		Account aTemp = new Account(amount, uTemp, atTemp);
		session.save(aTemp);
		tx.commit();
		}finally {
			session.close();
		}
	}
	
	public void addAccountType(AccountType accountType) {
		Session session = ConnectionUtil.getSession();
		
		try {
		Transaction tx = (Transaction) session.beginTransaction();
		session.save(accountType);
		tx.commit();
		}finally {
			session.close();
		}
	}
	
	public User getUser(int userId) {

		Session session = ConnectionUtil.getSession();
		
		try {
			Transaction tx = (Transaction) session.beginTransaction();
			User uTemp =  (User) session.get(User.class, userId);
			return uTemp;
		} finally {
			session.close();
		}
	}
	
	public Account getAccount(int accountId) {

		Session session = ConnectionUtil.getSession();
		
		try {
			Transaction tx = (Transaction) session.beginTransaction();
			Account aTemp =  (Account) session.get(Account.class, accountId);
			return aTemp;
		} finally {
			session.close();
		}
		
	}
	
	public AccountType getAccountType(int typeId) {
		
		Session session = ConnectionUtil.getSession();
		
		try {
			Transaction tx = (Transaction) session.beginTransaction();
			AccountType atTemp =  (AccountType) session.get(AccountType.class, typeId);
			return atTemp;
		} finally {
			session.close();
		}
	}*/
}

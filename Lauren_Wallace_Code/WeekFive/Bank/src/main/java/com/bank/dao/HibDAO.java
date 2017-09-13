package com.bank.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.bank.beans.Account;
import com.bank.beans.User;
import com.bank.util.ConnectionFactory;

public class HibDAO {
	
	// CREATE A USER
	public User addStudent(User u) {
		Session session = ConnectionFactory.getSession();

		try {
			Transaction tx = (Transaction) session.beginTransaction();

			u = (User) session.save(u);
			tx.commit();
		} finally {
			session.close();
		}
		return u;
	}

	// CREATE AN ACCOUNT
	public void addAccount(Account acc) {
		Session session = ConnectionFactory.getSession();

		try {
			Transaction tx = (Transaction) session.beginTransaction();
			session.save(acc);
			tx.commit();
		} finally {
			session.close();
		}
	}

	// GET A USER BY ID
	public User getUserById(int id) {
		Session session = ConnectionFactory.getSession();
		User u = null;

		try {
			u = (User) session.get(User.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return u;
	}

	// GET AN ACCOUNT BY ID
	public Account getAccountById(int id) {
		Session session = ConnectionFactory.getSession();
		Account acc = null;

		try {
			acc = (Account) session.get(Account.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return acc;
	}
	
	//GET ALL USERS
	public List<User> getAllUsers() {
		Session session = ConnectionFactory.getSession();
		Criteria criteria = session.createCriteria(User.class);
		List<User> users = criteria.list();
		session.close();
		return users;
	}
	
	//GET ALL ACCOUNTS WHERE USERID IS #
	public List<Account> getAllOfAUserAccounts(int id) {
		Session session = ConnectionFactory.getSession();
		Criteria criteria = session.createCriteria(Account.class).add(Restrictions.ilike("userid", id));
		List<Account> accounts = criteria.list();
		session.close();
		return accounts;
	}
	
	//GET ALL ACCOUNTS
	public List<Account> getAllAccounts() {
		Session session = ConnectionFactory.getSession();
		Criteria criteria = session.createCriteria(Account.class);
		List<Account> accounts = criteria.list();
		session.close();
		return accounts;
	}
	
}

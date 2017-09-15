package com.bank.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.bank.beans.*;
import com.bank.util.ConnectionUtil;

public class HibernateDao {

	public Person create(Person person) {
		Session session = ConnectionUtil.getSession();

		try {
			Transaction tx = (Transaction) session.beginTransaction();

			int personId = (Integer) session.save(person);
			person.setPersonId(personId);

			tx.commit();
		} finally {
			session.close();
		}

		return person;
	}

	public BankUser create(BankUser user) {
		Session session = ConnectionUtil.getSession();

		try {
			Transaction tx = (Transaction) session.beginTransaction();

			int userId = (Integer) session.save(user);
			user.setUserId(userId);

			tx.commit();
		} finally {
			session.close();
		}

		return user;
	}

	public Clerk create(Clerk clerk) {
		Session session = ConnectionUtil.getSession();

		try {
			Transaction tx = (Transaction) session.beginTransaction();

			int clerkId = (Integer) session.save(clerk);
			clerk.setClerkId(clerkId);

			tx.commit();
		} finally {
			session.close();
		}

		return clerk;
	}

	public Account create(Account account) {
		Session session = ConnectionUtil.getSession();

		try {
			Transaction tx = (Transaction) session.beginTransaction();

			int accountId = (Integer) session.save(account);
			account.setAccountId(accountId);

			tx.commit();
		} finally {
			session.close();
		}

		return account;
	}

	/*
	 * public <T> Class<T> read(final int id) {
	 * 
	 * Session session = ConnectionUtil.getSession(); Class<T> result = null;
	 * try{ result = (Class<T>) session.get(Class<T>, id); }
	 * catch(HibernateException e){ e.printStackTrace(); } finally{
	 * session.close(); } return result; }
	 */

}
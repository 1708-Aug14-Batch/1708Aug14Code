package com.bank.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bank.beans.Account;
import com.bank.beans.AccountType;
import com.bank.beans.User;
import com.bank.util.ConnectionUtil;

public class BankHibDAOImp {

	public List<User> getAllUsers() {
		List<User> list = null;
		Session session = ConnectionUtil.getSession();
		try {
			Query query = session.createQuery("from User");
			list = query.list();
		}
		finally {
			session.close();
		}
		return list;
	}
	
	public void addUser(User u) {
		Session session = ConnectionUtil.getSession();
		try {
			Transaction tx = (Transaction)session.beginTransaction();
			u.setUSERID((Integer) session.save(u));
			tx.commit();
		}
		finally {
			session.close();
		}
	}
	
	public List<Account> getAllAccounts() {
		List<Account> list = null;
		Session session = ConnectionUtil.getSession();
		try {
			Query query = session.createQuery("from Account");
			list = query.list();
		}
		finally {
			session.close();
		}
		return list;
	}
	
	public List<AccountType> getAllAccountTypes() {
		List<AccountType> list = null;
		Session session = ConnectionUtil.getSession();
		try {
			Query query = session.createQuery("from AccountType");
			list = query.list();
		}
		finally {
			session.close();
		}
		return list;
	}
	
}

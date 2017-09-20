package com.revature.andy.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.andy.beans.Account;
import com.revature.andy.beans.AccountType;
import com.revature.andy.beans.User;
import com.revature.andy.util.ConnectionUtil;

public class DAOImplementation {
	
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
	}
}

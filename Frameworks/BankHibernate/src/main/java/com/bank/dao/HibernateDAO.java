package com.bank.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bank.beans.Account;
import com.bank.beans.AccountType;
import com.bank.beans.User;
import com.bank.util.ConnectionUtil;

public class HibernateDAO {

	//create user
	public User addUser(User user){
		Session session = ConnectionUtil.getSession();

		try{
			Transaction tx = (Transaction) session.beginTransaction();

			user.setId((Integer)session.save(user));

			tx.commit();

		}finally{
			session.close();
		}

		return user;
	}

	//create account type
	public AccountType addType(AccountType type){
		Session session = ConnectionUtil.getSession();

		try{
			Transaction tx = (Transaction) session.beginTransaction();

			type.setId((Integer)session.save(type));

			tx.commit();

		}finally{
			session.close();
		}

		return type;
	}

	//create account
	public Account addAccount(Account account){
		Session session = ConnectionUtil.getSession();

		try{
			Transaction tx = (Transaction) session.beginTransaction();

			account.setAccountID((Integer)session.save(account));

			tx.commit();

		}finally{
			session.close();
		}

		return account;
	}
	
	public User getUserById(int id){
		Session session = ConnectionUtil.getSession();
		User u = null;
		try{
			u = (User) session.get(User.class, id);
			
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return u;
	}
	
	public User getUserByCredentials(String username, String pass){
		Session session = ConnectionUtil.getSession();
		String hql = "from User where username = :user and password = :pwd";
		Query query = session.createQuery(hql);
		query.setParameter("user", username);
		query.setParameter("pwd", pass);
		User user = (User)query.list().get(0);
		
		return user;
	}

	public Account getAccountById(int id){
		Session session = ConnectionUtil.getSession();
		Account a = null;
		try{
			a = (Account) session.get(Account.class, id);
			
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return a;
	}
	
	public List<Account> getAccountsByUser(User user){
		Session session = ConnectionUtil.getSession();
		String hql = "from Account where user_id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", user.getId());
		List<Account> accounts = query.list();
		
		
		
		return accounts;
	}
	
	public AccountType getAccountTypeById(int id){
		Session session = ConnectionUtil.getSession();
		AccountType a = null;
		try{
			a = (AccountType) session.get(AccountType.class, id);
			
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return a;
	}

	
}

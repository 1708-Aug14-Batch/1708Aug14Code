package com.bank.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import com.bank.beans.Account;
import com.bank.beans.AccountType;
import com.bank.beans.User;
import com.bank.util.ConnectionUtil;

@Transactional
public class HibernateDAO implements DAO{

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	//create user
	public User addUser(User user){
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
		return user;
	}

	//create account type
	public AccountType addType(AccountType type){
		Session session = sessionFactory.getCurrentSession();
		session.save(type);

		return type;
	}

	//create account
	public Account addAccount(Account account){
		Session session = sessionFactory.getCurrentSession();
		session.save(account);

		return account;
	}

	public User getUser(int id){
		Session session = sessionFactory.getCurrentSession();
		User u = null;
		u = (User) session.get(User.class, id);
		return u;
	}

	public User getUser(String username, String pass){
		Session session = sessionFactory.getCurrentSession();
		String hql = "from User where username = :user and password = :pwd";
		Query query = session.createQuery(hql);
		query.setParameter("user", username);
		query.setParameter("pwd", pass);
		User user = (User)query.list().get(0);

		return user;
	}

	public Account getAccountById(int id){
		Session session = sessionFactory.getCurrentSession();
		Account a = null;
		a = (Account) session.get(Account.class, id);
		return a;
	}

	public List<Account> getAccountsByUser(User user){
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Account where user_id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", user.getId());
		List<Account> accounts = query.list();
		return accounts;
	}

	public AccountType getAccountTypeById(int id){
		Session session = sessionFactory.getCurrentSession();
		AccountType a = null;
		a = (AccountType) session.get(AccountType.class, id);
		return a;
	}


	@Override
	public boolean existsUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
		Query query =session.createQuery("from User where username = :username");
		query.setParameter("username", username);
		List<User> users = query.list();

		return !users.isEmpty();
	}

	@Override
	public void updateUser(User user) {
		Session session = sessionFactory.getCurrentSession();

	}

	@Override
	public void deleteUser(User user) {
		Session session = sessionFactory.getCurrentSession();

	}

	@Override
	public Account getAccount(int accountID) {
		Session session = sessionFactory.getCurrentSession();
		return null;
	}

	@Override
	public ArrayList<Account> getAccounts(int userID) {
		Session session = sessionFactory.getCurrentSession();
		return null;
	}

	@Override
	public void updateAccount(Account account) {
		Session session = sessionFactory.getCurrentSession();

	}

	@Override
	public void deleteAccount(Account account) {
		Session session = sessionFactory.getCurrentSession();

	}


}

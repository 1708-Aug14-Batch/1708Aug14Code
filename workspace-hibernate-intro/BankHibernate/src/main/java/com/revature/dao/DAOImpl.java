package com.revature.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.revature.model.BankAccount;
import com.revature.model.BankUser;

@Transactional
public class DAOImpl implements DAO {
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addUser(BankUser user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
	}
	
	public List<BankUser> getAllUsers() {
		Session session = sessionFactory.getCurrentSession();
		List<BankUser> allUsers = session.createQuery("from BankUser").list();
		return allUsers;
	}
	
	public void addBankAccount(BankAccount bankAccount) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(bankAccount.getBankUserID());
		session.saveOrUpdate(bankAccount.getAccountTypeID());
		session.save(bankAccount);
	}
	
	public List<BankAccount> getAllBankAccounts() {
		List<BankAccount> allBankAccounts = sessionFactory.getCurrentSession().createCriteria(BankAccount.class).list();
		return allBankAccounts;
	}
	
//	public List<BankAccount> getBankAccountsByBankUser(BankUser user) {
//		List<BankAccount> bankAccounts = (List<BankAccount>) sessionFactory.getCurrentSession().get(BankAccount.class, user.getBankUserID());
//		return bankAccounts;
//	}

}

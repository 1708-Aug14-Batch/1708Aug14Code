package com.bank.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bank.model.Account;
import com.bank.model.AccountType;
import com.bank.model.BankUser;

@Repository
@Transactional
public class DaoImpl implements Dao {
	
	@Autowired
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
	
	public Account getAccountById(int id){
		Account account =  (Account) sessionFactory.getCurrentSession()
				.get(Account.class, id);
		return account;
	}
	
	public BankUser getUserByUsername(String name){
		ArrayList<BankUser> list = (ArrayList<BankUser>) sessionFactory.getCurrentSession()
				.createQuery("from BankUser where lower(email)=?")
				.setParameter(0, name.toLowerCase()).list();
		if(list.size()==0)return null;
		else { return list.get(0);}
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

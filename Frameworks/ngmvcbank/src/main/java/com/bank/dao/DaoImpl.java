package com.bank.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.bank.beans.BankUser;

@Transactional
public class DaoImpl implements Dao {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addUser(BankUser u) {
		Session s = sessionFactory.getCurrentSession();
		int id = (Integer) s.save(u);
		System.out.println(id);
	}
	
	
	

}

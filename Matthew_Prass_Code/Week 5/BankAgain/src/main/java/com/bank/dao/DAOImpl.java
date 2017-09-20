package com.bank.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.bank.pojos.User;

@Transactional
public class DAOImpl implements DAOInterface{

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public User addUser(User u) {
		Session s = sessionFactory.getCurrentSession();
		s.save(u);
		return u;
	}
	
	public List<User> getUsers(){
		Session s = sessionFactory.getCurrentSession();
		List<User> users = new ArrayList<User>();
		users = s.createQuery("from User").list();
		return users;
	}
}

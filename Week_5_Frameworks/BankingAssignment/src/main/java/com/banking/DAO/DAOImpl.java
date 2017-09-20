package com.banking.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.banking.pojos.User;

@Transactional
public class DAOImpl implements DAO{
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addUser(User u) {
		Session s = sessionFactory.getCurrentSession();
		s.save(u);
		System.out.println("Successful adding");
	}
	
	public List<User> getUsers(){
		Session s = sessionFactory.getCurrentSession();
		List<User> users = new ArrayList<User>();
		users = s.createQuery("from User").list();
		return users;
	}

}

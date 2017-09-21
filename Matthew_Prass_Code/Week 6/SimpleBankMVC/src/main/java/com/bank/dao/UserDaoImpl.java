package com.bank.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bank.domain.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{

	public UserDaoImpl() {
		
	}
	
	@Autowired
	private SessionFactory sesh;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sesh = sessionFactory;
	}
	
	
	@Override
	public User findByUsername(String username) {
		
	        Session session = sesh.getCurrentSession();
	        String hql = "from User where username = :user";
	        Query query = session.createQuery(hql);
	        query.setParameter("user", username);
	        User user = (User)query.list().get(0);

	        return user;
	    
		
	}

	@Override
	public void createUser(User user) {
		Session s = sesh.getCurrentSession();
		s.save(user);
		
	}

}

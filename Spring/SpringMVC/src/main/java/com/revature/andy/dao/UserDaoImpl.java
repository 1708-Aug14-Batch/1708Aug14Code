package com.revature.andy.dao;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.andy.model.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{

	public UserDaoImpl() {
		
	}
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public User findUserByUserName(String username) {
		return (User) sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("username", username)).uniqueResult();
	}

	@Override
	public User createUser(User u) {
		sessionFactory.getCurrentSession().save(u);
		return u;
	}
}

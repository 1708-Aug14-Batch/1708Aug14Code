package com.bank.dao;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.bank.domain.User;

public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public UserDaoImpl() {
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public User findUserByUsername(String username) {
		ArrayList<User> list = (ArrayList<User>) sessionFactory.getCurrentSession()
				.createQuery("from User where lower(username)=?").setParameter(0, username.toLowerCase()).list();
		if (list.size() == 0)
			return null;
		else {
			return list.get(0);
		}
	}

	@Override
	public void createUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

}

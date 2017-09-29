package com.revature.dao;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.model.User;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {
	
	public UserDAOImpl() {}
	
	@Autowired
	private SessionFactory factory;
	
	public void setSessionFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public User createUser(User user) {
		Session session = this.factory.getCurrentSession();
		return (User) session.save(user);
	}

	@Override
	public User findUserByUsername(String username) {
		Session session = this.factory.getCurrentSession();
		ArrayList<User> allUsers = (ArrayList<User>) session.createQuery("from User where lower(username) = ?").setParameter(0, username.toLowerCase()).list();
		if (allUsers.size() == 0) {
			return null;
		}
		return allUsers.get(0);
	}

}

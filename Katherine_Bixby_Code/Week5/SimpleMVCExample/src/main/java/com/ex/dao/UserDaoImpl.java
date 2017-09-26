package com.ex.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ex.domain.User;


@Repository
@Transactional
public class UserDaoImpl implements UserDao{

	public UserDaoImpl() {}
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	@Override
	public User findUserByUsername(String username) {
		// TODO Auto-generated method stub
		ArrayList<User> list = (ArrayList<User>) sessionFactory.getCurrentSession()
				.createQuery("from User where lower(username)=?")
				.setParameter(0, username.toLowerCase()).list();
		if(list.size()==0)return null;
		else { return list.get(0);}
	}

	@Override
	public void createUser(User user) {
		// TODO Auto-generated method stub
		Session s = sessionFactory.getCurrentSession();
		s.save(user);
	}

}

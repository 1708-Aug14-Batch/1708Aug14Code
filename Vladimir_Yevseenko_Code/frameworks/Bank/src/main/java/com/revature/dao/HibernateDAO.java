package com.revature.dao;



import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.User;
import com.revature.util.ConnectionUtil;

public class HibernateDAO {
	
	public void addUser(User user) {
		Session session = ConnectionUtil.getSession();
		Transaction transaction = session.beginTransaction();
		
		int newUserId = (Integer) session.save(user);
		user.setId(newUserId);
		
		transaction.commit();
		session.close();
	}
}

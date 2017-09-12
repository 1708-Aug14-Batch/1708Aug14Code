package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.Student;
import com.revature.util.ConnectionUtil;

public class HibernateDAO {
	
	public void addStudent(Student student) {
		Session session = ConnectionUtil.getSession();
		try {
			Transaction tx = (Transaction) session.beginTransaction();
			session.save(student);
			tx.commit();
		} finally {
			session.close();
		}
	}

}

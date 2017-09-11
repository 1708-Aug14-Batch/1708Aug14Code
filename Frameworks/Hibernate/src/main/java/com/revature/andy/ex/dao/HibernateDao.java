package com.revature.andy.ex.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.andy.ex.beans.Student;
import com.revature.andy.ex.util.ConnectionUtil;

public class HibernateDao {
	
	//CREATE
	public void addStudent(Student student) {
		Session session = ConnectionUtil.getSession();
		
		try {
		Transaction tx = (Transaction) session.beginTransaction();
		session.save(student);
		tx.commit();
		}finally {
			session.close();
		}
	}
	
}

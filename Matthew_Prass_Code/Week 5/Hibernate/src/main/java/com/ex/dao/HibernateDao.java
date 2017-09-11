package com.ex.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ex.beans.Student;
import com.ex.util.ConnectionUtil;

public class HibernateDao {

	//create
	public void addStudent(Student s) {
		Session sesh = ConnectionUtil.getSession();
		try {
			Transaction tx = (Transaction)sesh.beginTransaction();
			sesh.save(s);
			tx.commit();
		}
		finally {
			sesh.close();
		}
	}
}

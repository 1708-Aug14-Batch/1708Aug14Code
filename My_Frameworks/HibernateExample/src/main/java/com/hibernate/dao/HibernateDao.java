package com.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.beans.Instructor;
import com.hibernate.beans.Student;
import com.hibernate.beans.Transcript;
import com.hibernate.util.ConnectionUtil;

public class HibernateDao {

	public void addStudent(Student student) {

		Session session = ConnectionUtil.getSession();
		try {
			Transaction tx = (Transaction) session.beginTransaction();
			Transcript transcript = new Transcript();
			session.save(transcript);
			student.setTranscript(transcript);
			session.save(student);
			tx.commit();

		} finally {
			session.close();
		}
	}

	public void addInstructor(Instructor instructor) {

		Session session = ConnectionUtil.getSession();

		try {
			Transaction tx = session.beginTransaction();
			session.save(instructor);
			tx.commit();
		}
		finally {
			session.close();
		}
	}
}

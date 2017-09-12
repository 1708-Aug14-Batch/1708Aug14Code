package com.ex.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ex.beans.Course;
import com.ex.beans.Instructor;
import com.ex.beans.Student;
import com.ex.beans.Transcript;
import com.ex.util.ConnectionUtil;

public class HibDAO {

	public Student addStudent(Student student) {
		Session session = ConnectionUtil.getSession();
		Transcript script = new Transcript();
		
		try {
			Transaction tx = (Transaction) session.beginTransaction();
			int scriptId = (Integer) session.save(script);
			script.setId(scriptId);
			student.setTranscript(script);
			int studentId = (Integer) session.save(student);
			student.setId(studentId);
			tx.commit();
		}
		finally {
			session.close();
		}
		return student;
	}

	public void addInstructor(Instructor instructor) {
		Session session = ConnectionUtil.getSession();
		
		try {
			Transaction tx = (Transaction) session.beginTransaction();
			session.save(instructor);
			tx.commit();
		}
		finally {
			session.close();
		}
	}
	
	public <T> void addSimple(final Class<T> obj) {
		Session session = ConnectionUtil.getSession();
		
		try {
			Transaction tx = (Transaction) session.beginTransaction();
			session.save(obj);
			tx.commit();
		} finally {
			session.close();
		}
	}
	
	public void addCourse(Course c) {
		Session session = ConnectionUtil.getSession();
		
		try {
			Transaction tx = (Transaction) session.beginTransaction();
			session.save(c);
			tx.commit();
		} finally {
			session.close();
		}
	}
	
	public Instructor getInstructorByID(int id) {
		Session session = ConnectionUtil.getSession();
		Instructor i = null;
		
		try {
			i = (Instructor) session.get(Instructor.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return i;
	}
}

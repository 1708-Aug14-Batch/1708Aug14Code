package com.revature.andy.ex.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.andy.ex.beans.Instructor;
import com.revature.andy.ex.beans.Student;
import com.revature.andy.ex.beans.Transcript;
import com.revature.andy.ex.util.ConnectionUtil;

public class HibernateDao {
	
	//CREATE
	public void addStudent(Student student) {
		Session session = ConnectionUtil.getSession();
		Transcript script = new Transcript();
		try {
		Transaction tx = (Transaction) session.beginTransaction();
		session.save(script);
		//student.setTranscript(transcript);
		session.save(student);
		tx.commit();
		}finally {
			session.close();
		}
	}

	//CREATE
	public void addInstructor(Instructor instructor) {
		Session session = ConnectionUtil.getSession();
		
		try {
		Transaction tx = (Transaction) session.beginTransaction();
		session.save(instructor);
		tx.commit();
		}finally {
			session.close();
		}
	}
	
	public List<Student> getAll() {
		Session session = ConnectionUtil.getSession();
		try {
		Transaction tx =(Transaction) session.beginTransaction();
		List<Student> students = session.createCriteria(Student.class).list();
		return students;
		
		}finally {
			session.close();
		}
	}
}

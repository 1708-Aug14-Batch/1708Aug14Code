package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.revature.beans.Instructor;
import com.revature.beans.Student;
import com.revature.beans.Transcript;
import com.revature.util.ConnectionUtil;

public class HibernateDAO {

	public void addStudent(Student s) {
		Session session = ConnectionUtil.getSession();
		Transcript t = new Transcript();
		//Student student;
		try {
			Transaction tx = (Transaction)session.beginTransaction();
			t.setId((Integer)session.save(t));
			s.setTranscript(t);
			//student = (Student)session.save(s);
			session.save(s);
			tx.commit();
		} finally {
			session.close();
		}
		//return student;
	}
	
	public void addInstructor(Instructor i) {
		Session session = ConnectionUtil.getSession();
		
		try {
			Transaction tx = (Transaction)session.beginTransaction();
			session.save(i);
			tx.commit();
		} finally {
			session.close();
		}
	}
	
	public Instructor getInstructorById(int id) {
		Session session = ConnectionUtil.getSession();
		Instructor i = null;
		try {
			i = (Instructor)session.get(Instructor.class, id);
		} catch(HibernateException e) {
			System.out.println("Error");
		} finally {
			session.close();
		}
		return i;
	}
	

	
	public List<Student> getAllStudents() {
		Session session = ConnectionUtil.getSession();
		Criteria criteria = session.createCriteria(Student.class);
		List<Student> students = criteria.list();
		session.close();
		return students;
	}
	
	public List<Student> getStudentsByCriteria() {
		Session session = ConnectionUtil.getSession();
		Criteria criteria = session.createCriteria(Student.class).add(Restrictions.ilike("firstname", "Billy"));
		List<Student> students = criteria.list();
		
		session.close();
		return students;
	}
	
	public List<Student> queryDemo(String like) {
		Session session = ConnectionUtil.getSession();
		String hql = "FROM Student WHERE lower(Firstname) LIKE :name"; //Student refers to the actual Java class!!!
		Query query = session.createQuery(hql);
		query.setParameter("name", like);
		List<Student> students = query.list();
		
		session.close();
		return students;
	}
	public Student getStudentById(int id) {
		Session session = ConnectionUtil.getSession();
		Student s = null;
		try {
			s = (Student)session.get(Student.class, id);
		} catch(HibernateException e) {
			System.out.println("Error");
		} finally {
			session.close();
		}
		return s;
	}
	public void deleteStudentById(int id) {
		Session session = ConnectionUtil.getSession();
		Student s = getStudentById(id);
		Transaction tx = (Transaction)session.beginTransaction();
		session.delete(s.getTranscript());
		session.delete(s);
		tx.commit();
		
		session.close();
	}
	
}

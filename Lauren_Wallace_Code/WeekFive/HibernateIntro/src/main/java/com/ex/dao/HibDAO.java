package com.ex.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.ex.beans.Course;
import com.ex.beans.Instructor;
import com.ex.beans.Student;
import com.ex.beans.Transcript;
import com.ex.util.ConnectionUtil;

public class HibDAO {
	
	//TEST THIS OUT
	public <T> void addSimple(final Class<T> obj) {
		Session session = ConnectionUtil.getSession();
		
		try {
			Transaction tx = (Transaction) session.beginTransaction();
			session.save(obj);
			tx.commit();
		}
		finally {
			session.close();
		}
	}
	
	//CREATE A STUDENT
	public Student addStudent(Student student) {
		Session session = ConnectionUtil.getSession();
		Transcript script = new Transcript();
		try {
			Transaction tx = (Transaction) session.beginTransaction();
			
			int scriptId = (Integer) session.save(script);
			script.setId(scriptId);
			student.setTranscript(script);
			
			student = (Student) session.save(student);
			tx.commit();
		}
		finally {
			session.close();
		}
		return student;
	}
	
	//CREATE AN INSTRUCTOR
	public void addInstructor(Instructor instructor) {
		Session session = ConnectionUtil.getSession();

		try {
			Transaction tx = (Transaction) session.beginTransaction();
			session.save(instructor);
			tx.commit();
		} finally {
			session.close();
		}
	}
	
	//CREATE A COURSE
	public void addCourse(Course course) {
		Session session = ConnectionUtil.getSession();

		try {
			Transaction tx = (Transaction) session.beginTransaction();
			session.save(course);
			tx.commit();
		} finally {
			session.close();
		}
	}
	
	//GET AN STUDENT BY ID
	public Student getStudentByID(int id) {
		Session session = ConnectionUtil.getSession();
		Student s = null;
		
		try {
			s = (Student) session.get(Student.class, id);
		}
		catch(HibernateException e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return s;
	}
	
	/*
	 * Criteria is a simplifed API for retrieving entities by composing Criterion objects.
	 * 
	 * 
	 * 
	 * 
	 */
	
	//GET ALL STUDENTS 
	public List<Student> getAllStudents() {
		Session session = ConnectionUtil.getSession();
		Criteria criteria = session.createCriteria(Student.class);
		List<Student> students = criteria.list();
		session.close();
		return students;
	}
	
	//CRITERIA DEMO WITH MORE SPECIFICS
	public List<Student> criteriaDemo() {
		Session session = ConnectionUtil.getSession();
		Criteria criteria = session.createCriteria(Student.class).add(Restrictions.ilike("firstname", "Lilly"));
		List<Student> students = criteria.list();
		
		session.close();
		return students;
	}
	
	//QUERY DEMO
	public List<Student> queryDemo(String like) {
		Session session = ConnectionUtil.getSession();
		String hql = "from Student where lower(firstname) like :name";
		Query query = session.createQuery(hql);
		query.setParameter("name", like);
		List<Student> students = query.list();
		
		return students;
	}
	
	//GET AN INSTRUCTOR BY ID
	public Instructor getInstructorByID(int id) {
		Session session = ConnectionUtil.getSession();
		Instructor i = null;
		
		try {
			i = (Instructor) session.get(Instructor.class, id);
		}
		catch(HibernateException e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return i;
	}
	
	//GET ALL INSTRUCTORS
	public List<Student> getAllInstructors() {
		Session session = ConnectionUtil.getSession();
		Criteria criteria = session.createCriteria(Instructor.class);
		List<Student> instructors = criteria.list();
		session.close();
		return instructors;
	}
	
	//DELETE A STUDENT
	public void deleteStudentById(int id) {
		Session session = ConnectionUtil.getSession();
		
		try {
			Transaction tx = (Transaction) session.beginTransaction();
			Student su = getStudentByID(id);
			Transcript ut = su.getTranscript();
			session.delete(ut);
			session.delete(su);
			tx.commit();
		}
		catch(HibernateException e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}
	
	//DELETE AN INSTRUCTOR
	
	
}

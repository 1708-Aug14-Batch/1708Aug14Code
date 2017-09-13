package com.ex.dao;

import java.util.ArrayList;
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
	
	public List<Student> getAllStudents() {
		Session session = ConnectionUtil.getSession();
		Criteria criteria = session.createCriteria(Student.class);
		List<Student> students = criteria.list();
		session.close();
		return students;
	}
	
	//Criteria Demo for more specifics
	public List<Student> criteriaDemo() {
		Session session = ConnectionUtil.getSession();
		Criteria criteria = session.createCriteria(Student.class).
				add(Restrictions.ilike("firstname", "test%"));
		List<Student> students = criteria.list();
		session.close();
		return students;
	}

	public List<Student> queryDemo(String like) {
		Session session = ConnectionUtil.getSession();
		String hql = "from Student where lower(firstname) like :name";
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
			s = (Student) session.get(Student.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
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

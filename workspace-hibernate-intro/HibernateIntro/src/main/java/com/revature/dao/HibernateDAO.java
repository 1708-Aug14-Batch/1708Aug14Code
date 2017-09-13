package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.revature.model.Instructor;
import com.revature.model.Student;
import com.revature.model.Transcript;
import com.revature.util.ConnectionUtil;

public class HibernateDAO {
	
	public void addStudent(Student student) {
		Session session = ConnectionUtil.getSession();
		Transcript tscript = new Transcript();
		try {
			Transaction tx = (Transaction) session.beginTransaction();
			int scriptID = (Integer) session.save(tscript);
			tscript.setTranscriptID(scriptID);
			student.setTranscript(tscript);
			session.save(student);
			tx.commit();
		} finally {
			session.close();
		}
	}
	
	public List<Student> readAllStudents() {
		Session session = ConnectionUtil.getSession();
		Criteria criteria = session.createCriteria(Student.class);
		List<Student> students = criteria.list();
		session.close();
		return students;
	}
	
	public List<Student> criteriaDemo() {
		Session session = ConnectionUtil.getSession();
		Criteria criteria = session.createCriteria(Student.class).add(Restrictions.ilike("first_name", "Jim%"));
		List<Student> students = criteria.list();
		session.close();
		return students;
	}
	
	public List<Student> queryDemo(String like) {
		Session session = ConnectionUtil.getSession();
		String hql = "from Student where lower(first_name) like :name";
		Query query = session.createQuery(hql);
		query.setParameter("name", like);
		List<Student> students = query.list();
		return students;
	}
	
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
	
	public <T> void addSimple(final T obj) {
		Session session = ConnectionUtil.getSession();
		try {
			Transaction transaction = (Transaction) session.beginTransaction();
			session.save(obj);
			transaction.commit();
		} finally {
			session.close();
		}
	}
	
	public Instructor readInstructor(int id) {
		Session session = ConnectionUtil.getSession();
		Instructor instructor = null;
		try {
			instructor = (Instructor) session.get(Instructor.class, id);
		} catch(HibernateException he) {
			he.printStackTrace();
		} finally {
			session.close();
		}
		return instructor;
	}
	
	public Student readStudent(int id) {
		Session session = ConnectionUtil.getSession();
		Student student = null;
		try {
			student = (Student) session.get(Student.class, id);
		} catch(HibernateException he) {
			he.printStackTrace();
		} finally {
			session.close();
		}
		return student;
	}
	
	public void destroyStudent(int id) {
		Session session = ConnectionUtil.getSession();
		// read student
		// begin transaction
		// session.delete(s.getTranscritp())
		// session.delete(s)
		// transaction.commit()
		session.close();
	}
	
	public void destroyTranscript(int id) {
		
	}

}

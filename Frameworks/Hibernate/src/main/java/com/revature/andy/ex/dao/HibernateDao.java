package com.revature.andy.ex.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.revature.andy.ex.beans.Instructor;
import com.revature.andy.ex.beans.Student;
import com.revature.andy.ex.beans.Transcript;
import com.revature.andy.ex.util.ConnectionUtil;

public class HibernateDao {
	
	//CREATE
	public Student addStudent(Student student) {
		Session session = ConnectionUtil.getSession();
		
		Transcript script = new Transcript();
		try {
		Transaction tx = (Transaction) session.beginTransaction();
		int scriptId = (Integer) session.save(script);
		script.setId(scriptId);
		student.setTranscript(script);
		int studentID = (Integer) session.save(student);
		student.setId(studentID);
		
		tx.commit();
		}finally {
			session.close();
		}
		return student;
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
	
	public Instructor getInstructorByID(int id) {
		Session session = ConnectionUtil.getSession();
		Instructor i = null;
		try {
			i = (Instructor) session.get(Instructor.class, id);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return i;
	}
	
	//Criteria Demo for more specifics
	public List<Student> criteriaDemo(){

		Session session = ConnectionUtil.getSession();
		try {
		Transaction tx =(Transaction) session.beginTransaction();
		List<Student> students = session.createCriteria(Student.class).add(Restrictions.ilike("firstname", "Hellol")).list();
		return students;
		}finally {
			session.close();
		}
	}
	
	// doesnt work for some reason?
	public List<Student> queryDemo(String like){
		
		Session session = ConnectionUtil.getSession();
		// student object must be proper spelling in hql
		String hql = "from Student where lower(firstname) like:name";
		Query query = session.createQuery(hql);
		query.setParameter("name", like);
		List<Student> students = query.list();
		//session.close();
		return students;	
	}
	
	
	// delete
	public void deleteStudent(int id) {
		Session session = ConnectionUtil.getSession();
		try {
		Transaction tx =(Transaction) session.beginTransaction();
		Student s = (Student) session.get(Student.class, id);
		session.delete(s.getTranscript());
		session.delete(s);
		tx.commit();
		}finally {
			session.close();
		}
	}
}

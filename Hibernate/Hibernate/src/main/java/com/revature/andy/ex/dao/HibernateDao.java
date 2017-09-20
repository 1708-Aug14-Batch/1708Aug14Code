package com.revature.andy.ex.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.revature.andy.ex.beans.Instructor;
import com.revature.andy.ex.beans.User;
import com.revature.andy.ex.beans.Account;
import com.revature.andy.ex.util.ConnectionUtil;

public class HibernateDao {
	
	//CREATE
	public User addStudent(User student) {
		Session session = ConnectionUtil.getSession();
		
		Account script = new Account();
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
	
	public List<User> getAll() {
		Session session = ConnectionUtil.getSession();
		try {
		Transaction tx =(Transaction) session.beginTransaction();
		List<User> students = session.createCriteria(User.class).list();
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
	public List<User> criteriaDemo(){

		Session session = ConnectionUtil.getSession();
		try {
		Transaction tx =(Transaction) session.beginTransaction();
		List<User> students = session.createCriteria(User.class).add(Restrictions.ilike("firstname", "Hellol")).list();
		return students;
		}finally {
			session.close();
		}
	}
	
	// doesnt work for some reason?
	public List<User> queryDemo(String like){
		
		Session session = ConnectionUtil.getSession();
		// student object must be proper spelling in hql
		String hql = "from Student where lower(firstname) like:name";
		Query query = session.createQuery(hql);
		query.setParameter("name", like);
		List<User> students = query.list();
		//session.close();
		return students;	
	}
	
	
	// delete
	public void deleteStudent(int id) {
		Session session = ConnectionUtil.getSession();
		try {
		Transaction tx =(Transaction) session.beginTransaction();
		User s = (User) session.get(User.class, id);
		session.delete(s.getTranscript());
		session.delete(s);
		tx.commit();
		}finally {
			session.close();
		}
	}
}

package com.rev.dao;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.rev.beans.Instructor;
import com.rev.beans.Student;
import com.rev.beans.Transcript;
import com.rev.util.ConnectionUtil;

public class HibDAO {

	public List<Instructor> getAllInstructors() {
		Session session = ConnectionUtil.getSession();
		Criteria criteria = session.createCriteria(Instructor.class);
		List<Instructor> instructors = criteria.list();
		session.close();
		return instructors;
	}
	
	public List<Student> getAllStudents() {
		Session session = ConnectionUtil.getSession();
		Criteria criteria = session.createCriteria(Student.class);
		List<Student> students = criteria.list();
		session.close();
		return students;
	}
	
	public List<Student> criteriaDemo(){
		Session session = ConnectionUtil.getSession();
		Criteria criteria = session.createCriteria(Student.class)
				.add(Restrictions.ilike("firstname", "Test%"));
		List<Student> students = criteria.list();
		
		session.close();
		return students;
	}
	
	public List<Student> queryDemo(String like){
		//select * from students where lower(firstname) like '%t%;
		Session session = ConnectionUtil.getSession();
		String hql = "from Student where lower(firstname) like :name";
		Query query = session.createQuery(hql);
		query.setParameter("name", like);
		List<Student> students = query.list();
		
		return students;
	}
	
	
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
	
	
	//CREATE
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
	
	// Adding any object that doesn't have dependencies
	// i.e. not students
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
	
	
	public Student getStudentById(int id) {
		Session session = ConnectionUtil.getSession();
		Student i = null;
		try {
			i = (Student) session.get(Student.class, id);
		}
		catch(HibernateException e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return i;
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

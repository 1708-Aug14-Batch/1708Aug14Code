package com.ex.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.ex.beans.Instructor;
import com.ex.beans.Student;
import com.ex.beans.Transcript;
import com.ex.util.ConnectionUtil;

public class HibDAO {

	//CREATE
	public Student addStudent(Student student) {
		Session session = ConnectionUtil.getSession();
		Transcript script = new Transcript();
		try {
			Transaction tx = (Transaction)session.beginTransaction();
			script.setId((Integer) session.save(script));
			student.setTranscript(script);
			student.setId((Integer) session.save(student));
			tx.commit();
		}
		finally {
			session.close();
		}
		return student;
	}
	
	public void addInstructor(Instructor inst) {
		Session session = ConnectionUtil.getSession();
		try {
			Transaction tx = (Transaction)session.beginTransaction();
			session.save(inst);
			tx.commit();
		}
		finally {
			session.close();
		}
	}
	
	public void getAllInstructors() {
		Session session = ConnectionUtil.getSession();
		try {
			Query query = session.createQuery("from Instructor");
			List<Instructor> list = query.list();
			for(int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).getName());
			}
		}
		finally {
			session.close();
		}
	}
	
	public List<Student> getAllStudents() {
		Session ses = ConnectionUtil.getSession();
		Criteria cr = ses.createCriteria(Student.class);
		List<Student> stl = cr.list();
		ses.close();
		return stl;
	}
	
	public List<Student> criteriaDemo() {
		Session ses = ConnectionUtil.getSession();
		Criteria cr = ses.createCriteria(Student.class).add(Restrictions.ilike("firstname", "Trevor"));
		List<Student> stl = cr.list();
		ses.close();
		return stl;
	}
	
	public List<Student> queryDemo(String like) {
		Session ses = ConnectionUtil.getSession();
		String hql = "from Student where lower(firstname) like :name";
		Query query = ses.createQuery(hql);
		query.setParameter("name", like);
		List<Student> st = query.list();
		ses.close();
		return st;
	}
	
	public Instructor getInstructorbyID(int id) {
		Session session = ConnectionUtil.getSession();
		Instructor i = null;
		try {
			i = (Instructor) session.get(Instructor.class, id);
		}
		finally {
			session.close();
		}
		return i;
	}
	
	public Student getStudentbyID(int id) {
		Session session = ConnectionUtil.getSession();
		Student i = null;
		try {
			i = (Student) session.get(Student.class, id);
		}
		finally {
			session.close();
		}
		return i;
	}
	
	public boolean deleteStudentById(int id) {
		Session ses = ConnectionUtil.getSession();
		Transaction tx = (Transaction)ses.beginTransaction();
		Student s = getStudentbyID(id);
		ses.delete(s.getTranscript());
		ses.delete(s);
		tx.commit();
		ses.close();
		return false;
	}
	
}

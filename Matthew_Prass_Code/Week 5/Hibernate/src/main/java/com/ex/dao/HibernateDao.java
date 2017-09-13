package com.ex.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.ex.beans.Instructor;
import com.ex.beans.Student;
import com.ex.beans.Transcript;
import com.ex.util.ConnectionUtil;

public class HibernateDao {

	//create
	public Student addStudent(Student s) {
		Session sesh = ConnectionUtil.getSession();
		Transcript t = new Transcript();
		try {
			Transaction tx = (Transaction)sesh.beginTransaction();
			int scriptid = (Integer)sesh.save(t);
			t.setId(scriptid);
			s.setT(t);
			sesh.save(s);
			tx.commit();
		}
		finally {
			sesh.close();
		}
		return s;
	}
	
	public void addInstructor(Instructor i) {
		Session sesh = ConnectionUtil.getSession();
		try {
			Transaction tx = (Transaction)sesh.beginTransaction();
			sesh.save(i);
			tx.commit();
		}
		finally {
			sesh.close();
		}
	}
	
	public ArrayList<Instructor> getAllInstructors(){
		Session sesh = ConnectionUtil.getSession();
		ArrayList<Instructor> instructors = (ArrayList<Instructor>) sesh.createCriteria(Instructor.class).list();
		sesh.close();
		return instructors;
	}
	
	public ArrayList<Student> getAllStudents(){
		Session sesh = ConnectionUtil.getSession();
		ArrayList<Student> students = (ArrayList<Student>) sesh.createCriteria(Instructor.class).list();
		sesh.close();
		return students;
	}
	
	public List<Student> criertiaDemo(){
		Session sesh = ConnectionUtil.getSession();
		Criteria cri = sesh.createCriteria(Student.class).add(Restrictions.ilike("fn", "test%"));
		List<Student> students = cri.list();
		sesh.close();
		return students;
	}
	
	public List<Student> queryDemo(String like){
		Session sesh = ConnectionUtil.getSession();
		
		String hql = "from Student where lower(fn) like :name";
		Query q = sesh.createQuery(hql);
		q.setParameter("name", like);
		List<Student> studs = q.list();
		sesh.close();
		return studs;
	}
	
	public <T> void addSimple(final Class<T> obj) {
		Session sesh = ConnectionUtil.getSession();
		try {
			Transaction tx = (Transaction)sesh.beginTransaction();
			sesh.save(obj);
			tx.commit();
		}
		finally {
			sesh.close();
		}
	}
	
	public Instructor getInstructorById(int id) {
		Session sesh = ConnectionUtil.getSession();
		Instructor i = null;
		try {
			i = (Instructor) sesh.get(Instructor.class, id);
		}
		catch(HibernateException e) {
			e.printStackTrace();
		}
		finally {
			sesh.close();
		}
		return i;
	}
	
	public Student deleteStudent(int id) {
		Session sesh = ConnectionUtil.getSession();
		Student s = null;
		try {
			
			Transaction tx = (Transaction)sesh.beginTransaction();
			s = (Student) sesh.get(Student.class, id);
			sesh.delete(s.getT());
			sesh.delete(s);
			tx.commit();
		}
		catch(HibernateException e) {
			e.printStackTrace();
		}
		finally {
			sesh.close();
		}
		return s;
	}
}

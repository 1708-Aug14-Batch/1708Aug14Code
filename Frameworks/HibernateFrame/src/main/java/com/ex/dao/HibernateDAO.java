package com.ex.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.ex.bean.Course;
import com.ex.bean.Instructor;
import com.ex.bean.Student;
import com.ex.bean.Transcript;
import com.ex.util.ConnectionUtil;

public class HibernateDAO {

	//create student w/new transcript
	public Student addStudent(Student student){
		Session session = ConnectionUtil.getSession();
		
		//new transcript on student create
		Transcript script = new Transcript();
		
		try{
		Transaction tx = (Transaction) session.beginTransaction();
	
		script.setId((Integer)session.save(script));
		student.setTranscript(script);
		student.setId((Integer)session.save(student));
		
		tx.commit();
			
		}finally{
			session.close();
		}
		
		return student;
	}
	
	public List<Student> getAllStudents(){
		Session session = ConnectionUtil.getSession();
		Criteria criteria = session.createCriteria(Student.class);
		List<Student> students = criteria.list();
		session.close();
		return students;
	}
	
	public List<Student> useCriteriaForStudents(){
		Session session = ConnectionUtil.getSession();
		Criteria criteria = session.createCriteria(Student.class);
		criteria.add(Restrictions.ilike("firstname", "Steven"));
		criteria.add(Restrictions.lt("transcript_id", 200));
		
		List<Student> students = criteria.list();
		
		
		
		session.close();
		return students;
	}
	
	public List<Student> lowercaseFirstnameStudents(String like){
		Session session = ConnectionUtil.getSession();
		String hql = "from Student where lower(firstname) like :name";
		Query query = session.createQuery(hql);
		query.setParameter("name", like);
		List<Student> students = query.list();
		
		return students;
	}
	
	public void deleteStudent(int id)
	{
		//session and transaction
	    Session session = ConnectionUtil.getSession();
	    Transaction tx = (Transaction) session.beginTransaction();
	    
	    //student
	    Query q = session.createQuery("from Student where student_id = :sid ");
	    q.setParameter("sid", id);
	    Student s = (Student) q.list().get(0);
	    System.out.println(s.toString());
	    
	    //transcript 
	    Transcript t = s.getTranscript();
	    System.out.println(t.toString());

	    //delete em
	    session.delete(s);
	    session.delete(t);
	    
	    //commit and close
	    tx.commit();
	    session.close();
	}
	
	public void addInstructor(Instructor instructor){
		Session session = ConnectionUtil.getSession();
		
		try{
		Transaction tx = (Transaction) session.beginTransaction();
		session.save(instructor);
		tx.commit();
			
		}finally{
			session.close();
		}
	}
	
	public List<Instructor> getAllInstructors(){
		Session session = ConnectionUtil.getSession();
		List<Instructor> list = session.createCriteria(Instructor.class).list();
		return list;
	}
	
	public Instructor getInstructorById(int id){
		Session session = ConnectionUtil.getSession();
		Instructor i = null;
		try{
			i = (Instructor) session.get(Instructor.class, id);
			
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return i;
	}
	
	public void addCourse(Course course){
		Session session = ConnectionUtil.getSession();
		
		try{
		Transaction tx = (Transaction) session.beginTransaction();
		session.save(course);
		tx.commit();
			
		}finally{
			session.close();
		}
	}
	
	
}

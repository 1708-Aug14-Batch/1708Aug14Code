package com.ex.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

import javassist.bytecode.CodeAttribute.RuntimeCopyException;

public class HibDAO {


	//CREATE 
	public Student addStudent(Student student){
		Session session = ConnectionUtil.getSession();
		Transcript script = new Transcript();
		try{
			Transaction tx = (Transaction) session.beginTransaction();

			int scriptId = (Integer) session.save(script);
			script.setId(scriptId);
			student.setTranscript(script);

			int studentId = (Integer) session.save(student);
			student.setId(studentId);

			tx.commit();
		}
		finally{
			session.close();
		}

		return student;
	}




	public void addInstructor(Instructor instructor){
		Session session = ConnectionUtil.getSession();

		try{
			Transaction tx = (Transaction) session.beginTransaction();
			session.save(instructor);
			tx.commit();
		}
		finally{
			session.close();
		}
	}

	public Course addCourse(Course c){
		Session session = ConnectionUtil.getSession();
		Course ret = null;
		Transaction tx = (Transaction) session.beginTransaction();
		
		try{
			int id = (Integer)session.save(c);
			c.setId(id);
			tx.commit();
			ret = c;
		}
		catch(RuntimeException e){
			/*
			 *  Looking into hibernate transaction commands
			 *  In Hibernate, tx management is difficult, so 
			 *  remember that any exceptions thrown are FATAL, 
			 *  and you have to roll back the transaction and
			 *  close the cufrrent session immediately 
			 */
			try{
				tx.rollback();
			}catch(RuntimeException re){
				re.printStackTrace();;
			}
		}
		finally{
			session.close();
		}
		return ret;
	}



	//READ *********************************************
	/*
	 * Often, we will see Hibernate applications that use a mix
	 * of session.get() and session.load(). Both are used to 
	 * retrieve objects, just with different mechanisms
	 * for more, see: http://www.mkyong.com/hibernate/different-between-session-get-and-session-load/
	 */

	/**
	 * session.get() will always hit the database and return the 
	 * real object (an object that represents a row in the db),
	 * not a proxy.
	 * if the row isnt found, get() will return null
	 */
	public Instructor getInstructorByID(int id){
		Session session = ConnectionUtil.getSession();
		Instructor i = null;
		try{
			i = (Instructor) session.get(Instructor.class, id);
		}
		catch(HibernateException e){
			e.printStackTrace();

		}
		finally{
			session.close();
		}
		return i;
	}

	/*
	 * session.load() will always return a "proxy"(Hibernate
	 * term) without hitting the database. In Hibernate, a proxy is 
	 * an object with the given identifier value; its properties
	 * are not initialized yet. It looks like a temporary fake object
	 * If no row is found, it throws an ObjectNotFoundException, 
	 * so only use this if you're sure the object exists
	 */
	public Instructor loadInstructorByID(int id){
		Session session = ConnectionUtil.getSession();
		Instructor i = null;
		try{
			i = (Instructor) session.load(Instructor.class, id);
		}
		catch(HibernateException e){
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		return i;
	}

	/*Criteria is a simplified API for retrieving entities 
	by composing Criterion objects. This is a very 
	convenient approach for functionality like "search" screens 
	where there is a variable number of conditions to be placed 
	upon the result set.								
	 */

	public List<Student> getAllStudents(){
		Session session = ConnectionUtil.getSession();
		Criteria criteria = session.createCriteria(Student.class);
		List<Student> students = criteria.list();
		session.close();
		return students;
	}

	//Criteria Demo for more specifics
	/*
	 * What the SQL Query looks like:
	 * Hibernate: select this_.STUDENT_ID as 
	 * STUDENT1_0_0_, this_.email as email0_0_, 
	 * this_.firstname as firstname0_0_, this_.lastname
	 *  as lastname0_0_, this_.TRANSCRIPT_ID as 
	 *  TRANSCRIPT5_0_0_ from STUDENTS this_ where 
	 *  this_.firstname like ?

	 */
	public List<Student> criteriaDemo(){
		Session session = ConnectionUtil.getSession();
		Criteria criteria = 
				session.createCriteria(Student.class).
				add(Restrictions.ilike("firstname","test%"));
		List<Student> students = criteria.list();

		session.close();
		return students;
	}

	/*
	 * Understanding the Query API
	 * Queries use the Hibernate Query Language - not to be 
	 * confused with SQL. The main difference is that HQL 
	 * uses class and property names instead of table and
	 * column names, respectively 
	 */
	public List<Student> queryDemo(String like){
		//select* from students where lower(firstname) like '%t%';
		Session session = ConnectionUtil.getSession();
		String hql = "from Student where lower(firstname) like :name";
		Query query = session.createQuery(hql);
		query.setParameter("name", like);
		List<Student> students = query.list();

		return students;
	}

	//calling an HQL named query example
	public List<Instructor> getNamesLike(String like){
		Session session = ConnectionUtil.getSession();
		Query query = session.getNamedQuery("findInstructorByNameHQL")
				.setString("name", like);
		List<Instructor> i= query.list();
		return i;
	}

	//calling native sql named query. same syntax
	public Instructor getInstructorById(int id){
		Session session = ConnectionUtil.getSession();
		Query query = session.getNamedQuery("findInstructorByIdSQL")
				.setInteger("id", id);
		Instructor i = (Instructor) query.list().get(0);
		return i;
	}



	//UPDATE
	public void addCourseToTranscript(Transcript t, Course c){
		Set<Course> courses = t.getCourses();
		if(courses != null){
			for(Course temp :courses){
				courses.add(temp);
			} 
		}
		courses.add(c);

		t.setCourses(courses);
		Session session = ConnectionUtil.getSession();
		try{
			Transaction tx = session.beginTransaction();
			session.update(t);
			tx.commit();
		}
		finally{
			session.close();
		}
	}

	
	//DELETE
	public void deleteInstructorByIdQuery(int id){
		Session session = ConnectionUtil.getSession();
		Query query = session.createQuery("delete Instructor where id = :id");
		query.setParameter("id",id);
		int ret = query.executeUpdate();
		System.out.println(ret + " Rows Deleted");
	}

}

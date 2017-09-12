package com.ex.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ex.beans.Instructor;
import com.ex.beans.Student;
import com.ex.beans.Transcript;
import com.ex.util.ConnectionUtil;

public class HibDAO {
	
	
	//CREATE 
	public void addStudent(Student student){
		Session session = ConnectionUtil.getSession();
		Transcript script = new Transcript();
		try{
		Transaction tx = (Transaction) session.beginTransaction();
		session.save(script);
		session.save(student);
		tx.commit();
		}
		finally{
			session.close();
		}
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
	

}

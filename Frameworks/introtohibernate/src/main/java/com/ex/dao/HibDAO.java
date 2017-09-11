package com.ex.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ex.beans.Student;
import com.ex.util.ConnectionUtil;

public class HibDAO {
	
	
	//CREATE
	public void addStudent(Student student){
		Session session = ConnectionUtil.getSession();
		
		try{
		Transaction tx = (Transaction) session.beginTransaction();
		session.save(student);
		tx.commit();
		}
		finally{
			session.close();
		}
	}

}

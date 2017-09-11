package com.x.dao;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.x.bean.Student;
import com.x.util.ConnectionUtil;

public class UibDAO {
	
	//CREATE
	public void addStudent(Student student){
		Session session =ConnectionUtil.getSession();
		
		try {
			Transaction tx =(Transaction)session.beginTransaction();
			session.save(student);
			tx.commit();
		}finally{
			session.close();
		}
	}
}

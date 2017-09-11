package com.revature.andy.test;

import com.revature.andy.ex.beans.Student;
import com.revature.andy.ex.dao.HibernateDao;

public class MainTest {

	public static void main(String[] args) {
		HibernateDao dao = new HibernateDao();
		Student s = new Student();
		
		s.setFirstname("Jeff");
		s.setLastname("Zheng");
		s.setEmail("az@email.com");
		
		dao.addStudent(s);
	}
	
}

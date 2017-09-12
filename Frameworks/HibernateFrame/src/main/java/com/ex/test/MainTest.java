package com.ex.test;

import com.ex.bean.Student;
import com.ex.dao.HibernateDAO;

public class MainTest {

	public static void main(String[] args) {
		HibernateDAO dao = new HibernateDAO();
		Student s = new Student();
		
		s.setFirstname("Steven");
		s.setLastname("Leighton");
		s.setEmail("sleighton@mail.com");
		
		dao.addStudent(s);
		
	}
}

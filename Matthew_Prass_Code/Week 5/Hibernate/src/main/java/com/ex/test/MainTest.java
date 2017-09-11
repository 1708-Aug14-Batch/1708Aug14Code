package com.ex.test;

import com.ex.beans.Student;
import com.ex.dao.HibernateDao;

public class MainTest {

	public static void main(String[] args) {
		HibernateDao h= new HibernateDao();
		Student s = new Student();
		s.setFn("matt");
		s.setLn("prass");
		s.setEmail("something");
		
		h.addStudent(s);

	}

}

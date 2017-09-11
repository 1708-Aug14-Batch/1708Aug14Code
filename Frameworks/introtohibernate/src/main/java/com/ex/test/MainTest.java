package com.ex.test;

import com.ex.beans.Student;
import com.ex.dao.HibDAO;

public class MainTest {

	public static void main(String[] args) {

		HibDAO dao = new HibDAO();
		Student s = new Student();
		s.setFirstname("Gen");
		s.setLastname("Bonds");
		s.setEmail("genbo@123.321");
		
		dao.addStudent(s);
	}

}

package com.revature.test;

import com.revature.beans.Instructor;
import com.revature.beans.Student;
import com.revature.dao.HibernateDAO;

public class MainTest {
	
	public static void main(String[] args) {
		HibernateDAO dao = new HibernateDAO();
		
		Student s = new Student();
		s.setFirstname("Daniel");
		s.setLastname("Fairbanks");
		s.setEmail("dlf@gmail.com");
		//dao.addStudent(s);
		//System.out.println(dao.getStudentsByCriteria().get(0).getEmail());
		//System.out.println(dao.queryDemo("bill%").get(0).toString());
		dao.deleteStudentById(250);
		//System.out.println(st.toString());
	}
}

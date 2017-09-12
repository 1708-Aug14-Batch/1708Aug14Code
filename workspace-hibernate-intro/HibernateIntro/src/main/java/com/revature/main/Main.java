package com.revature.main;

import com.revature.dao.HibernateDAO;
import com.revature.model.Student;

public class Main {

	public static void main(String[] args) {
		HibernateDAO dao = new HibernateDAO();
		Student student = new Student();
		student.setFirstName("Jim");
		student.setLastName("Halpert");
		student.setEmail("halpert@dundermifflin.com");
		dao.addStudent(student);
	}

}

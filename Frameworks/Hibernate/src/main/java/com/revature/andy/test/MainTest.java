package com.revature.andy.test;

import java.util.List;

import com.revature.andy.ex.beans.Instructor;
import com.revature.andy.ex.beans.Student;
import com.revature.andy.ex.dao.HibernateDao;

public class MainTest {

	public static void main(String[] args) {
		HibernateDao dao = new HibernateDao();
		Student s = new Student();
		
		s.setFirstname("Hellol");
		s.setLastname("World");
		s.setEmail("az@taco.com");
		
		//dao.addStudent(s);
		
		//Instructor i = new Instructor();
		//i.setName("Dr. Bonds");
		//dao.addInstructor(i);
		
		/*
		List<Student> testStudent = dao.getAll();
		for(Student x : testStudent) {
			System.out.println(x.toString());
		}*/
		
		//System.out.println(testStudent.get(1).toString());
		
		/*
		List<Student> testStudent2 = dao.criteriaDemo();
		
		for(Student x : testStudent2) {
			System.out.println(x.toString());
		}*/
		
		/*????????????
		List<Student> testStudent3 = dao.queryDemo("Hellol");
		for(Student x : testStudent3) {
			System.out.println(x.toString());
		}*/
		
		//dao.deleteStudent(400);
	
	
	}
}

package com.revature.main;

import java.util.List;

import com.revature.dao.HibernateDAO;
import com.revature.model.Instructor;
import com.revature.model.Student;
import com.revature.model.Transcript;

public class Main {

	public static void main(String[] args) {
		HibernateDAO dao = new HibernateDAO();
		/*Student student = new Student();
		student.setFirstName("Jim");
		student.setLastName("Halpert");
		student.setEmail("halpert@dundermifflin.com");
		dao.addStudent(student);
		
		Instructor instructor = new Instructor();
		instructor.setInstructorName("Dr. Beasley");
		dao.addInstructor(instructor);*/
		
		/*
		List<Student> students = dao.readAllStudents();
		for (Student student : students) {
			System.out.println(student.getFirstName());
		}
		*/
		
		/*
		Student simple = new Student();
		simple.setFirstName("Stanley");
		simple.setLastName("Tweedle");
		simple.setEmail("stanley@lexx.biz");
		simple.setTranscript(new Transcript());
		dao.addSimple(simple);
		*/
		
		for(Student student : dao.queryDemo("%i%")) {
			System.out.println(student.getFirstName());
		}
	}

}

package com.ex.test;


import com.ex.beans.Instructor;
import com.ex.beans.Student;
import com.ex.dao.HibDAO;

public class MainTest {
	
	public static void main(String[] args) {
		
		HibDAO dao = new HibDAO();
		Student student = new Student();
		Student stu = new Student();
		
		student.setFirstname("Rose");
		student.setLastname("Dawn");
		student.setEmail("rDawn");
		
		stu.setFirstname("Rowan");
		stu.setLastname("Towers");
		stu.setEmail("rTowers");
		 
	    dao.addStudent(student);
	    dao.addStudent(stu);
	    
	    //dao.queryDemo("Rose");
	    
	    //dao.getStudentByID(50);
	    
	    //dao.getAllStudents();
	    
	    //dao.criteriaDemo();
		//dao.addSimple(stu);
		
		//dao.deleteStudentById(50);
	}

}

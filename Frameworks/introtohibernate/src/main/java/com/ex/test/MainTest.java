package com.ex.test;

import com.ex.beans.Course;
import com.ex.beans.Instructor;
import com.ex.beans.Student;
import com.ex.beans.Transcript;
import com.ex.dao.HibDAO;

public class MainTest {

	public static void main(String[] args) {

		HibDAO dao = new HibDAO();
		Instructor inst = new Instructor();

		inst.setName("Dr. Generic");

		//dao.addSimple(inst);

		//		dao.addInstructor(inst);
		//		
				Student st = new Student();
				st.setFirstname("testing");
				st.setLastname("transcripts");
				st.setEmail("1567");
			
		st = dao.addStudent(st);
		System.out.println(st.toString());
		////		
		
		Instructor i = dao.getInstructorByID(100);
		System.out.println(i.toString());
				Course c = new Course();
				c.setInstructor(i);
				c.setDescription("This is a great class!");
				c.setName("Intro to Java 105");
				c = dao.addCourse(c);
				Transcript t = st.getTranscript();
				dao.addCourseToTranscript(t, c);


//		List<Student> stud = dao.queryDemo("t%");
//		for(Student s : stud){
//			System.out.println(s.toString());
//		}
	}


}

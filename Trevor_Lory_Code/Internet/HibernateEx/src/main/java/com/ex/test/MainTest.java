package com.ex.test;

import com.ex.beans.Instructor;
import com.ex.beans.Student;
import com.ex.dao.HibDAO;

public class MainTest {

	public static void main(String[] args) {
		HibDAO dao = new HibDAO();
//		Instructor inst = new Instructor();
//		inst.setName("Dr. Lory");
//		dao.addInstructor(inst);
//		dao.getAllInstructors();
//		
//		Student s = new Student();
//		s.setEmail("email");
//		s.setFirstname("Trevor");
//		s.setLastname("Lory");
//		Student st = dao.addStudent(s);
//		
//		Student s2 = new Student();
//		s2.setEmail("email2");
//		s2.setFirstname("Trevor2");
//		s2.setLastname("Lory2");
//		dao.addStudent(s2);
		//System.out.println(st.toString());
		
//		System.out.println(dao.getInstructorbyID(50).toString());
//		
//		List<Student> sts = dao.queryDemo("t%");
//		System.out.println(sts.size());
//		for(int i = 0; i < sts.size(); i++) {
//			System.out.println(sts.get(i).getEmail());
//		}
		
		dao.deleteStudentById(100);
	}
	
}

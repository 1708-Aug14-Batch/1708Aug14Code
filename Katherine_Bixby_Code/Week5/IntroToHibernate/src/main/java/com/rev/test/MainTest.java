package com.rev.test;

import com.rev.dao.HibDAO;

public class MainTest {

	public static void main(String[] args) {
		HibDAO dao = new HibDAO();
//		List<Instructor> theInstructors = dao.getAllInstructors();
//		for(Instructor i:theInstructors) {
//			System.out.println(i.toString());
//		}
		
//		List<Student> aaa = dao.criteriaDemo();
//		for(Student i:aaa) {
//			System.out.println(i.toString());
//		}
//		List<Student> uuu = dao.queryDemo("t%");
//		for(Student i:uuu) {
//			System.out.println(i.toString());
//		}
		
		dao.deleteStudentById(100);
		
	}
	
}

package com.ex.test;

import java.util.ArrayList;
import java.util.List;

import com.ex.beans.Instructor;
import com.ex.beans.Student;
import com.ex.dao.HibernateDao;

public class MainTest {

	public static void main(String[] args) {
		HibernateDao h = new HibernateDao();
		//Instructor i = new Instructor();
		
		ArrayList<Instructor> list = h.getAllInstructors();
		for(Instructor i : list) {
			System.out.println(i);
		}
		
		h.deleteStudent(100);
		
		List<Student> demo = h.queryDemo("test");
		for(Student s : demo) {
			System.out.println(s);
		}
		
		
		
		
	}

}

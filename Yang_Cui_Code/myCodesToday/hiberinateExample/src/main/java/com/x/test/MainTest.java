package com.x.test;

import com.x.bean.Student;
import com.x.dao.UibDAO;

public class MainTest {
	public static void main(String[] args){
		UibDAO dao=new UibDAO();
		Student s= new Student();
		s.setFn("Gen");
		s.setLn("Bonds");
		s.setEmail("genbont@revature.com");
		dao.addStudent(s);
	}
}

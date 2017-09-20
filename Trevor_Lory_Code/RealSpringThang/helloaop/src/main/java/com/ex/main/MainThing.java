package com.ex.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ex.beans.Students;

public class MainThing {

	public static void main(String[] args) {
		ApplicationContext con = new ClassPathXmlApplicationContext("beans.xml");
		Students s = (Students) con.getBean("students");
		s.cry();
		s.eat();
		s.exist();
		s.work();
	}
	
}

package com.ex.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ex.beans.Students;

public class Main {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		Students s = (Students) context.getBean("students");
		
		s.cry();
		s.eat();
		s.exist();
		s.work();
		s.takeTime();
	}
}

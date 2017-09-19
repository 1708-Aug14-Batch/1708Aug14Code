package com.revature.andy.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.andy.beans.Student;

public class MainTest {
	
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		Student s = (Student) context.getBean("student");
		s.cry();
		s.exist();
		s.eat();
		s.work();
		s.takeTime();
	}
}

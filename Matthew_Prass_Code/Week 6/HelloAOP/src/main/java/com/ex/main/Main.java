package com.ex.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ex.beans.Students;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
		Students s = (Students)ac.getBean("students");
		s.cry();
		s.eat();
		s.exist();
		s.work();

	}

}

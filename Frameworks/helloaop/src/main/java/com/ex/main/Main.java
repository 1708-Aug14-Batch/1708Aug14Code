package com.ex.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ex.beans.Students;

public class Main {
	

	public static void main(String[] args) {
		
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("beans.xml");
		
		Students students = (Students) context.getBean("students");
		
		
		students.cry();
		students.eat();
		
		for(int i = 0; i < 10; i ++){
			long time = (long) (Math.random()*1000);
			students.taketime(time);
		}
		
		
		
	}
	

}

package com.revature.andy.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.andy.beans.Employee;

public class MainTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		Employee e = (Employee) context.getBean("employee");
		e.setName("Andy");
		e.getDept().setName("Accounting");
		System.out.println(e.getName());
		System.out.println(e.getDept().getName());

	}
	
}

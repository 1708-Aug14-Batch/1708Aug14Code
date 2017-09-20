package com.ex.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ex.beans.Employee;

public class MainApp {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		Employee emp = (Employee) context.getBean("employee");
		System.out.println(emp.getName());
		System.out.println(emp.getDept().getName());
	}
}

package com.ex.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ex.beans.Employee;

public class MainTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		Employee employee = (Employee)context.getBean("employee");
		employee.setName("genesis");
		employee.getDepartment().setName("tech");
		System.out.println(employee.getName());
		System.out.println(employee.getDepartment().getName());
	}
	
}

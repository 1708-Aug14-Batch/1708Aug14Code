package com.ex.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ex.beans.Employee;

public class MainTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		Employee emp = (Employee)context.getBean("employee");
		emp.setName("Trevor");
		emp.getDepartment().setName("Tech");
		System.out.println(emp.getName());
		System.out.println(emp.getDepartment().getName());
	}

}

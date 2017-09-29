package com.ex.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ex.bean.Employee;

public class Main {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Employee emp = (Employee) context.getBean("employee");
		emp.setEmployeeName("Michael Scott");
		emp.getDepartment().setDepartmentName("Management");
		System.out.println(emp.getEmployeeName());
		System.out.println(emp.getDepartment().getDepartmentName());
	}

}

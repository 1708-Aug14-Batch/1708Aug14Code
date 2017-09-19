package com.ex.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ex.beans.HelloWorld;
import com.ex.beans.HiRevature;
import com.ex.newpackage.Employee;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
		Employee e = (Employee) ac.getBean("employee");
		e.setName("Matt");
		e.getDpt().setName("tech");
		System.out.println(e.getName());
		System.out.println(e.getDpt().getName());
		
	}
}

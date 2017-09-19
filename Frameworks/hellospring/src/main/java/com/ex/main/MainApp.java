package com.ex.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ex.beans.HiRevature;

public class MainApp {
	
	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("beans.xml");
		
//		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
//		obj.getMessage();
//		
//		obj.setMessage("Hello I am the first object");
//		obj.getMessage();
//		
//		HelloWorld obj2 = (HelloWorld) context.getBean("helloWorld");
//		obj2.getMessage();
		
		HiRevature hi = (HiRevature)context.getBean("revature");
		hi.getHelloMessage();
	}

}

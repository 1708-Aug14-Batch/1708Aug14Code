package com.revature.andy.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.andy.beans.HiRevature;

public class MainApp {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//
//		// method and constructor injection stuff
//		HelloWorld obj = (HelloWorld) context.getBean("HelloWorld");
//		
//		System.out.println(obj.getMessage());
//		obj.setMessage("Hello World 1");
//		System.out.println(obj.getMessage());
//		
//		
//		HelloWorld obj2 = (HelloWorld) context.getBean("HelloWorld");
//		
//		System.out.println(obj2.getMessage());
//		obj2.setMessage("Hello World 2");
//		System.out.println(obj2.getMessage());
		
		HiRevature hi = (HiRevature) context.getBean("revature");
		hi.getHelloMessage();
	}

}

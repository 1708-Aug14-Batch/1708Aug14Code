package com.ex.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ex.beans.HiRevature;

public class MainApp {
	/*
	 * Spring DI: Dependency Injection
	 * 
	 * Spring is going to hold our dependencies (our objects) 
	 * 	and inject them where need (apply new object())
	 * 
	 * What is needed for Spring to do DI?
	 * 	 Configure the spring container
	 * 		-by xml
	 * 		-by @s
	 * 		-This example will be using XML 
	 * 
	 * How instantiate a spring container?
	 * 		-beanFactory (old) the parent class, lazy loads beans
	 *		-applicationContext (new) the child class, eagerly loads beans
	 * 
	 */
	
	
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

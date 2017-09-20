package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.HelloWorld;
import beans.HiRevature;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		
//		HelloWorld obj = (HelloWorld) context.getBean("HelloWorld");
//		obj.getMessage();
//		
//		obj.setMessage("First obj");
//		obj.getMessage();
//		
//		HelloWorld obj2 = (HelloWorld) context.getBean("HelloWorld");
//		obj2.getMessage();
//		
		HiRevature hi = (HiRevature) context.getBean("hiRevature");
		hi.getHelloMessage();
	}
}

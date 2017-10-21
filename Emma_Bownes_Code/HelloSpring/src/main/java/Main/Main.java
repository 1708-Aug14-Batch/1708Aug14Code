package Main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Beans.HelloWorld;
import Beans.HiRev;
import aspect.beans.Student;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

				
				HelloWorld obj  = (HelloWorld) context.getBean("helloWorld");
				obj.getMessage();
				obj.setMessage("Hello I am the first object");
				obj.getMessage();
				
				HelloWorld obj2 = (HelloWorld) context.getBean("helloWorld");
				obj2.getMessage();

				HiRev hi = (HiRev)context.getBean("hiRev");
				hi.getHelloMessage();

//		Student s = (Student)context.getBean("student");
//
//		s.cry();
//		s.eat();
//		s.exist();
	}

}



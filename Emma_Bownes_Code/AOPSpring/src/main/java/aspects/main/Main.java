package aspects.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import aspect.beans.Student;

public class Main {

	
	public static void main(String[] args) {
		ApplicationContext cont = new ClassPathXmlApplicationContext("beans.xml");
		
		Student s = (Student)cont.getBean("student");

		s.cry();
		s.eat();
		s.exist();
		
	}
}

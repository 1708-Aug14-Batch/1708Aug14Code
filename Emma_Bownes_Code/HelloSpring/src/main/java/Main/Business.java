package Main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import better.beans.Dept;
import better.beans.Employee;

public class Business {
	
	public static void main(String[] args) {
		ApplicationContext cont = new ClassPathXmlApplicationContext("Beans.xml");
		
		Employee employee = (Employee)cont.getBean("employee");
		employee.setName("Genesis");
		
		
		Dept department = (Dept)cont.getBean("dept");
		department.setName("Tech Team");
		System.out.println(employee.getName());
		System.out.println(employee.getDept().getName());
		System.out.println(employee.getSalary());

		
		
	}

}

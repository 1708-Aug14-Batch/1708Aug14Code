package com.ex.day1hw1;

public class Main 
{

	public static void main(String[] args) 
	{
		//Demonstrating!
		Employee a = new Employee();
		Employee e = new Employee(1,false);
		Person p = new Employee(5,true);
		
		a.doAThing();
		e.doAThing();
		p.doAThing();
		
		a.move(1);
		e.move(12);
		p.move(2);
		System.out.println(a.getStep());
		System.out.println(e.getStep());
		//getStep() not defined for abstract class
		System.out.println(p.step);
		
		a.stop();
		e.stop();
		p.stop();
		System.out.println(a.getStep());
		System.out.println(e.getStep());
		//getStep() not defined for abstract class
		System.out.println(p.step);
	}
	

}

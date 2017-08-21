package com.ex.question7;

import java.util.Comparator;

//employee object to compare(with a comparator)
public class Employee implements Comparator<Employee> {
	
	private String name;
	private String dept;
	private int age;
	
	public Employee()
	{
		
	}
	
	
	public Employee(String name, String dept, int age) {
		super();
		this.name = name;
		this.dept = dept;
		this.age = age;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDept() {
		return dept;
	}


	public void setDept(String dept) {
		this.dept = dept;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}

	public String toString()
	{
		return name+ " " + dept+ " "+age;
	}
	
	//employee's own compare method that takes into account all it's variables
	@Override
	public int compare(Employee o1, Employee o2) {
		if(o1.getName().equals(o2.getName()))
			if(o1.getDept().equals(o2.getDept()))
				return o1.getAge() - o2.getAge();
			else
				return o1.getDept().compareTo(o2.getDept());
		else
			return o1.getName().compareTo(o2.getName());
	}
	
	
	
	

}

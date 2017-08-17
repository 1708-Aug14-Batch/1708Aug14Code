package com.revature.q07;

public class Employee {
	private int age;
	private String name, department;
	
	public Employee(String name, String department, int age) {
		this.name = name;
		this.department = department;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public int getAge() {
		return age;
	}
	
	@Override
	public String toString() {
		return name + " " + age + " " + department;
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Employee))
			return false;
		Employee e = (Employee) o;
		return this.age == e.age && this.name.equals(e.name) && this.department.equals(e.department);
	}
	
	public int hashCode() {
		return (this.age + this.department + this.age).hashCode();
	}
}

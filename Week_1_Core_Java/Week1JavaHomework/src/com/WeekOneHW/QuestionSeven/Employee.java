package com.WeekOneHW.QuestionSeven;



public class Employee {

	private String name;
	private String department;
	private int age;
	public Employee() {};
	public Employee(String name, String department, int age) {
		this.name = name;
		this.department = department;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int compare(Employee o1, Employee o2) {
		
		return 0;
	}
	
	
}

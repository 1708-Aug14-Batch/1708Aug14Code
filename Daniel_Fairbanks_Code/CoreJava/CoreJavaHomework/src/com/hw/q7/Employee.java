package com.hw.q7;
import java.util.Comparator;

public class Employee implements Comparator<Employee>, Comparable<Employee>{
	private String name;
	private String dpt;
	private int age;
	
	public Employee(String name, String dpt, int age) {
		super();
		this.name = name;
		this.dpt = dpt;
		this.age = age;
	}

	public String getName() {
		return name;
	}
	
	public String getDpt() {
		return dpt;
	}
	
	public int getAge() {
		return age;
	}

	public int compareTo(Employee e) {
		return this.name.compareTo(e.name);
	}

	public int compare(Employee e1, Employee e2) {
		return e1.age - e2.age;
	}
	
}

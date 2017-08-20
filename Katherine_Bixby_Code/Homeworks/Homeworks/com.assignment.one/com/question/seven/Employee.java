package com.question.seven;

import java.util.Comparator;

/**
 * Employee class for an employee object that has a name, department, and age.
 * Also contains comparators for comparing by each of these 3 aspects.
 * 
 * @author Katie
 * 
 */
public class Employee{
	
	private String name;
	private String department;
	private int age;
	
	
	
	public Employee(String name, String department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}
	
	public Employee() {}
	
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
	
	
	public static Comparator<Employee> NameComparator = new Comparator<Employee>() {
		@Override
		public int compare(Employee e1, Employee e2) {
			return e1.getName().compareTo(e2.getName());
		}
	};
	
	public static Comparator<Employee> AgeComparator = new Comparator<Employee>() {
		@Override
		public int compare(Employee e1, Employee e2) {
			return e1.getAge() - e2.getAge();
		}
	};
	
	public static Comparator<Employee> DepartmentComparator = new Comparator<Employee>() {
		@Override
		public int compare(Employee e1, Employee e2) {
			return e1.getDepartment().compareTo(e2.getDepartment());
		}
	};
	
	// For printing out the employees nicely
	@Override
    public String toString() {
        return "{Employee: name: " + this.name + ", department: " + this.department + ", age: " +
                this.age + "}";
    }

	

}

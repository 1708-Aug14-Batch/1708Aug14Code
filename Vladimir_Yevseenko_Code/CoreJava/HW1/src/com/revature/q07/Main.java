package com.revature.q07;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Employee[] employees = new Employee[5];
		
		employees[0] = new Employee("Vlad", "Trainee", 21);
		employees[1] = new Employee("Bob", "Sales", 35);
		employees[2] = new Employee("Jane", "Trainer", 24);
		employees[3] = new Employee("Jon", "HR", 28);
		employees[4] = new Employee("Jill", "HR", 25);
		
		System.out.println("Original order:");
		for (Employee e: employees)
			System.out.println(e);
		System.out.println();
		
		System.out.println("Sorted by name:");
		Arrays.sort(employees, new EmployeeNameComparator());
		for (Employee e: employees)
			System.out.println(e);
		System.out.println();
		
		System.out.println("Sorted by department:");
		Arrays.sort(employees, new EmployeeDepartmentComparator());
		for (Employee e: employees)
			System.out.println(e);
		System.out.println();
		
		System.out.println("Sorted by age:");
		Arrays.sort(employees, new EmployeeAgeComparator());
		for (Employee e: employees)
			System.out.println(e);
		System.out.println();
	}
	
	
}
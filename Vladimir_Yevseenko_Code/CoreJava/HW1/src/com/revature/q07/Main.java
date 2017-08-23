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
		/*
		 * The 2 function calls below are equal
		 * The 2nd uses Lambda to implement a Comparator on the spot
		 */
		Arrays.sort(employees, new EmployeeNameComparator());
		Arrays.sort(employees, (e1, e2) -> e1.getName().compareTo(e2.getName()));
		
		for (Employee e: employees)
			System.out.println(e);
		System.out.println();
		
		System.out.println("Sorted by department:");
		/*
		 * The 2 function calls below are equal
		 * The 2nd uses Lambda to implement a Comparator on the spot
		 */
		Arrays.sort(employees, new EmployeeDepartmentComparator());
		Arrays.sort(employees, (e1, e2) -> e1.getDepartment().compareTo(e2.getDepartment()));
		for (Employee e: employees)
			System.out.println(e);
		System.out.println();
		
		System.out.println("Sorted by age:");
		/*
		 * The 2 function calls below are equal
		 * The 2nd uses Lambda to implement a Comparator on the spot
		 */
		Arrays.sort(employees, new EmployeeAgeComparator());
		Arrays.sort(employees, (e1, e2) -> ((Integer)e1.getAge()).compareTo(e2.getAge()));
		for (Employee e: employees)
			System.out.println(e);
		System.out.println();
	}
}

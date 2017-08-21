package com.ex.Q7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Q7 {
	
	public static void main(String[] args) {
			
			List<Employee> listEmployees = new ArrayList<Employee>();
			 
			listEmployees.add(new Employee("Tom", 45, "HR"));
			listEmployees.add(new Employee("Sam", 56, "IT"));
			 
			System.out.println("Before sorting: " + listEmployees);
			 
			Collections.sort(listEmployees);
			 
			System.out.println("After sorting: " + listEmployees);

	}
}

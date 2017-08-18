package com.ex.questionSeven;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee employee1 = new Employee("Jack","Art", 40);
		Employee employee2 = new Employee("April","Math", 25);
		
		ArrayList<Employee> myList = new ArrayList<Employee>();
		
		myList.add(employee1);
		myList.add(employee2);
		
		System.out.println("Sort By Name: ");
		Collections.sort(myList, new Name());
		for(Employee employee : myList)
			System.out.println(employee);
		System.out.println("Sort by Department");
		Collections.sort(myList, new Department());
		for(Employee employee : myList)
			System.out.println(employee);
		System.out.println("Sort by Age");
		Collections.sort(myList, new Age());
		for(Employee employee : myList)
			System.out.println(employee);
		
		
	}
	

}
//public class Department implements Comparator<Employee>
//{
//
//	@Override
//	public int compare(Employee emp1, Employee emp2) 
//	{
//		return emp1.getDepartment().compareTo( emp2.getDepartment() );
//	}
//
//}

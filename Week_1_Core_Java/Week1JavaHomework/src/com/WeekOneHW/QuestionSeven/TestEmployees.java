package com.WeekOneHW.QuestionSeven;

import java.util.ArrayList; //Importing the util for the ArrayList
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class TestEmployees extends Employee implements Comparator<Employee>  {

	public static void main(String[] args) {

		/*
		 * This program creates two employees, joe and buck, for comparison by implementing the Comperator.
		 * Using seperate comparator classes and feeding into the collections.sort() function, the Employees should be properly sorted for outout.
		 */
		Employee joe = new Employee("Joe Buck", "HR", 35);
		Employee matt = new Employee("Matt Barnes", "Marketing", 21);
		ArrayList<Employee> list = new ArrayList<Employee>();
		
		list.add(joe);
		list.add(matt);
		
		Collections.sort(list, new NameComparator());
		Iterator itr = list.iterator();
		while(itr.hasNext()) {
			Employee em = (Employee) itr.next();
			System.out.println(em.getName() + " " + em.getDepartment() + " " + em.getAge() + " ");
		}
		Collections.sort(list, new DepartmentComparator());
		while(itr.hasNext()) {
			Employee em = (Employee) itr.next();
			System.out.println(em.getName() + " " + em.getDepartment() + " " + em.getAge() + " ");
		}
		Collections.sort(list, new AgeComparator());
		while(itr.hasNext()) {
			Employee em = (Employee) itr.next();
			System.out.println(em.getName() + " " + em.getDepartment() + " " + em.getAge() + " ");
		}
		
	}
	



}

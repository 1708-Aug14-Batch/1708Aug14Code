package com.hw.q7;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Q7 {

	public static void main(String[] args) {
		
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("Bob Smith", "Operations", 25));
		employees.add(new Employee("Alice Wonder", "Cyber Security", 28));
		
		System.out.println("Sorted by name:");
		Collections.sort(employees, new NameCompare());
		Iterator<Employee> iter1 = employees.iterator();
		while ( iter1.hasNext())
		{
			Employee e = (Employee)iter1.next();
			System.out.println(e.getName() + " : " + e.getAge() + " : " + e.getDpt());
		}
		
		System.out.println("\nSorted by age:");
		Collections.sort(employees, new AgeCompare());
		Iterator<Employee> iter2 = employees.iterator();
		while ( iter2.hasNext())
		{
			Employee e = (Employee)iter2.next();
			System.out.println(e.getName() + " : " + e.getAge() + " : " + e.getDpt());
		}
		
		System.out.println("\nSorted by department:");
		Collections.sort(employees, new DptCompare());
		Iterator<Employee> iter3 = employees.iterator();
		while ( iter3.hasNext())
		{
			Employee e = (Employee)iter3.next();
			System.out.println(e.getName() + " : " + e.getAge() + " : " + e.getDpt());
		}
	}

}

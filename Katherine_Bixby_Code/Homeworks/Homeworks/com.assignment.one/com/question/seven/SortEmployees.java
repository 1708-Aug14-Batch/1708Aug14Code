package com.question.seven;

import java.util.Arrays;

/**
 * Sorts two employees based on their name, department, and age using the Comparator interface.
 * @author Katie
 */
public class SortEmployees {
	
	static Employee e1 = new Employee("Bill","Accounting",32);
	static Employee e2 = new Employee("Barbra","Sales",28);
	
	static Employee[] theEmployees = {e1,e2};
	
	
	public void sortThem() {
		System.out.println("If we sort "+e1.getName()+" and "+e2.getName()+" by name, we find that the order is: ");
		Arrays.sort(theEmployees,Employee.NameComparator);
		System.out.println(Arrays.toString(theEmployees));
		System.out.println("If we sort "+e1.getName()+" and "+e2.getName()+" by department, we find that the order is: ");
		Arrays.sort(theEmployees,Employee.DepartmentComparator);
		System.out.println(Arrays.toString(theEmployees));
		System.out.println("If we sort "+e1.getName()+" and "+e2.getName()+" by age, we find that the order is: ");
		Arrays.sort(theEmployees,Employee.AgeComparator);
		System.out.println(Arrays.toString(theEmployees));
		
		
	}

}

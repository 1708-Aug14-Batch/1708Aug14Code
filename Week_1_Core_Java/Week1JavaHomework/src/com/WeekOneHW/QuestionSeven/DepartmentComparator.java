package com.WeekOneHW.QuestionSeven;

import java.util.Comparator;

public class DepartmentComparator implements Comparator {
	//Implements the Comparator and overrides the compare function for comparing Departments of the Employees. The return value is how its properly sorted.
	@Override
	public int compare(Object o1, Object o2) {
		Employee e1 = (Employee)  o1;
		Employee e2 = (Employee) o2;
		return e1.getDepartment().compareTo(e2.getDepartment());
	}

}

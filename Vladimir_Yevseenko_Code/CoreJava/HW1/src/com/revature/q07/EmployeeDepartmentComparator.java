package com.revature.q07;

import java.util.Comparator;

public class EmployeeDepartmentComparator implements Comparator<Employee> {
	public int compare(Employee e1, Employee e2) {
		return e1.getDepartment().compareTo(e2.getDepartment());
	}
}
package com.hw.week01.q07;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee anEmployee, Employee anotherEmployee) {
		int nameComparison = anEmployee.getName().charAt(0) - anotherEmployee.getName().charAt(0);
		if (nameComparison != 0) {
			return nameComparison;
		}
		int departmentComparison = anEmployee.getDepartment().charAt(0) - anotherEmployee.getDepartment().charAt(0);
		if (departmentComparison != 0) {
			return departmentComparison;
		}
		int ageComparison = anEmployee.getAge() - anotherEmployee.getAge();
		if (ageComparison != 0) {
			return ageComparison;
		}
		return 0;
	}

}

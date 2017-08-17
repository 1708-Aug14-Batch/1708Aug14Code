package com.revature.q07;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Tests {

	@Test
	public void ageComparatorTest() {
		Employee[] sorted = new Employee[3];
		
		sorted[0] = new Employee("Vladimir", "Constructor", 2);
		sorted[1] = new Employee("Xavier", "Destructor", 65);
		sorted[2] = new Employee("Zachary", "Memory allocator", 99);
		
		Employee[] toSort = new Employee[3];
		toSort[0] = new Employee("Xavier", "Destructor", 65);
		toSort[1] = new Employee("Zachary", "Memory allocator", 99);
		toSort[2] = new Employee("Vladimir", "Constructor", 2);
		
		Arrays.sort(toSort, new EmployeeAgeComparator());
		assertArrayEquals(sorted, toSort);
	}
	
	@Test
	public void nameComparatorTest() {
		Employee[] sorted = new Employee[3];
		
		sorted[0] = new Employee("Vladimir", "Constructor", 2);
		sorted[1] = new Employee("Xavier", "Destructor", 65);
		sorted[2] = new Employee("Zachary", "Memory allocator", 99);
		
		Employee[] toSort = new Employee[3];
		toSort[0] = new Employee("Xavier", "Destructor", 65);
		toSort[1] = new Employee("Zachary", "Memory allocator", 99);
		toSort[2] = new Employee("Vladimir", "Constructor", 2);
		
		Arrays.sort(toSort, new EmployeeNameComparator());
		assertArrayEquals(sorted, toSort);
	}
	
	@Test
	public void departmentComparatorTest() {
		Employee[] sorted = new Employee[3];
		
		sorted[0] = new Employee("Vladimir", "Constructor", 2);
		sorted[1] = new Employee("Xavier", "Destructor", 65);
		sorted[2] = new Employee("Zachary", "Memory allocator", 99);
		
		Employee[] toSort = new Employee[3];
		toSort[0] = new Employee("Xavier", "Destructor", 65);
		toSort[1] = new Employee("Zachary", "Memory allocator", 99);
		toSort[2] = new Employee("Vladimir", "Constructor", 2);
		
		Arrays.sort(toSort, new EmployeeDepartmentComparator());
		assertArrayEquals(sorted, toSort);
	}

}

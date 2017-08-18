package Q7;

import java.util.*;
import java.lang.*;
import java.io.*;

class Employee {
	// Sort two employees based on their name, department, and age using the
	// Comparator interface
	String name;
	String dept;
	int age = 29;

	public Employee(String name, String dept, int age) {
		super();
		this.name = name;
		this.dept = dept;
		this.age = age;
	}

	// Used to print student details in main()
	public String toString() {
		return this.name + " " + this.dept + " " + this.age;
	}
}

class SortByName implements Comparator<Employee> {
	// Used for sorting in ascending order of
	// employee name
	public int compare(Employee a, Employee b) {
		return a.name.compareTo(b.name);
	}
}

class SortByDept implements Comparator<Employee> {
	// Used for sorting in ascending order of
	// department name
	public int compare(Employee a, Employee b) {
		return a.dept.compareTo(b.dept);
	}
}

class SortByAge implements Comparator<Employee> {
	// Used for sorting in ascending order of
	// department name
	public int compare(Employee a, Employee b) {
		return a.age - b.age;
	}
}

// Driver class
class Main {
	public static void main(String[] args) {
		ArrayList<Employee> list = new ArrayList<Employee>();
		list.add(new Employee("Allan", "Development", 29));
		list.add(new Employee("Alika", "Quality Control", 28));
		list.add(new Employee("Aleena", "Human Resources", 43));

		System.out.println("Unsorted");
		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));

		Collections.sort(list, new SortByName());

		System.out.println("\nSorted by Employee Name");
		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));

		Collections.sort(list, new SortByDept());

		System.out.println("\nSorted by Dept Name");
		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));

		Collections.sort(list, new SortByAge());

		System.out.println("\nSorted by Age");
		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));
	}
}
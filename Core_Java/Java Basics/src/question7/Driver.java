package question7;

import java.util.ArrayList;
import java.util.Collections;

/*
 * Q7. Sort two employees based on their name, department, and
 * age using the Comparator interface.
 */

public class Driver {
	
	public static void main(String[] args) {
		
		ArrayList<Employee> empList = new ArrayList<Employee>();
		
		// Add a bunch of similar employees to the array
		empList.add(new Employee("John Doe", Department.TRAINING, 30));
		empList.add(new Employee("Joe Smith", Department.HUMAN_RESOURCES, 40));
		empList.add(new Employee("Joe Smith", Department.HUMAN_RESOURCES, 42));
		empList.add(new Employee("Joe Smith", Department.HUMAN_RESOURCES, 52));
		empList.add(new Employee("Joe Smith", Department.HUMAN_RESOURCES, 41));
		empList.add(new Employee("Joe Smith", Department.HUMAN_RESOURCES, 39));
		empList.add(new Employee("Joe Smith", Department.HUMAN_RESOURCES, 60));
		empList.add(new Employee("Alice Smith", Department.HUMAN_RESOURCES, 42));
		empList.add(new Employee("Zany Smith", Department.HUMAN_RESOURCES, 42));
		empList.add(new Employee("Andrew Smith", Department.HUMAN_RESOURCES, 42));
		empList.add(new Employee("Walker Smith", Department.HUMAN_RESOURCES, 42));
		
		Collections.sort(empList);
		
		for (Employee emp : empList)
			System.out.println(emp);
	}

}

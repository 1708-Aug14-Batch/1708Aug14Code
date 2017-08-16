package Q7;

import java.util.ArrayList;
import java.util.List;

public class EmployeeCompareTest {

	public static void main(String[] args) {
		
		//create employees
		Employee e1 = new Employee("Gary Hood", "Sales", 25);
		Employee e2 = new Employee("MacKenzie Lou", "Secretary", 26);
		Employee e3 = new Employee("Steve Leighton", "Programming",27);
		Employee e4 = new Employee("Steve Leighton", "Programming",22);
		Employee e5 = new Employee("Josh Audibert", "Programming", 23);
		Employee e6 = new Employee("Tyler Dubay", "Programming", 23);
		Employee e7 = new Employee("Cara Bean", "Intern", 18);
		
		//add them to list
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(e3);
		employees.add(e2);
		employees.add(e5);
		employees.add(e1);
		employees.add(e7);
		employees.add(e6);
		employees.add(e4);
		
		//print unsorted
		System.out.println("Unsorted:");
		print(employees);
		System.out.println("-----------------");
		//sort based on department, print result
		employees.sort(new EmployeeDepartmentComparator());
		System.out.println("Sort on department");
		print(employees);
		System.out.println("-----------------");
		
		//sort based on name, print result
		employees.sort(new EmployeeNameComparator());
		System.out.println("Sort on name:");
		print(employees);
		System.out.println("-----------------");
		
		//sort based on age, print result
		employees.sort(new EmployeeAgeComparator());
		System.out.println("Sort on age");
		print(employees);
		System.out.println("-----------------");
		
		
	}
	
	public static void print(List<Employee> emps){
		for(Employee e : emps){
			System.out.println(e.getDepartment() + " | " 
							+ e.getName() + " | " 
							+ e.getAge());
		}
	}

}

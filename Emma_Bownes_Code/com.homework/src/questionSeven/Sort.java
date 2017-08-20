package questionSeven;

import java.util.ArrayList;
import java.util.Comparator;

public class Sort {

	public static void main(String[] args) {
		ArrayList<Employee> list = new ArrayList<Employee>();
		//creates an arrayList of employees to test sorting
		list.add(new Employee("Roger", "Sales", 37));
		list.add(new Employee("Roger", "Sales", 31));
		list.add(new Employee("Roger", "Sales", 29));
		list.add(new Employee("Mary", "Sales", 37));
		list.add(new Employee("Mary", "HR", 37));
		list.add(new Employee("Betty", "Sales", 37));
		list.add(new Employee("Roger", "HR", 50));
		
		//sort list
		list.sort(c);
		
		//prints out employees with information to test sorting
		for(Employee e: list ) {
			System.out.println(e.name+" "+e.department+" "+e.age);
		}
	}
	//utilizes lambda to create a comparator c to compare employees
	static Comparator<Employee> c = (Employee o1, Employee o2) -> {
		int compare =0;
		compare = (o1.name).compareTo(o2.name);
		if(compare==0) {
			compare = (o1.department).compareTo(o2.department);
			if(compare==0) {
				compare = o1.age - o2.age;
			}
		}
		return compare;
	};
	
	
}

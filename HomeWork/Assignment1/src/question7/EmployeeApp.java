package question7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeApp {
	 public static void main(String[] args) {
		 List<Employee> e = new ArrayList<Employee>();
		 EmployeeSort sort = new EmployeeSort();
		 	e.add(new Employee("Sally", "Administration", 22));
	        e.add(new Employee("John", "Finance", 59));
			
			sort.compare(e.get(0),e.get(1));
			System.out.println(e);
			Collections.sort(e, sort);
			System.out.println(e);
	        System.out.println(sort.compare(e.get(0),e.get(1)));
	    }
}


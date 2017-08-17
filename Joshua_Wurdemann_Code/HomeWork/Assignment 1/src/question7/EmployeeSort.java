package question7;

import java.util.Comparator;

public class EmployeeSort {

	    static final Comparator<Employee> Sorted_Name = 
	                                        new Comparator<Employee>() {
	            public int compare(Employee e1, Employee e2) {
	                return e2.getMyName().compareTo(e1.getMyName());
	            }
	    };
}

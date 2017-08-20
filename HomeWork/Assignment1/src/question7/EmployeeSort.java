package question7;

import java.util.Comparator;

public class EmployeeSort implements Comparator<Employee>{

	@Override
	public int compare(Employee e1, Employee e2) {
		if(e1.getMyName().compareToIgnoreCase(e2.getMyName())== 0){
			if(e1.getMyDepartment().compareToIgnoreCase(e2.getMyDepartment())== 0){
				return e1.getMyAge() - e2.getMyAge();
			} else { return e1.getMyDepartment().compareToIgnoreCase(e2.getMyDepartment());
		}
		}
			return e1.getMyName().compareToIgnoreCase(e2.getMyName());
		
	}

}
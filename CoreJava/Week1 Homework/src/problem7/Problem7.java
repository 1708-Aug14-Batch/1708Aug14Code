package problem7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Problem7 {
	//Q7. Sort two employees based on their name, department, 
	//and age using the Comparator interface.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		Employee a = new Employee("Andrew","Lewis","Food",23);
		Employee b = new Employee("Don","Bird","Accounting",53);
		Employee c = new Employee("Jamie","Herman","Software",32);
		Employee d = new Employee("Alex","Smith","HR",213);
		
		ArrayList<Employee> listEmployee = new ArrayList<>();
		
		listEmployee.add(a);
		listEmployee.add(b);
		listEmployee.add(c);
		listEmployee.add(d);
		
		System.out.println("Sort by Last Name");
		
		Collections.sort(listEmployee, new sortName());
		
		for(Employee x: listEmployee) {
			System.out.println(x.toString());
		}

		System.out.println("Sort by Dept");
		
		Collections.sort(listEmployee, new sortDept());
		
		for(Employee x: listEmployee) {
			System.out.println(x.toString());
		}

		System.out.println("Sort by Age");
		
		Collections.sort(listEmployee, new sortAge());
		
		for(Employee x: listEmployee) {
			System.out.println(x.toString());
		}
		
		
	}

}

class sortName implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return o1.getLname().compareTo(o2.getLname());
	}
	
}

class sortDept implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return o1.getDept().compareTo(o2.getDept());
	}
	
}

class sortAge implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return o1.getAge() - o2.getAge();
	}
	
}
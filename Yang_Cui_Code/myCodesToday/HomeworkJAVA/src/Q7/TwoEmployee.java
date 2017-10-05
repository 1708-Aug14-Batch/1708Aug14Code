package Q7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TwoEmployee {
	public static void main(String[] args){
		new TwoEmployee();
	}
	
	public TwoEmployee(){
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("aaa","bbb",12));
		employees.add(new Employee("aaa","aaa",13));
		Collections.sort(employees);
		
		System.out.println(employees.get(0).getName()+" "+employees.get(0).getDepartment()+" "+employees.get(0).getAge());
		System.out.println(employees.get(1).getName()+" "+employees.get(1).getDepartment()+" "+employees.get(1).getAge());
	}
}

package com.ex.question7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompareEmployees {

	public static void main(String[] args) {
		
		List<Employee> list = new ArrayList<Employee>();
		
		Employee e1 = new Employee("albert","sales",34);
		Employee e2 = new Employee("amanda","IT",23);
		
		//Employee e1 = new Employee("albert","sales",34);
		//Employee e2 = new Employee("albert","IT",23);
		
		//Employee e1 = new Employee("albert","IT",34);
		//Employee e2 = new Employee("albert","IT",23);
		
		list.add(e1);
		list.add(e2);
		
		Collections.sort(list,new Employee());
		
		for(Employee e:list)
			System.out.println(e);
	}
	

}

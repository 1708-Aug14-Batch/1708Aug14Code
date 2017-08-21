package com.ex.question7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompareEmployees {

	public static void main(String[] args) {
		
		//add employees to a list
		List<Employee> list = new ArrayList<Employee>();
		
		Employee e1 = new Employee("albert","sales",34);
		Employee e2 = new Employee("amanda","IT",23);
		
		//Employee e1 = new Employee("albert","sales",34);
		//Employee e2 = new Employee("albert","IT",23);
		
		//Employee e1 = new Employee("albert","IT",34);
		//Employee e2 = new Employee("albert","IT",23);
		
		list.add(e1);
		list.add(e2);
		
		//sort them(automatically uses my own compare method)
		Collections.sort(list,new Employee());
		
		//print at sorting
		for(Employee e:list)
			System.out.println(e);
	}
	

}

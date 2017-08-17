package com.hw.q7;

import java.util.Comparator;

public class AgeCompare implements Comparator<Employee>{
	
	public int compare(Employee o1, Employee o2) {
		
		if (o1.getAge() == o2.getAge())
			return 0;
		
		else if (o1.getAge() < o2.getAge())
			return -1;
		
		else return 1;
	}

}

package com.hw.q7;

import java.util.Comparator;

public class DptCompare implements Comparator<Employee>{

	public int compare(Employee o1, Employee o2) {
		
		return o1.getDpt().compareTo(o2.getDpt());
	}

}

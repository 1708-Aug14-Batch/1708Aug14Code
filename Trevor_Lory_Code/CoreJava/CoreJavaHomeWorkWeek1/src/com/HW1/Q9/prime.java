package com.HW1.Q9;

import java.util.ArrayList;

public class prime {

	public static void main(String[] args) {
		ArrayList<Integer> pr = new ArrayList<Integer>();
		for(int i = 1; i <= 100; i++) {
			pr.add(i);
		}
		for(Integer num : pr) {
			boolean NotPrime = false;
			if(num.intValue() == 2) {
				System.out.println(num.intValue());
				continue;
			}
			if(num.intValue()%2 == 0) {
				continue;
			}
			for(int i = 3; i * i <= num.intValue(); i += 2) {
				if(num.intValue()%i == 0) {
					NotPrime = true;
					break;
				}
			}
			if(NotPrime) {
				continue;
			}
			System.out.println(num.intValue());
		}
	}
	
}

package com.HW1.Q4;

public class Factorial {

	public int Fac(int amount) {
		int sum = 1;
		for(int i = amount; i > 0; i--) {
			sum *= i;
		}
		System.out.println(sum);
		return sum;
	}
	
}

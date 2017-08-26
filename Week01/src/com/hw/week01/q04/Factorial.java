package com.hw.week01.q04;

public class Factorial {
	
	public static int factorial(int n) {
		int[] numbersToMultiply = new int[n];
		for(int i = 0; i < numbersToMultiply.length; i++) {
			numbersToMultiply[i] = n - i;
		}
		int factorial = 1;
		for(int j = 0; j < numbersToMultiply.length; j++) {
			factorial *= numbersToMultiply[j];
		}
		return factorial;
	}

}

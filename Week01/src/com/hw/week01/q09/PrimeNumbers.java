package com.hw.week01.q09;

import java.util.ArrayList;

public class PrimeNumbers {
	
	public static ArrayList<Integer> returnPrimeNumbers(ArrayList<Integer> numbers) {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for(int currentNumber : numbers) {
			int numberOfDivisors = 0;
			for(int i = 1; i < numbers.size(); i++) {
				if (currentNumber % i == 0) {
					numberOfDivisors++;
				}
			}
			if (numberOfDivisors == 2) {
				primes.add(currentNumber);
			}
		}
		return primes;
	}

}

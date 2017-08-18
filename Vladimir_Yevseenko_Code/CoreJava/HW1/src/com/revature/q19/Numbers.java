package com.revature.q19;

import java.util.stream.IntStream;

public class Numbers {
	public static void main(String[] args) {
		/*
		 * Finding sum of all even and odd numbers using streams
		 * Simply more interesting than using ArrayList and doing it manually
		 */	
		System.out.println("Even sum: " + 
				IntStream.range(1, 11).filter(i -> isEven(i)).sum());
		
		System.out.println("Odd sum: " + 
				IntStream.range(1, 11).filter(i -> !isEven(i)).sum());
		
		System.out.print("Only non-prime numbers: ");
		IntStream
			.range(1, 11)
			.filter(i -> isPrime(i))
			.forEach(i -> System.out.print(i + " "));
		System.out.println();
	}
	
	public static boolean isEven(int i) {
		return i % 2 == 0;
	}
	
	public static boolean isPrime(int n) {
		if (n == 1 || n == 0)
			return false;
		for (int i=2; i*i <= n; i++)
			if (n % i == 0)
				return false;
		return true;
	}
}
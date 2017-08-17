package com.revature.q04;

import java.util.Scanner;

public class Factorial {
	public static void main(String[] args) {
		int n = 5;
		try (Scanner s = new Scanner(System.in)) {
			System.out.print("Enter a number: ");
			n = Integer.parseInt(s.nextLine());
		} catch (NumberFormatException ex) {
			System.out.println("You did not enter a number.");
			System.exit(1);
		}
		
		System.out.println(n + "! via smart factorial: " +
				smartFactorial(n));
		System.out.println(n + "! via naive factorial: " +
				naiveFactorial(n));
	}
	
	public static long smartFactorial(int n) throws IllegalArgumentException {
		if (n < 0)
			throw new IllegalArgumentException("n must be non negative");
		
		long res = 1;
		for (int i=1; i<=n; i++)
			res *= i;
		return res;
	}
	
	public static long naiveFactorial(int n) throws IllegalArgumentException {
		if (n < 0)
			throw new IllegalArgumentException("n must be non negative");
		
		if (n == 0)
			return 1;
		
		return naiveFactorial(n-1) * n;
	}
}
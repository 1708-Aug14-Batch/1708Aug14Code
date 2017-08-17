package com.revature.q02;

import java.util.Scanner;

public class Fibonacci {
	public static void main(String[] args) {
		int n = 5;
		try (Scanner s = new Scanner(System.in)) {
			System.out.print("Enter a number: ");
			n = Integer.parseInt(s.nextLine());
		} catch (NumberFormatException ex) {
			System.out.println("You did not enter a number.");
			System.exit(1);
		}
		
		System.out.println(n + "th Fibonacci number via smart fibonacci: " +
				smartFibonacci(n));
		System.out.println(n + "th Fibonacci number via recursive fibonacci (may take a while): " +
				naiveFibonacci(n));
		
	}
	
	/*
	 * Recursive fibonacci, may never finish for decently large n
	 */
	public static long naiveFibonacci(int n) throws IllegalArgumentException {
		if (n < 0)
			throw new IllegalArgumentException("n must be non negative");
		else if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		else
			return naiveFibonacci(n-1) + naiveFibonacci(n-2);
	}
	
	/*
	 * Smart O(n) time fibonacci
	 */
	public static long smartFibonacci(int n) {
		if (n < 0)
			throw new IllegalArgumentException("n must be nonnegative");
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		long n0 = 0, n1 = 1, n2 = 1;
		for (int i=2; i<=n; i++) {
			n2 = n0 + n1;
			n0 = n1;
			n1 = n2;
		}
		return n2;
	}
}
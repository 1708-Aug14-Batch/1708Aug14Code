package com.revature.q06;

import java.util.Scanner;

public class IsEven {
	public static void main(String[] args) {
		System.out.print("Enter a number: ");
		int n = 5;
		try (Scanner s = new Scanner(System.in)) {
			n = Integer.parseInt(s.nextLine());
		} catch (NumberFormatException ex) {
			System.out.println("You didn't enter a number");
			System.exit(1);
		}
		System.out.println(n + " is " + (isEven(n) ? "even" : "odd"));
	}
	
	/*
	 * check the lowest bit in n to see if it is even
	 * lowest bit is clear if it is positive and even
	 * lowest bit is set if it is negative and even
	 */
	public static boolean isEven(int n) {
		return (n & 1) == 0;
	}
}

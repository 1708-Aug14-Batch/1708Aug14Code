package com.revature.q13;

import java.util.Scanner;

public class Triangle {
	public static void main(String[] args) {
		int n = 5;
		try (Scanner s = new Scanner(System.in)) {
			System.out.print("How large the triangle should be: ");
			n = Integer.parseInt(s.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("You didn't enter a number.");
			System.exit(1);
		}
		printTriangle(n);
	}
	
	/*
	 *  n = levels of the triangle
	 */
	public static void printTriangle(int n) throws IllegalArgumentException {
		if (n <= 0)
			throw new IllegalArgumentException();
		char c = '0';
		for (int i=0; i<n; i++) {
			c = (char) (i % 2 + '0');
			for (int j=0; j<=i; j++) {
				System.out.print(c + " ");
				c = (c == '0' ? '1' : '0');
			}
			System.out.println();
		}
	}
}

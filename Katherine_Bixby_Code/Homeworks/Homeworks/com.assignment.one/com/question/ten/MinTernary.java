package com.question.ten;

import java.util.Scanner;

/**
 * Find the minimum of two numbers using ternary operators.
 * 
 * @author Katie
 */

public class MinTernary {

	public int minTernary(Scanner scan) {
		
		int a,b,c;
		
		System.out.println("Enter the two numbers you'd like to find the minimum value from.");
		System.out.println("Please remember to enter one then press enter, then do the same for the other: ");
		a = scan.nextInt();
		b = scan.nextInt();
		c = (a < b) ? a : b;
		System.out.println("The minimum of these two numbers is: "+c);
		
		return 0;
	}
	
}

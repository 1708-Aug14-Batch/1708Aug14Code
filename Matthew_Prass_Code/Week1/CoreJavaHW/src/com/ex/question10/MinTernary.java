package com.ex.question10;

import java.util.Scanner;

public class MinTernary {

	public static void main(String[] args) {
		
		//user input
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter first number: ");
		int a = s.nextInt();
		
		System.out.println("Enter second number: ");
		int b = s.nextInt();
		
		//figure out the smallest of the two numbers without using if statement
		int minVal = a<b ? a : b;
		
		System.out.println("The minimum of the two is: " + minVal);
		
		s.close();
	}

}

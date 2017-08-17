package com.ex.question10;

import java.util.Scanner;

public class MinTernary {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter first number: ");
		int a = s.nextInt();
		
		System.out.println("Enter second number: ");
		int b = s.nextInt();
		
		int minVal = a<b ? a : b;
		
		System.out.println("The minimum of the two is: " + minVal);
		
		s.close();
	}

}

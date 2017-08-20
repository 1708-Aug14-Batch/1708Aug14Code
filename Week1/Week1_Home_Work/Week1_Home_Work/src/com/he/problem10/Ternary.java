package com.he.problem10;

import java.util.Scanner;

public class Ternary {

	static Scanner scan;
	public static void main(String[] args) {
		int a,b = 0;
		scan = new Scanner(System.in);
		System.out.println("Enter the first number:");
		a = scan.nextInt();
		System.out.println("Enter the second number:");
		b = scan.nextInt();
		System.out.println("the min of: " + a + " and " + b + " is " + min(a,b));
		

	}
	static int min(int a, int b){
		return a < b? a : b;
	}
}

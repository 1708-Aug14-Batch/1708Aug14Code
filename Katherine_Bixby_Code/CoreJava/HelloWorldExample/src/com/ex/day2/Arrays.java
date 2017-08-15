package com.ex.day2;

import java.util.Scanner;

public class Arrays {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		int[][] a = new int[2][3];
		int[] b = new int[] {1,2,3};
		a[0] = b;
		b[0] = 5;
		
		// enhanced for loop or "for each"
		for(int i : a[0]) {
			System.out.println(i);
		}
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter a number: ");
		int input = scan.nextInt();
		if(input%2==0) {
			System.out.println("Your number "+input+" is even!");
			if(input%5==0) {
				System.out.println("It is also divisible by five!");
			}
		}
		else {
			System.out.println("Your number "+input+" is odd!");
			if(input%5==0) {
				System.out.println("It is also divisible by five!");
			}
		}
		
		/*
		 * Switch Statements
		 * 		> Numbers must be exact, can't be ranges like with if statements
		 * 		>> need breaks to tell switches to chill and stop after a case
		 */
		switch(input) {
		case(10): System.out.println("It's 10");
		break;
		case(100): System.out.println("100");
		break;
		default:
			System.out.println("default");
		}
		
		int[] x = new int[10];
		for (int i:x) {
			System.out.println("A: "+i);
			if(i==3) {continue;}
			System.out.println("B: "+i);
			if(i==4) {break;}
		}
		
		while(input>10) {
			System.out.println(input);
			--input;
			input--;
		}
		do {
			System.out.println("Do things "+input);
			input--;
		} while(input>3);
	}
	
}

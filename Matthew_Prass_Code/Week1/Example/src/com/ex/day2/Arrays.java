package com.ex.day2;

import java.util.Scanner;

public class Arrays {
	
	public static void main(String args[])
	{
		int[] x = {1,2,3,4,5};
		int[][] twoD = {{13,4,5,},{123,6,8}};
		int[][] a = new int[4][5];
		a[0][1] = 4;
		int b[][] = new int[1][1];
		
		for(int i = 0; i <x.length; i++) {
			System.out.println(x[i]);
		}
		
		for(int i:x) {
			System.out.println("A " + i);
			if(i == 3) continue;
			System.out.println("B " + i);
		}
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Please enter a number : ");
		int input = s.nextInt();
		
		if(input%2 == 0 && input %5 == 0) {
			System.out.println("Your number, " + input + " ,is even and divisible by 5!");
		}
		else
			System.out.println("Your number, " + input + " ,is odd!");
		
		switch(input) {
		case 10: System.out.println("is 10");
		break;
		case 100: System.out.println("is 100");
		break;
		default:
			System.out.println("default");
		}
		
		while(input > 10) {
			System.out.println(input);
			input--;
		}
		
		do {
			System.out.println("Do things " + input);
			input--;
		}
		while(input > 1);
		
		s.close();
	}
}

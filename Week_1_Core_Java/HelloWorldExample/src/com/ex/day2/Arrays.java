package com.ex.day2;

import java.util.Scanner;


public class Arrays {
	int num = 0;
	public static void main(String[] args) {
		//Ways to initialize arrays
		int[] x = {1,2,3,4,5};
		int[][] twoD = {{13,4,5, }, {123,6,8}};
		int[][] a = new int[4][5];
		int b[][] = new int[1][1];
		
		//Regular for loop
		for(int i  = 0; i < x.length; i++) { // Block/Loop scope
			System.out.println(x[i]);
		}
		
		//Enhanced for loop
		for(int i:x) {
			System.out.println("A: " + i);
			if(i==3) continue; //Continue is used to move on to the next iteration of the loop. In this instance B: 3 is skipped
			System.out.println("B: " + i);
			if(i==4) break; //Break ends the loop
		}
		//Scanner object used to receive input
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter a number: ");
		int y = input.nextInt();
		boolean check = true;
		
		
		//if-statements
		if(y%2 == 0 && y%5 == 0) {
			System.out.printf("%s%d","This is even", y);
		}
		else if(y%5 == 0)
			System.out.println("Divisible by 5");
		//else
		else
			System.out.printf("%s%d", "This is odd ", y);

		//switch statements
		switch(y) {
		case(10): System.out.println("its 10");
		break; //You need a break to end the switch case
		case(100): System.out.println("100");
		break;
		default: System.out.println("default"); //Default is the base if its nothing else
			break;
		}
		//while
		while(y>10) {
			System.out.println(y);
			y--;
			
		}
		//do while
		do {
			System.out.println("do things " + y);
			y--;
		}
		while(y > 1);
		
	}

}

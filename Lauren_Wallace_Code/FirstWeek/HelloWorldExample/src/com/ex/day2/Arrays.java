package com.ex.day2;

import java.util.Scanner;

public class Arrays {
	
	static int num = 0;
	
	public static void main(String[] args) {
		
		int[] x = {1,2,3,4,5};
		int[][] two = {{13,4,5},{23,6,8}};
		int[][] a = new int[4][5];
		int b[][] = new int[1][1];
		a[0][1] = 4;
		
		for(int i =0; i < x.length; i++) {
			System.out.println(x[i]);
		}
		
		//enhanced for loop
		for(int i:x) {
			System.out.println("A: " + i);
			if(i == 3) continue;
			System.out.println("B: " + i);
		}
		
		Scanner scan = new Scanner(System.in); //can also do Scanner(in)
		System.out.println("Please enter a number");
		int input = scan.nextInt();
		boolean check = true;
		
		//if statement
		if(input%2 == 0 && input%5 == 0) { //check == false
			System.out.println("Your number " + input + " is even and divisible by 5!");
		}
		//else if
		else if(input%5 == 0) {
			System.out.println("divisible by 5");
		}
		//else
		else {
			System.out.println("Your number " + input + " is odd!");
		}
		
		//switch statemtents
		switch(input) {
		case 10: System.out.println("it's 10"); //or case (10)
		         break;
		case 100: System.out.println("it's 100");
		          break;
		default: System.out.println("default");
		}
		
		//while 
		while (input > 10) {
			System.out.println(input);
			--input;
			System.out.println(input);
			input--;
			System.out.println("--");
		}
		
		//do while
		do {
			System.out.println("do things " + input);
			input--;
		}while(input > 1);
	}

}

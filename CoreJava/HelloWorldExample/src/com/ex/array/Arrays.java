package com.ex.array;

import java.util.Scanner;

public class Arrays {

	public static void main(String[] args) {
		
		int x [] = {1,2,3,4,5};
		
		int [][] two = {{1,1},{2,2}};
		int dos [][] = {{1,1},{2,2}};
		
		for(int i:x) {
			System.out.println("for each " + i);
		}
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter data");
		
		int input = scan.nextInt();
		
		if(input % 2 == 0) {
			System.out.println("number is even " + input);
		}
		else if(input % 5 == 0) {
			System.out.println("div by 5");
		}
		else {
			System.out.println("number " + input +" is odd");
		}
		
		switch(input) {
		case(10): System.out.println("num 10");
		break;
		case(20): System.out.println("num 20");
		break;
		default: System.out.println("num 0");
		}
		
		
		
	}
	
}

package com.ex.arrays;

import java.util.Scanner;

public class Arrays {

	public static void main(String[] args) {
		
		int[] x = {1,2,3,4,5};
		int[][] twoD = {{1,2,3},{4,5},{5}};
		
		int[][] a = new int[4][5];
		int b[][] = new int[1][1];
		
		for(int i= 0; i < x.length; i++){
			System.out.println(x[i]);
		}
		
		//for every value in x, loop through them using i
		for(int i : x){
			System.out.println("for each:" + i);
		}

		//get input from console using scanner
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter number: ");
		
		//take line of input
		int input = scan.nextInt();
		
		//check for even number
		if(input%2 == 0){
			System.out.println("your number " + input + " is even");
		}
		else if(input%5 == 0){
			System.out.println("your number is divisible by 5");
		}
		else{
			System.out.println("your number " + input + " is odd");
		}
		
		switch(input){
			case(10): System.out.println("it's 10");
						break;
			case(100):	System.out.println("it's 100");
						break;
			default:  System.out.println("default");	
		}
	}

}

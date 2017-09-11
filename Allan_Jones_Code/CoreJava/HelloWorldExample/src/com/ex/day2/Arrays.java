package com.ex.day2;

import java.util.Scanner;

public class Arrays {

static int num = 0;
	public static void main(String[] args) {

		int[] x = {1, 2, 3, 4, 5};
		int[][] twoD = {{13,4,5,},{123,6,8}};

		int[][] a = new int[4][5];
		int b[][] = new int[1][1];

		//for loop
		for(int i = 0; i < x.length; i++){ //block/loop scope
			System.out.println(x[i]);
		}
		
System.out.println("enhanced for");
		//enhanced for loop or "for each"
		for(int i:x){
			for(int j = 0; j < 3; j++){
				if(j==2) break; // breaks out of current loop not one holding the nested loop
				System.out.println(i + " " + j);
			}
			
			System.out.println("B: " + i);
			if(i==4) continue;
		}

		Scanner scan = new Scanner(System.in);

		System.out.println("please enter a number");
		int input =  scan.nextInt();
		boolean check = true;


		//if-statements
		if(input%2 == 0 && input%5==0){

			System.out.println("your number " + input + " is even!" );

		}

		else if(input%5 == 0){
			System.out.println("divisible by 5");
		}

		//else
		else{
			System.out.println("your number " + input + " is odd");
		}


		//switch statements
		switch(input){
		case(10): System.out.println("its 10");
	
		case(100): System.out.println("100");
		break;
		default:
			System.out.println("default");
		}

		//while
		while(input>10){
			System.out.println(input);
			input--;
//			System.out.println(input);
//			input--;
//			System.out.println("--");
		}
		
		//do while
		
		do{
			System.out.println("do things " + input );
			input--;
		}
		while(input>3);


	}

}

package com.ex.array;

import java.util.Scanner;

public class Arrays {
	
	public static void main(String[] args){
		
	
	int[][] a = new int[2][3];
	int[] b = new int[]{1,2,3};
	a[0] = b;
	b[0] = 5;
	for(int i : a[0]){
		System.out.println(i);
	}
		
		/*Scanner scan = new Scanner(System.in);
				
		System.out.println("please enter a number");
		
		int input = scan.nextInt();
		if(input%2==0){
		
			System.out.println(input + " This is an even number");
		}
		else if(input%5==0){
			System.out.println("This is divisible by five");
		}
		
		
		//switch and case statements
		switch(input){
		case(10): System.out.println("its 10");
		break;
		case(100): System.out.println("100");
		break;
		default:
			System.out.println("Not 10 or 100");
	}
		*/
		//control statements
		int[] x = new int[10];
		for(int i:x){
			System.out.println("A: "+i);
			if(i==3) continue;
			System.out.println("B: "+i);
			if(i==4) break;
			
			
		}
		
		for (int i=0;i<x.length; i++){
			System.out.println(i++);
		}
		
		//do while
		int y = 7;
		do{
			System.out.println("Do Things " + y);
			y--;
		}
		while(y>1);
		
		
	}
}

package com.ex.Q6;

import java.util.Scanner;

public class Q6 {
	public static void main(String[] args) {
		 	int number;
		    Scanner scn= new Scanner(System.in);
		 
		    System.out.println("Enter a number to check even or odd");
		    number = scn.nextInt();
		 
		    if((number / 2)*2==number){
		        System.out.println(+number+" is Even number");
		    }else{
		        System.out.println(+number+" is Odd Number");
		    }
	}
	
}

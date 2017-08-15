package com.ex.question4;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		
		int result = 1;
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter Number: ");
		int input = Integer.parseInt(s.nextLine());
		
		for(int i = 1; i <= input; i++)
		{
			result *= i;
		}
		System.out.println(result);
	
		//System.out.println(result);
		
		s.close();

	}

}

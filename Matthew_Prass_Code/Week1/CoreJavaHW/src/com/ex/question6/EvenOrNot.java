package com.ex.question6;

import java.util.Scanner;

public class EvenOrNot {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Please enter a number: ");
		int num  = s.nextInt();
		
		int x = Integer.remainderUnsigned(num, 2);
		if(x == 0)
			System.out.println("Even!");
		else
			System.out.println("Odd!");
		
		s.close();
	}

}

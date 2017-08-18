package com.question.seventeen;

import java.util.Scanner;

public class Interest {

	public double getInterest() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Please enter your principal dollar amount: $");
		double principal = scan.nextDouble();
		System.out.print("\nPlease enter your interest rate: ");
		double rate = scan.nextDouble();
		System.out.println("\nPlease enter duration of time in days: ");
		int time = scan.nextInt();
		double interest = principal*rate*time;
		return interest;
	}
	
}

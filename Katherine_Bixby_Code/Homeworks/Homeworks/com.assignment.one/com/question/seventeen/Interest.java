package com.question.seventeen;

import java.util.Scanner;

/**
 * A program that calculates the simple interest on the principal,
 * rate of interest, and number of years provided by the user.
 * Enter principal, rate and time through the console using the Scanner class.
 * 		Interest = Principal* Rate* Time
 * 
 * @author Katie
 */
public class Interest {

	public double getInterest(Scanner scan) {
		System.out.print("Please enter your principal dollar amount: $");
		double principal = scan.nextDouble();
		System.out.print("\nPlease enter your interest rate: ");
		double rate = scan.nextDouble();
		System.out.println("\nPlease enter duration of time in years: ");
		int time = scan.nextInt();
		double interest = principal*rate*time;
		scan.close();
		return interest;
	}
	
}

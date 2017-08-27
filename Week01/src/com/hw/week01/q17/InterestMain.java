package com.hw.week01.q17;

import java.util.Scanner;

public class InterestMain {
	
	public static void main(String[] args) {
		System.out.println("Interest Calcualtor");
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter principle >");
		double principle = Double.parseDouble(scanner.nextLine());
		System.out.print("Enter interest rate >");
		double rate = Double.parseDouble(scanner.nextLine());
		System.out.print("Enter time in years >");
		double time = Double.parseDouble(scanner.nextLine());
		System.out.println("Your interest is " + InterestCalculator.calculate(principle, rate, time));
		scanner.close();
	}

}

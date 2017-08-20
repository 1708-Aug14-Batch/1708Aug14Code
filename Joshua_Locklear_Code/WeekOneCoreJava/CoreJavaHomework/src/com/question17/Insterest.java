package com.question17;

import java.util.Scanner;

public class Insterest {
	static Scanner input;
	
	public static void main(String[] args) {
		input = new Scanner(System.in);
		System.out.println("Welcome to the interest Calculator");
		System.out.println("Please enter your Principle");
		double userPrinc = input.nextDouble();
		System.out.println("Please enter your Rate");
		double userRate = input.nextDouble();
		System.out.println("Please enter your Time in number of years");
		double userTime = input.nextDouble();
		
		userRate = userRate/100;
		
		double interest = userPrinc * userRate * userTime;
		
		System.out.print(interest);
	}
}

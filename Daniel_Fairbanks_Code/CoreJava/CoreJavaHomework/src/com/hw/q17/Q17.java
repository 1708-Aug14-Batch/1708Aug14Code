package com.hw.q17;

import java.util.Scanner;

public class Q17 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		double principal;
		double rate;
		int time;
		
		System.out.println("Please enter the principal amount.");
		while (true) {
			try {
				String line = scanner.nextLine();
				principal = Double.parseDouble(line);
				break;
			} catch (Exception e) {
				System.out.println("User must enter a number. Please try again...");
			}
		}
		System.out.println("Please enter the interest rate.");
		while (true) {
			try {
				String line = scanner.nextLine();
				rate = Double.parseDouble(line);
				break;
			} catch (Exception e) {
				System.out.println("User must enter a number. Please try again...");
			}
		}
		System.out.println("Please enter the time on the loan.");
		while (true) {
			try {
				String line = scanner.nextLine();
				time = Integer.parseInt(line);
				break;
			} catch (Exception e) {
				System.out.println("User must enter a number. Please try again...");
			}
		}
		scanner.close();
		double interest = principal * rate * time;
		System.out.println("The interest is: "+interest);
	}

}

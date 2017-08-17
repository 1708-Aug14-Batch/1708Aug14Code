package com.revature.q17;

import java.util.Scanner;

public class Interest {
	public static void main(String[] args) {
		float principle, rate, time;
		principle = rate = time = 0;
		try (Scanner s = new Scanner(System.in)) {
			System.out.print("Enter principle: ");
			principle = Float.parseFloat(s.nextLine());
			System.out.print("Enter rate: ");
			rate = Float.parseFloat(s.nextLine());
			System.out.print("Enter time: ");
			time = Float.parseFloat(s.nextLine());
		} catch (NumberFormatException ex) {
			System.out.println("Invalid input");
			System.exit(1);
		}
		System.out.println("Your interest is: " + principle * rate * time);
	}
}

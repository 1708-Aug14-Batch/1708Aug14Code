package com.revature.q14;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Switch {
	public static void main(String[] args) {
		int choice = 1;
		Scanner s = new Scanner(System.in);
		try {
			System.out.print("Enter a choice (1, 2, 3): ");
			choice = Integer.parseInt(s.nextLine());
		} catch (NumberFormatException ex) {
			System.out.println("You did not enter a number.");
			System.exit(1);
		}
		
		switch (choice) {
		case 1: sqrtCase(); break;
		case 2: displayDate(); break;
		case 3: stringSplitCase();
		}
		
		s.close();
	}
	
	public static void sqrtCase() {
		float val = 0;
		try (Scanner s = new Scanner(System.in)) {
			System.out.print("Enter a number to sqrt: ");
			val = Float.parseFloat(s.nextLine());
		} catch (NumberFormatException ex) {
			System.out.println("That is not a number...");
			System.exit(1);
		}
		System.out.println("sqrt(" + val + ") = " + Math.sqrt(val));
	}
	
	public static void displayDate() {
		System.out.println(new SimpleDateFormat("EEEEEEEEE, MMMMMMMMM d, yyyy").format(new Date()));
	}
	
	public static void stringSplitCase() {
		System.out.println("'I am learning core java' split: ");
		for (String str: "I am learning core java".split(" "))
			System.out.println(str);
	}
}

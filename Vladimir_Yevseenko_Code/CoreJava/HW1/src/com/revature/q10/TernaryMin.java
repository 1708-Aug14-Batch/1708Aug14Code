package com.revature.q10;
import java.util.Scanner;

public class TernaryMin {

	public static void main(String[] args) {
		int a = 0, b = 0;
		try (Scanner s = new Scanner(System.in)){
			System.out.print("Enter the 1st number: ");
			a = Integer.parseInt(s.nextLine());
			System.out.print("Enter the 2nd number: ");
			b = Integer.parseInt(s.nextLine());
		} catch (NumberFormatException ex) {
			System.out.println("You didn't enter a number");
			System.exit(1);
		}
		System.out.println("The minimum of " + a + " and " + b 
				+ " is " + min(a, b));
	}

	public static int min(int a, int b) {
		return a < b ? a : b;
	}
}

package Q17;

import java.util.Scanner;

public class SimpleInterest {
	// Write a program that calculates the simple interest on the principal, 
	// rate of interest and number of years provided by the user. 
	// Enter principal, rate and time through the console using the Scanner class.
	//        Interest = Principal* Rate* Time

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("please enter the pricipal");
		int principal = scan.nextInt();
		System.out.println("please enter the rate");
		int rate = scan.nextInt();
		System.out.println("please enter the no. of years");
		int yrs = scan.nextInt();
		
		calcInterest(principal, rate, yrs);
	}

	public static void calcInterest(int p, int r, int yrs) {
		double rate = r * 0.01;
		double interest = p * rate * yrs;
		System.out.println();
		System.out.println("The calculated Simple Interest is: " + interest);
	}
}

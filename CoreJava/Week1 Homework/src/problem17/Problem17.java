package problem17;

import java.util.Scanner;

public class Problem17 {
	//Q17. Write a program that calculates the simple interest on the principal, 
	//rate of interest and number of years provided by the user. 
	//Enter principal, rate and time through the console using the Scanner class.
	//Interest = Principal* Rate* Time

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// User input
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter Principal");
		
		double principal = scan.nextInt();
		
		System.out.println("Enter Rate");

		double rate = scan.nextInt();
		
		System.out.println("Enter Time");
		
		double time = scan.nextInt();
		
		// passes vars to interest method
		
		System.out.println("Interest is: " + interest(principal,rate,time));
	}
	
	public static double interest(double principle, double rate, double time) {
		
		return principle*rate*time;
	}

}

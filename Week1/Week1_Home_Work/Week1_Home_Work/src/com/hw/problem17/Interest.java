package com.hw.problem17;

import java.util.Scanner;

public class Interest {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		double principle = 0, rate = 0, time = 0;
		
		System.out.print("Enter principle: ");
		principle = scan.nextDouble();
		System.out.print("Enter rate: ");
		rate = scan.nextDouble();
		System.out.print("Enter time: ");
		time = scan.nextDouble();

		System.out.println("Your interest is: " + principle * rate * time);
		

	}

}

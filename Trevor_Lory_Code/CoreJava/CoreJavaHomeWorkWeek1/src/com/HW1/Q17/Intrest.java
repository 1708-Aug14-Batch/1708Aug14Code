package com.HW1.Q17;

import java.util.Scanner;

public class Intrest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double Principal, Rate, Time = 0;
		System.out.println("Principal: ");
		Principal = Double.parseDouble(scan.nextLine());
		System.out.println("Rate: ");
		Rate = Double.parseDouble(scan.nextLine());
		System.out.println("Time: ");
		Time = Double.parseDouble(scan.nextLine());
		System.out.println("Interest: ");
		System.out.println(Principal * Rate * Time);
		scan.close();
	}
	
}

package com.ex.question17;

import java.util.Scanner;

public class ConsoleInput {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter principal: ");
		double p = s.nextDouble();
		
		System.out.println("Enter rate: ");
		double r = s.nextDouble();
		
		System.out.println("Enter time: ");
		int t = s.nextInt();
		
		System.out.println(p*r*t);
		

	}

}

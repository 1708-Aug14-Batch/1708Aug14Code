package com.hw.problem18;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		StringChecker check = new StringChecker();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter a string: ");
		
		String str = scan.nextLine();
		
		System.out.println(check.hasUpperCase(str));
		System.out.println(check.ToUpperCase(str));
		check.printIntToString(str);
		
		

	}

}

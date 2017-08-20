package com.hw.problem5;

import java.util.Scanner;

public class Substring {

	public static void main(String[] args) {
		
		int idx = 0;
		String str = null;
		
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("Enter some text: ");
			str = scan.nextLine();
			System.out.print("Enter an index: ");
			idx = scan.nextInt();
		} catch (NumberFormatException e) {
			System.out.println("You didn't enter a number");
			
		}
		System.out.println("Substring: " + subString(str, idx));
	}
	
	public static String subString(String s, int idx) {
		
		return new String(s.toCharArray(), 0, idx);
	}

}

package com.revature.q05;

import java.util.Scanner;

public class Substring {
	
	public static void main(String[] args) {
		int idx = 0;
		String str = null;
		try (Scanner s = new Scanner(System.in)) {
			System.out.println("Enter some text: ");
			str = s.nextLine();
			System.out.print("Enter an index: ");
			idx = Integer.parseInt(s.next());
		} catch (NumberFormatException ex) {
			System.out.println("You didn't enter a number");
			System.exit(1);
		}
		System.out.println("Substring: " + subString(str, idx));
	}
	
	public static String subString(String s, int idx) {
		return new String(s.toCharArray(), 0, idx);
	}
}

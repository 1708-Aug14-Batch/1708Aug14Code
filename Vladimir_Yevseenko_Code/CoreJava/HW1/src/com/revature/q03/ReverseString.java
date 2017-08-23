package com.revature.q03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ReverseString {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter a string to be reversed: ");
		String str = s.nextLine();
		s.close();
		System.out.println("Reversed: " + reverseString(str));
		System.out.println("Recursively reversed: " +
				reverseStringRec(str));
	}
	
	/*
	 *  reverses a string by interchanging the low and high characters
	 *  from the beginning to the end of the string
	 *  the substring calls are required because the 
	 */
	public static String reverseString(String s) {
		for (int low = 0, high = s.length() - 1; low < high; low++, high--)
			s = s.substring(0, low) + s.charAt(high) + s.substring(low+1, high) + 
					s.charAt(low) + s.substring(high+1);
		return s;
	}
	
	/*
	 * Recursive implementation of String reverse
	 */
	public static String reverseStringRec(String s) {
		if (s.length() == 0 || s.length() == 1)
			return s;
		return s.charAt(s.length() - 1) +
				reverseStringRec(s.substring(1, s.length() - 1)) +
				s.charAt(0);
	}
}

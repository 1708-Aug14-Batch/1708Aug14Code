package com.hw.problem8;

import java.util.ArrayList;

public class Palindrome {

	private static String[] inputStrings = {"karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john", "refer", "billy", "did"};

	public static void main(String[] args) {

		// 1. Stroe all of the strings in an ArrayList
		ArrayList<String> strings = new ArrayList<String>();

		for (String str : inputStrings)
			strings.add(str);

		// 2. Store all the palindromes in another ArrayList
		ArrayList<String> palindromes = new ArrayList<String>();
		for (String str : inputStrings)
			if (isPalindrome(str))
				palindromes.add(str);

		// Print results
		System.out.println("Palindrome strings: ");
		for(String str : palindromes)
			System.out.println(str);

	}
	private static boolean isPalindrome(String str) {

		for (int i = 0; i < str.length()/2; i++)
			if (str.charAt(i) != str.charAt(str.length()-i-1))
				return false;

		return true;


	}

}

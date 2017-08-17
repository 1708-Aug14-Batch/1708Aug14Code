package com.revature.q08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Palindromes {
	public static void main(String[] args) {
		String[] words = {"karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john",  "refer", "billy", "did"};
		List<String> list = Arrays.asList(words);
		ArrayList<String> palindromes = onlyPalindromes(list);
		ArrayList<String> palindromesRec = onlyPalindromesRec(list);

		
		System.out.println("Original list:");
		for (String s: list)
			System.out.print(s + " ");
		
		System.out.println("\n\nPalindromes only:");
		for (String s: palindromes)
			System.out.print(s + " ");
		
		System.out.println("\n\nPalindromes only using recursion:");
		for (String s: palindromesRec)
			System.out.print(s + " ");
	}
	
	public static ArrayList<String> onlyPalindromes(List<String> list) {
		ArrayList<String> res = new ArrayList<>();
		for (String str: list)
			if (isPalindrome(str))
				res.add(str);
		return res;
	}
	
	public static ArrayList<String> onlyPalindromesRec(List<String> list) {
		ArrayList<String> res = new ArrayList<>();
		for (String str: list)
			if (isPalindromeRec(str))
				res.add(str);
		return res;
	}
	
	public static boolean isPalindrome(String s) {
		for (int low = 0, high = s.length() - 1; low < high; low++, high--)
			if (s.charAt(low) != s.charAt(high))
				return false;
		return true;
	}
	
	/*
	 * Recursive version
	 */
	public static boolean isPalindromeRec(String s) {
		if (s.length() == 0 || s.length() == 1)
			return true;
		return s.charAt(0) == s.charAt(s.length() - 1) && isPalindromeRec(s.substring(1, s.length() - 1));
	}
}

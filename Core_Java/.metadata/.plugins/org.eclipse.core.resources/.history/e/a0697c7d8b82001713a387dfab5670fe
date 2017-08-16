package com.ex.day3;

public class Recursion {
	
	public static void main(String[] args) {
		System.out.println(reverse("taco cat"));
	}
	
	public int factorial(int n) {
		if (n == 0 || n == 1) return 1;
		else if (n < 0) return 0;
		
		return (n * factorial(n-1));
	}
	
	public static String reverse(String str) {
		if (str.length() == 0 || str.length() == 1) return str;
		
		return str.charAt(str.length()-1) + 
				reverse(str.substring(1, str.length()-1)) +
				str.charAt(0);
	}

}

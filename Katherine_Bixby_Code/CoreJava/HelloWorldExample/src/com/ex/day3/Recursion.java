package com.ex.day3;

public class Recursion {

	public static void main(String[] args) {
		//System.out.println(factorial(4));
		System.out.println(reverse("String"));
	}
	
	public int factorial(int n) {
		if(n==1) {
			return 1;
		}
		else {
			return n*factorial(n-1);
		}
	}
	
	public int fibonacci(int n) {
		if(n==0) {
			return 0;
		}
		else if(n==1) {
			return 1;
		}
		else {
			return fibonacci(n-1)+fibonacci(n-2);
		}
	}
	
	
	public int addArgs(int...nums) {
		int sum = 0;
		for (int i:nums) {
			sum +=i;
		}
		return sum;
	}
	
	public static String reverse(String str) {
		if(str.length()==0||str.length()==1) return str;
		return str.charAt(str.length()-1) +
			reverse(str.substring(1, str.length()-1))
			+ str.charAt(0);
		
	}
	
}

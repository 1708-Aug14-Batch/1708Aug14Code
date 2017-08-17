package com.day3;

public class Recursion {
	public static void main(String[] args) {
		System.out.println(reverse("cat"));
		
	}
	public int factorial(int n) {
		if(n==0) {
			return 1;
		}
		else {
			return n*factorial(n-1);
		}
	}
	
	public int fibonacci(int n){
		if(n == 2) {
			return 1;
		}
		else {
			int fib = fibonacci(n-1)+fibonacci(n);
			System.out.println(fib); 
			return fib;
		}
	}
	
	public int addArgs(int... nums) {
		int sum = 0;
		for (int i:nums) {
			sum+=i;
		}
		return sum;
	}
	
	public static String reverse(String str) {
		if(str.length()==0 || str.length() == 1) return str;
		
		String temp = str.charAt(str.length()-1) + 
				reverse(str.substring(1, str.length()-1))
						+ str.charAt(0);
		return temp;
	}
}

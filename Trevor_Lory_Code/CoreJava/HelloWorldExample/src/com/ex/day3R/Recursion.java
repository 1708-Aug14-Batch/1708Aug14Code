package com.ex.day3R;

public class Recursion {

	public static void main(String[] args) {
//		int i = factorial(42);
//		System.out.println(i);
	}
	
	public int factorial(int n) {
		if (n == 1) {
			return 1;
		}
		int x = factorial(n - 1);
		return x * n;
	}
	
	public int addArgs(int... nums) {
		int sum = 0;
		for(int i : nums) {
			sum += i;
		}
		return sum;
	}
	
	public String reverse(String str) {
		if(str.length() == 0 || str.length() == 1) {
			return str;
		}
		return str.charAt(str.length() - 1) + reverse(str.substring(1, str.length()-1)) + str.charAt(0);
	}
	
}

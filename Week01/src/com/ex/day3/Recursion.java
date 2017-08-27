package com.ex.day3;

public class Recursion {

	public static void main(String[] args) {
		//System.out.println(factorial(5));
	}
	
	public int factorial(int n) {
		if (n == 1) {
			return 1;
		}
		return n * factorial(n-1);
	}

}

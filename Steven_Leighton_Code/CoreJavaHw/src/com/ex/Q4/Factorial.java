package com.ex.Q4;

public class Factorial {

	public static void main(String[] args) {
		for(int i = 0; i < 10; i++) System.out.println(i + "! = " + factorial(i));
	}

	/*
	 * recursively multiply every number up to n
	 * base case <= 1
	 */
	
	static int factorial(int n){
		if(n <= 1) return 1;
		return n*factorial(n-1);
	}
}

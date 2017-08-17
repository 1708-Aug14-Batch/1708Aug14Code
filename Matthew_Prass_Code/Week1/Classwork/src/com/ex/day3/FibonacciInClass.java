package com.ex.day3;

public class FibonacciInClass {

		
	public static void main(String[] args) {
		
		System.out.println(fib(25));
	}
	
	public static long fib(int n)
	{
		if(n <= 1)
			return n;
		return fib(n-1) + fib(n-2);
	}
}

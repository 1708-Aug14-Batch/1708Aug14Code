package com.hw.problem2;

public class Fibonacci {

	public static void main(String[] args) {
		
		int[] fib = new int[25];
		fib[0] = 0;
		fib[1] = 1;
		System.out.println("The first 25 Fibonacci number are:");
		System.out.println("F0" + " = " + fib[0]);
		System.out.println("F1" + " = " + fib[1]);
		for(int i = 2; i < fib.length; i++){
			fib[i] = fib[i-1] + fib[i-2];
			System.out.println("F" + i + " = " + fib[i]);
		}
		
		

	}

}

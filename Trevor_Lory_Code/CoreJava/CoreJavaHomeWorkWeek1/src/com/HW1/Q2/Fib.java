package com.HW1.Q2;

public class Fib {

	public int[] Fib(int amount) {
		int[] arr = new int[amount];
		int sum = 0;
		for(int i = 0; i < amount; i++) {
			sum += i;
			System.out.print(sum + ", ");
			arr[i] = sum;
		}
		return arr;
	}
	
}

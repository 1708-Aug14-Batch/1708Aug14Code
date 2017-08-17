package com.revature.q19;

import java.util.ArrayList;

public class Numbers {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i=1; i<=10; i++)
			list.add(i);
		
		int evenSum, oddSum;
		evenSum = oddSum = 0;
		for (int i: list) {
			if (isEven(i))
				evenSum += i;
			else
				oddSum += i;
		}
		System.out.println("Odd sum: " + oddSum);
		System.out.println("Even sum: " + evenSum);
		
		for (int i=1; i<=10; i++)
			if (isPrime(i))
				list.remove((Object) i);
		
		System.out.println("Only non-prime numbers: " + list);
	}
	
	public static boolean isEven(int i) {
		return i % 2 == 0;
	}
	
	public static boolean isPrime(int n) {
		if (n == 1 || n == 0)
			return false;
		for (int i=2; i*i <= n; i++)
			if (n % i == 0)
				return false;
		return true;
	}
}
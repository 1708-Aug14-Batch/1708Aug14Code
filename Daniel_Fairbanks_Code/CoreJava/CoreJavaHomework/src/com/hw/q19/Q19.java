package com.hw.q19;

import java.util.ArrayList;

public class Q19 {

	public static boolean is_prime(int n)
	{
		if (n <= 1)
			return false;
		for (int i = 2; i < (int)Math.sqrt(n)+1; i++)
		{
			if (n % i == 0)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		int oddSum = 0;
		int evnSum = 0;
		for (int i = 1; i <= 10; i++)
		{
			numbers.add(i);
			System.out.println(i);
			if (i % 2 == 0)
				evnSum+=i;
			else
				oddSum+=i;
		}
		System.out.println("Sum of Even numbers: " + evnSum);
		System.out.println("Sum of Odd numbers:  " + oddSum);
		
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for (int n : numbers)
		{
			if (is_prime(n))
				primes.add(n);
		}
		numbers.removeAll(primes);
		for (int n : numbers)
			System.out.println(n);
	}

}

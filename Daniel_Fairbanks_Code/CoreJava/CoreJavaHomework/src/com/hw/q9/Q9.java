package com.hw.q9;
import java.util.ArrayList;

public class Q9 {

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
		ArrayList<Integer> primes = new ArrayList<Integer>();
		
		for (int i = 1; i <= 100; i++)
		{
			numbers.add(i);
			if (is_prime(i))
			{
				primes.add(i);
				System.out.println(i);
			}
		}
	}

}

package com.ex.question9;

import java.util.ArrayList;

public class PrimeNums {

	public static void main(String[] args) {
		
		//arraylist of ints
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		//add in numbers 1-100
		for(int i =1; i<101; i++)
		{
			nums.add(i);
		}
		
		
		//going through arraylist and printing out the prime numbers 1-100
		for(int i : nums)
		{
			if(i == 1)
				continue;
			if(i == 2)
				System.out.println(i);
			else {
				if(isPrime(i))
				System.out.println(i);
			}
		}

	}
	
	//method to see if number is prime or not
	static boolean isPrime(int n)
	{
		//check if n is a multiple of 2
	    if (n%2==0) return false;
	    //if not, then just check the odds
	    for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}

}

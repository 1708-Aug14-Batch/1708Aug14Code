package com.ex.question19;

import java.util.ArrayList;

public class VariousArrayList {
	
	public static void main(String[] args) {
		
		//arraylist of ints
		ArrayList<Integer> ints = new ArrayList<Integer>();
		
		ints.add(1);
		ints.add(2);
		ints.add(3);
		ints.add(4);
		ints.add(5);
		ints.add(6);
		ints.add(7);
		ints.add(8);
		ints.add(9);
		ints.add(10);
		
		//display
		display(ints);
		
		//add all even nums
		System.out.println(addEvens(ints));
		
		//add all odd nums
		System.out.println(addOdds(ints));
		
		//remove prime nums
		removePrimes(ints);
		display(ints);
		
	}
	//display array
	static void display(ArrayList<Integer> ints)
	{
		for(int i: ints)
			System.out.println(i);	
	}
	//add all the even numbers in arraylist
	static int addEvens(ArrayList<Integer> ints)
	{
		int result = 0;
		for(int i:ints)
		{
			if(i%2 == 0)
				result+=i;
		}
		return result;
	}
	//add all the odds
	static int addOdds(ArrayList<Integer> ints)
	{
		int result = 0;
		for(int i:ints)
		{
			if(i%2 == 1)
				result+=i;
		}
		return result;
	}
	//remove the prime numbers in the array list and print the remaining numbers
	static void removePrimes(ArrayList<Integer> ints)
	{
		ArrayList<Integer> newList = new ArrayList<Integer>();
		for(Integer i:ints)
		{
			if(i == 1)
				continue;
			if(i == 2)
				newList.add(i);
			else
			{
				if(isPrime(i))
					newList.add(i);
			}
		}
		ints.removeAll(newList);
	}
	
	//method to check if a number is prime 
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

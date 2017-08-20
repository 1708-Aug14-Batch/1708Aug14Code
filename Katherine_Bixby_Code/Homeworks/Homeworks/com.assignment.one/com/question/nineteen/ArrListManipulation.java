package com.question.nineteen;

import java.util.ArrayList;

/**
 * Creates an ArrayList of integers 1 through 10 and displays it.
 * Add all the even numbers up and display the result.
 * Add all the odd numbers up and display the result.
 * Remove the prime numbers from the ArrayList and print out the remaining ArrayList.
 * 
 */
public class ArrListManipulation {
	
	/**
	 * Displays the array list
	 * @param theList
	 * 		The numbers...1 to 10 in this case
	 */
	public void displayArrList(ArrayList<Integer> theList) {
		for(int i:theList) {
			System.out.print(i+" ");
		}
	}
	/**
	 * Adds the even numbers from the given array list together
	 * @param theList
	 * 		The array list to add the values of
	 */
	public void addEvens(ArrayList<Integer> theList) {
		int sum = 0;
		for(int i:theList) {
			if(i%2==0) {
				sum+=i;
			}
		}
		System.out.println("The sum of the even numbers in this list is :"+sum);
	}
	/**
	 * Adds the odd numbers from the given array list together
	 * @param theList
	 * 		The array list to add the values of
	 */
	public void addOdds(ArrayList<Integer> theList) {
		int sum = 0;
		for(int i:theList) {
			if(i%2==1) {
				sum+=i;
			}
		}
		System.out.println("The sum of the odd numbers in this list is :"+sum);
	}
	/**
	 * Removes the prime numbers from an array list
	 * @param theList
	 * 		The list to remove primes from
	 * @return
	 * 		The list with no primes
	 */
	public ArrayList<Integer> removePrimes(ArrayList<Integer> theList) {
		ArrayList<Integer> noPrimes = new ArrayList<Integer>();
		for(int i:theList) {
			if(!isPrime(i)) {
				noPrimes.add(i);
			}
		}
		return noPrimes;
	}
	
	/**
	 * Whether or not a number is prime
	 * @param checkNum
	 * 		The number to check
	 * @return
	 * 		Whether or not it is prime
	 */
	private static boolean isPrime(int checkNum) {
	    if (checkNum%2==0) return false;
	    for(int i=3;i*i<=checkNum;i+=2) {
	        if(checkNum%i==0)
	            return false;
	    }
	    return true;
	}
	

}

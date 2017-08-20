package com.quesetion.twelve;

import java.util.ArrayList;

/**
 * Generates an ArrayList of ints from a given maximum value
 * Then has a method for printing out the even numbers within this array
 * 
 * @author Katie
 *
 */
public class PrintEvens {

	public static int max;
	public static ArrayList<Integer> theInts = new ArrayList<Integer>();

	/**
	 * Constructor
	 * @param maximum
	 * 		The maximum value for the array (generated from 0 to this max)
	 */
	public PrintEvens(int maximum) {
		super();
		PrintEvens.max = maximum;
		generateArray();
	}
	
	/**
	 * Private method used for generating the array (separated just to keep things organized)
	 */
	private static void generateArray() {
		for(int i=0;i<max-1;i++) {
			theInts.add(i);
		}
	}
	
	/**
	 * Method for printing out the evens within the given array
	 */
	public void printEvens() {
		for(int i:theInts) {	// for each int in the array
			if(theInts.get(i)%2==0) {	// check if it's evenly divisible by 2 (even)
				System.out.print(theInts.get(i)+" ");
			}
		}
	}
	
}

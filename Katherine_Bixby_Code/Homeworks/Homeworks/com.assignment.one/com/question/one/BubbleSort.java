package com.question.one;

/**
 * This is a class that implements a Bubble Sort.
 * It takes an unsorted integer array and sorts them by checking two adjacent indexes and if the number to the left in the current two
 * slot index is higher, it stores it in a temporary variable and uses that to swap them.
 * It goes through the array like this until it reaches the end, at which point the last number will guaranteed be the highest.
 * It then goes through this process again with one less index (because we don't need to check the last one again).
 * It does this until the array is sorted.
 * 
 * @author Katie
 *
 */

public class BubbleSort {

	
	/**
	 * Method for printing out an array of number values
	 * @param numList
	 * 		The int array to be printed out
	 */
	public static void printArr(int[] numList) {
		for (int i=0;i<numList.length;i++) { // go through each index
			if(i==numList.length-1) { // if the value is the last value
				System.out.print(numList[i]); // so it doesn't print with a comma
			}
			else { // if it isn't the last value
				System.out.print(numList[i]+", "); // print it out with a comma and space to space out the printing
			}
			
		}
	}
	
	
	/**
	 * Sorts the array of numbers using Bubble Sort
	 * @param unsorted
	 * 		The unsorted array
	 */
	public static void sortBubbles(int[] unsorted) {
		printArr(unsorted); // print out the unsorted array
		int temp = 0; // create a variable to temporarily hold our swap values
		int len = unsorted.length; // for convenience of use with for loops
		for (int i=0;i<len;i++) { // loop going through every value in the array
			for (int j=0;j<len-1;j++) { // loop going through checking each of the values being swapped for a given runthrough
				if (unsorted[j]>unsorted[j+1]) { // if the value on the left is larger than the value on the right
					temp = unsorted[j+1]; // store the right value in a temporary location
					unsorted[j+1]=unsorted[j]; // put the value of the left index into the right index
					unsorted[j]=temp; // make the value on the left equal to the temp variable that stored the old right value (thus swapping them)
				}
			}
			len--;
		}
		System.out.println(""); // creating a blank new line to separate the prints
		printArr(unsorted); // print out the new sorted array (even though it's still called unsorted, it is now sorted.
	}
	
	
	
}
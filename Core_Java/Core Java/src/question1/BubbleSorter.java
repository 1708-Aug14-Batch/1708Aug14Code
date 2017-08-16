package question1;

import java.util.Arrays;

/*
 * Q1. Perform a bubble sort on the following integer array:
 * 		1,0,5,6,3,2,3,7,9,8,4
 */

/*
 * Bubble Sort is a simple sorting algorithm.
 * It works by repeatedly swapping adjacent elements in
 * an array if they are in wrong order.
 */

public class BubbleSorter {
	
	// A provided input of numbers to be sorted
	private static int[] inputArray = {1,0,5,6,3,2,3,7,9,8,4};
	
	public static void main(String[] args) {
		// Print pre-sorted array
		System.out.print("Pre-sorted array:  ");
		System.out.println(Arrays.toString(inputArray));
	
		// Sort the given array
		int[] outputArray = bubbleSort(inputArray);
		
		// Print sorted array
		System.out.print("Post-sorted array: ");
		System.out.println(Arrays.toString(outputArray));
	}
	
	public static int[] bubbleSort(int[] inputArray) {
		// Keeps track of whether two numbers were swapped during
		// a single pass through the array
		boolean swapped = true;
		
		if (inputArray == null)
			return null;
		
		while (swapped) {
			// Set to true by default. If nothing is swapped then loop will end
			swapped = false;
			
			// Current index for searching through the array
			int i;
			/*
			 * Bubble sort will be looking at numbers in pairs
			 * so the loop ends at one previous to the last element
			 */
			for (i = 0; i < inputArray.length-1; i++) {
				if (inputArray[i] > inputArray[i+1]) {
					swapped = true;
					
					// Swapping two elements requires a third
					// temporary variable
					int temp = inputArray[i];
					inputArray[i] = inputArray[i+1];
					inputArray[i+1] = temp;
				}
			}
			
		}
		
		return inputArray;
	}
	
}

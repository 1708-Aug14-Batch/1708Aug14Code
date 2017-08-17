package com.revature.q01;

public class BubbleSort {
	public static void main(String[] args) {
		naiveBubbleSortTest();
		System.out.println();
		smartBubbleSortTest();
	}
	
	public static void naiveBubbleSortTest() {
		int[] arr = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		System.out.print("Before naive bubble sort: ");
		for (int n: arr)
			System.out.print(n + " ");
		System.out.println();
		
		naiveBubbleSort(arr);
		
		System.out.print("After naive bubble sort: ");
		for (int n: arr)
			System.out.print(n + " ");
		System.out.println();
	}
	
	/*
	 * Bubble sort without usage of a flag to stop it
	 * from doing redundant looping
	 */
	public static void naiveBubbleSort(int[] arr) {
		for (int i = 0; i < arr.length-1; i++)
			for (int j = i; j < arr.length-1; j++)
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
	}
	
	
	public static void smartBubbleSortTest() {
		int[] arr = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		System.out.print("Before smart bubble sort: ");
		for (int n: arr)
			System.out.print(n + " ");
		System.out.println();
		
		smartBubbleSort(arr);
		
		System.out.print("After smart bubble sort: ");
		for (int n: arr)
			System.out.print(n + " ");
		System.out.println();
	}
	
	/*
	 * Bubble sort with usage of a flag to stop it
	 * from doing redundant looping
	 * Stops looping after a single inner pass has made no changes
	 * to the array, meaning all elements are in order
	 */
	public static void smartBubbleSort(int[] arr) {
		boolean swapped;
		for (int i = 0; i < arr.length-1; i++) {
			swapped = false;
			for (int j = i; j < arr.length-1; j++) {
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					swapped = true;
				}
			}
			if (!swapped)
				return;
		}
	}
}

package com.revature.junit;

public class JUnitBasics {
	public static void main(String[] args) {
		
	}
	
	public static int min(int[] arr) {
		int least = arr[0];
		for (int i=1; i<arr.length; i++)
			if (arr[i] < least)
				least = arr[i];
		return least;
	}
	
	public static int max(int[] arr) {
		int max = arr[0];
		for (int i=1; i<arr.length; i++)
			if (arr[i] > max)
				max = arr[i];
		return max;
	}
}

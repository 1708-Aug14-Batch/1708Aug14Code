package com.WeekOneHW.QuestionOne;

public class BubbleSort {

	public static void main(String[] args) {
		int[] list = {1,0,5,6,3,2,3,7,9,8,4}; //Creates the array of ints
		bubbleSort(list); //Calls the bubbleSort function
		for(int i:list) //Enhanced for loop to print out the sorted list
			System.out.println(i);

	}

	public static void bubbleSort(int[] arr) { //bubbleSort method that thats the array as an argument.
		int length = arr.length; //Sets the length used in the loops to the length of the array
		int temp; //Creates a temp variable to temporarily store a value for the swapping
		for (int i = 0; i < length; i++) { //For loop that increments through the length of the array
			for(int j = 1; j < length - i; j++) { //A nested for loop that starts 1 element ahead of the outer loop.
				if(arr[j-1] > arr[j]) { //If statement that checks if the element before j is greater.
					temp = arr[j-1]; //Sets the temp value to the value before j (in this first loop it temp would be set to 1
					arr[j-1] = arr[j]; //Sets that value to the value at J (in this first loop it would set arr[0] to 0
					arr[j] = temp; //Sets the new value at this point in the array to the temp value. (in the first loop temp is 1
				}
			}
		}
	}
}

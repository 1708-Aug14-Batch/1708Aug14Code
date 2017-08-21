package com.ex.question1;

public class BubbleSort {

	public static void main(String[] args) {
		
		//array to sort
		int[] arr = {1,0,5,6,3,2,3,7,9,8,4};
		
		//before sorting
		printArray(arr);
		System.out.println();
		
		//sorting throught entire array 
		for(int i =0; i<arr.length-1; i++)
		{
			for(int j = 0; j < arr.length-i-1; j++)
			{
				if(arr[j] > arr[j+1])
				{
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		//after sorting
		printArray(arr);
	}
	
	//seperate print array method
	
	static void printArray(int[] arr)
	{
		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + " ");
		}
	}

}

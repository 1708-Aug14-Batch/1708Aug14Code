package com.hw.q1;

public class Q1 {

	public int[] bubbleSort(int[] nums)
	{
		boolean swapped = false;
		do
		{
			swapped = false;
			for (int i = 1; i < nums.length; i++)
			{
				if (nums[i-1] > nums[i])
				{
					int tmp = nums[i-1];
					nums[i-1] = nums[i];
					nums[i] = tmp;
					swapped = true;
				}
			}
		} while (swapped == true);
		return nums;
	}
	
	public static void main(String[] args) {
		/*
		int[] numbers = new int[] {1,0,5,6,3,2,3,7,9,8,4};
		int[] sorted = bubbleSort(numbers);
		for (int i = 0; i < sorted.length; i ++)
			System.out.println(sorted[i]);*/
	}

}

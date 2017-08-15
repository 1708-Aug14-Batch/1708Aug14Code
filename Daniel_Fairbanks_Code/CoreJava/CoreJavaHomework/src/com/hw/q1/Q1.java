package com.hw.q1;

public class Q1 {

	public static void main(String[] args) {
		
		int[] numbers = new int[] {1,0,5,6,3,2,3,7,9,8,4};
		boolean swapped = false;
		do
		{
			swapped = false;
			for (int i = 1; i < numbers.length; i++)
			{
				if (numbers[i-1] > numbers[i])
				{
					int tmp = numbers[i-1];
					numbers[i-1] = numbers[i];
					numbers[i] = tmp;
					swapped = true;
				}
			}
		} while (swapped == true);
		for (int i = 0; i < numbers.length; i ++)
			System.out.println(numbers[i]);
	}

}

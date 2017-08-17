package com.WeekOneHW.QuestionTwelve;

public class EvenNumberForLoop {

	public static void main(String[] args) {
		
		int[] list = new int[100]; //Creating the array to store the numbers
		
		for(int i = 1; i <= 100; i++) //Running a simple for loop to fill the array with numbers 1 - 100
			list[i - 1] = i;
		
		for(int i:list) { //Enhanced for loop used for output
			if(i%2 == 0) //If the number i has zero remainder after the modulus, then output the number.
				System.out.print(i + " ");
		}
			

	}

}

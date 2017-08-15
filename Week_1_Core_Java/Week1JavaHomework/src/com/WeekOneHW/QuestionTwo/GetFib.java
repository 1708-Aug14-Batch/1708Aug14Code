package com.WeekOneHW.QuestionTwo;

public class GetFib {
	
	public static void main(String[] args) {
		int num1 = 0,num2 = 1,num3 = 0; //Establishes the variables for the equation
		int counter = 25; //Establishes the variable used to count up to 25 numbers
		System.out.print(num1 + " " + num2); //Goes ahead and outputs 0 and 1
		for(int i = 2; i < counter; i++) { //For loop that starts off past 0 and 1
			num3 = num2 + num1; //Num3 becomes the addition of num2 and num1
			System.out.print(" " + num3); //Prints out the new num 3
			num1 = num2; //Sets num1 to the value of num2
			num2 = num3; //Sets num2 to the value of num3
		}
		
	}
}

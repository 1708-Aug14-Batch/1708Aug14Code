package com.WeekOneHW.QuestionElevenA;
import com.WeekOneHW.QuestionElevenB.*; //Importing the Other Package for use


public class GrabbingVariables {

	public static void main(String[] args) {
		
		MakingVariables num = new MakingVariables(); //Creating a new class from the other package
		
		float result = num.number1 * num.number2; //Creating a variable thats the product of the two variables from the other package
		
		System.out.printf("%.2f", result); //Prints the result.
		
	}
}

package com.question.general;

import com.quesetion.six.EvenOrOdd;
import com.question.eight.ArrayOfNames;
import com.question.five.GetSubstring;
import com.question.four.Factorial;
import com.question.one.BubbleSort;
import com.question.three.ReverseString;
import com.question.two.Fibonacci;

public class RunQuestions {

	public static void main(String[] args) {
		
		/*
		 * Question 1
		 */
		System.out.println("Question 1: Bubble Sort");
		int[] unsorted = {1,0,5,6,3,2,3,7,9,8,4};
		BubbleSort.sortBubbles(unsorted);
		/*
		 * Question 2 - Add the 0th Thing
		 */
		System.out.println("\n\nQuestion 2: Fibonacci");
		int fibVal = 25;
		System.out.println("Fibonacci up to "+fibVal+": ");
		Fibonacci.printFibonacci(fibVal);
		
		/*
		 * Question 3 - This uses temp thing so change this...
		 */
		System.out.println("\n\nQuestion 3: Reverse String");
		String tbReversed = "reverse";
		String reversed = ReverseString.reverseString(tbReversed);
		System.out.println(tbReversed+" reversed is: "+reversed);
		
		/*
		 * Question 4
		 */
		System.out.println("\nQuestion 4: Factorial");
		int fact = 5;
		int result = Factorial.factorial(fact);
		System.out.println("The factorial of "+fact+" is: "+result);
		
		/*
		 * Question 5
		 */
		System.out.println("\nQuestion 5: Substrings");
		String togetSub = "This is my beautiful String";
		int subVal = 10;
		String subStringgy = GetSubstring.getSubstring(togetSub, subVal);
		System.out.println(subStringgy);
		
		
		/*
		 * Question 6
		 */
		System.out.println("\nQuestion 6: Even or Odd");
		int inputNum = 11;
		boolean isEven = EvenOrOdd.isItEven(inputNum);
		if(isEven) {
			System.out.println(inputNum+" is even!");
		}
		else {
			System.out.println(inputNum+" is odd!");
		}
		
		
		/*
		 * Question 7
		 */
		System.out.println("\nQuestion 7: ");
		
		
		
		/*
		 * Question 8
		 */
		System.out.println("\nQuestion 8: Palindrome Names");
		String theNames = "karan,madam,tom,civic,radar,sexes,jimmy,kayak,john,refer,billy,did";
		ArrayOfNames.cutStringOfNames(theNames);
		ArrayOfNames.palindromeNames();
		System.out.println("Print the whole name list:");
		ArrayOfNames.printArray(ArrayOfNames.nameList);
		System.out.println("Print the palindromes:");
		ArrayOfNames.printArray(ArrayOfNames.palNames);
		
		
		/*
		 * Question 9
		 */
		System.out.println("\nQuestion 9: ");
		
		
		
		/*
		 * Question 10
		 */
		System.out.println("\nQuestion 10: ");
		
		
		
		/*
		 * Question 11
		 */
		System.out.println("\nQuestion 11: ");
		
		
		
		/*
		 * Question 12
		 */
		System.out.println("\nQuestion 12: ");
		
		
		
		/*
		 * Question 13
		 */
		System.out.println("\nQuestion 13: ");
		
		
		
		/*
		 * Question 14
		 */
		System.out.println("\nQuestion 14: ");
		
		
		
		/*
		 * Question 15
		 */
		System.out.println("\nQuestion 15: ");
		
		
		
		/*
		 * Question 16
		 */
		System.out.println("\nQuestion 16: ");
		
		
		
		/*
		 * Question 17
		 */
		System.out.println("\nQuestion 17: ");
		
		
		
		/*
		 * Question 18
		 */
		System.out.println("\nQuestion 18: ");
		
		
		
		/*
		 * Question 19
		 */
		System.out.println("\nQuestion 19: ");
		
		
		/*
		 * Question 20
		 */
		System.out.println("\nQuestion 20: ");
		
		
		
	}

}

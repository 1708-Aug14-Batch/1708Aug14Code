package com.question.general;

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
		System.out.println("\nQuestion 2: Fibonacci");
		Fibonacci.printFibbonacci(25);
		
		/*
		 * Question 3
		 */
		System.out.println("\nQuestion 3: Reverse String");
		String reversed = ReverseString.reverseString("reverse");
		System.out.println(reversed);
		
		/*
		 * Question 4
		 */
		System.out.println("\nQuestion 4: Factorial");
		int fact = 5;
		int result = Factorial.factorial(fact);
		System.out.println(result);
	}

}

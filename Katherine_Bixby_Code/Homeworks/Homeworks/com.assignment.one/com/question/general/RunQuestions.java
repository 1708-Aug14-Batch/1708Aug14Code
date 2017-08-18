package com.question.general;

import java.util.ArrayList;

import com.quesetion.twelve.PrintEvens;
import com.question.eight.ArrayOfNames;
import com.question.eleven2.AccessFloats;
import com.question.fifteen.OperandTest;
import com.question.five.GetSubstring;
import com.question.four.Factorial;
import com.question.fourteen.SwitchStatement;
import com.question.nine.PrimeNums;
import com.question.one.BubbleSort;
import com.question.seventeen.Interest;
import com.question.six.EvenOrOdd;
import com.question.thirteen.TrianglePattern;
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
		 * Question 2 - Print out the fibs
		 */
		System.out.println("\n\nQuestion 2: Fibonacci");
		int fibVal = 25;
		System.out.println("Fibonacci of "+fibVal+": "+Fibonacci.printFibonacci(fibVal));
		
		/*
		 * Question 3 - Comment?
		 */
		System.out.println("\n\nQuestion 3: Reverse String");
		String tbReversed = "reverse";
		String reversed = ReverseString.reverseString(tbReversed);
		System.out.println(tbReversed+" reversed is: "+reversed);
		
		/*
		 * Question 4 - Comment
		 */
		System.out.println("\nQuestion 4: Factorial");
		int fact = 5;
		int result = Factorial.factorial(fact);
		System.out.println("The factorial of "+fact+" is: "+result);
		
		/*
		 * Question 5 - comment
		 */
		System.out.println("\nQuestion 5: Substrings");
		String togetSub = "This is my beautiful String";
		int subVal = 10;
		String subStringgy = GetSubstring.getSubstring(togetSub, subVal);
		System.out.println(subStringgy);
		
		
		/*
		 * Question 6 - comment
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
		 * Question 8 - Comment
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
		System.out.println("\nQuestion 9: Primes");
		ArrayList<Integer> searchNums = PrimeNums.storeNums(100);
		ArrayList<Integer> primeNumbers = PrimeNums.primeNums(searchNums);
		PrimeNums.printArray(primeNumbers);
		System.out.println("");
		
		
		/*
		 * Question 10
		 */
		System.out.println("\nQuestion 10: ");
		
		
		
		/*
		 * Question 11
		 */
		System.out.println("\nQuestion 11: Access Floats");
		AccessFloats accessFloats = new AccessFloats();
		accessFloats.printFloats();
		
		
		/*
		 * Question 12
		 */
		System.out.println("\nQuestion 12: Print Evens");
		PrintEvens printThem = new PrintEvens(100);
		printThem.printEvens();
		System.out.println("");
		
		/*
		 * Question 13 - I made the triangle pattern modular!
		 * 				 you can make it as many rows as you want,
		 * 				 and it will still follow the pattern every time!
		 */
		System.out.println("\nQuestion 13: Triangle Pattern");
		TrianglePattern trianglePattern = new TrianglePattern(4);
		trianglePattern.printTriangle();
		
		
		/*
		 * Question 14
		 */
		System.out.println("\nQuestion 14: Switch Case");
		SwitchStatement switchy = new SwitchStatement();
		System.out.println("Switch Statement 1 -");
		switchy.runSwitch(1);
		System.out.println("Switch Statement 2 -");
		switchy.runSwitch(2);
		System.out.println("Switch Statement 3 -");
		switchy.runSwitch(3);
		
		
		
		/*
		 * Question 15
		 */
		System.out.println("\nQuestion 15: Operand Fun");
		OperandTest meep = new OperandTest();
		double addOne = 15;
		double addTwo = 20;
		System.out.println(addOne+" + "+addTwo+" Equals: "+meep.addition(addOne,addTwo));
		double subOne = 80;
		double subTwo = 20;
		System.out.println(subOne+" - "+subTwo+" Equals: "+meep.subtraction(subOne,subTwo));
		OperandTest morp = new OperandTest();
		double divOne = 30;
		double divTwo = 8;
		System.out.println(divOne+"/"+divTwo+" Equals: "+morp.division(divOne,divTwo));
		double mulOne = 3;
		double mulTwo = 15;
		System.out.println(mulOne+"*"+mulTwo+" Equals: "+morp.multiplication(mulOne,mulTwo));
		
		
		/*
		 * Question 16
		 */
		System.out.println("\nQuestion 16: ");
		
		
		
		/*
		 * Question 17
		 */
		System.out.println("\nQuestion 17: Interest");
		Interest intr = new Interest();
		double thatInterest = intr.getInterest();
		System.out.println("Your Interest is: $"+thatInterest);
		
		
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

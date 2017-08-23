/**
 * 
 */
package com.hw.week01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.plaf.synth.SynthSeparatorUI;

import com.hw.week01.q01.BubbleSort;
import com.hw.week01.q02.Fibonacci;
import com.hw.week01.q03.ReverseString;
import com.hw.week01.q04.Factorial;
import com.hw.week01.q05.Substring;
import com.hw.week01.q06.EvenNumberChecker;
import com.hw.week01.q07.Employee;
import com.hw.week01.q07.EmployeeComparator;
import com.hw.week01.q08.Palindrome;
import com.hw.week01.q09.PrimeNumbers;
import com.hw.week01.q10.Minimum;
import com.hw.week01.q11.accessor.Accessor;
import com.hw.week01.q12.EvenNumbers;
import com.hw.week01.q13.Pyramid;
import com.hw.week01.q14.Switch;
import com.hw.week01.q15.Operable;
import com.hw.week01.q15.Operations;
import com.hw.week01.q18.ConcreteStrings;

/**
 * Homework for the week of 14 Aug.
 * Due on 20 Aug 12pm.
 * @author Will Underwood
 */
public class Main {

	public static void main(String[] args) {
		printBubbleSort();
		printFibonacciSequence();
		printReverseString();
		printFactorial();
		printSubstring();
		printEvenNumberCheck();
		printEmployeeComparison();
		printPalindromes();
		printPrimeNumbers();
		printMinimum();
		printAccessedFloats();
		printEvenNumbers();
		printPyramid();
		printSwitch();
		printOperations();
		question16();
		question17();
		printConcreteStringOutput();
		printArrayListModifications();
		printData();
	}

	private static void printBubbleSort() {
		int[] unsortedNumbers = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		System.out.println("Question 1");
		System.out.println("-----------");
		String unsortedList = "Unsorted: ";
		for(int i = 0; i < unsortedNumbers.length; i++) {
			unsortedList += unsortedNumbers[i] + " ";
		}
		System.out.println(unsortedList);
		int[] sortedNumbers = BubbleSort.sort(unsortedNumbers);
		String sortedList = "Sorted:   ";
		for(int j = 0; j < sortedNumbers.length; j++) {
			sortedList += sortedNumbers[j] + " ";
		}
		System.out.println(sortedList);
		System.out.println();
		System.out.println();
	}
	
	private static void printFibonacciSequence() {
		System.out.println("Question 2");
		System.out.println("------------------");
		int[] fibonacci = Fibonacci.sequence(25);
		for(int i = 0; i < fibonacci.length; i++) {
			System.out.print(fibonacci[i] + " ");
		}
		System.out.println();
		System.out.println();
	}
	
	private static void printReverseString() {
		System.out.println("Question 3");
		System.out.println("--------------");
		System.out.println("Test Word: PSYCHEDELIC");
		System.out.println("Reverse:   " + ReverseString.reverse("PSYCHEDELIC"));
		System.out.println();
		System.out.println();
	}
	
	private static void printFactorial() {
		System.out.println("Question 4");
		System.out.println("-----------");
		System.out.println("0! = " + Factorial.factorial(0));
		System.out.println("1! = " + Factorial.factorial(1));
		System.out.println("5! = " + Factorial.factorial(5));
		System.out.println("10! = " + Factorial.factorial(10));
		System.out.println();
		System.out.println();
	}
	
	private static void printSubstring() {
		System.out.println("Question 5");
		System.out.println("---------");
		System.out.println("Substring of \"psychedelic\" at index 5 = " + Substring.substring("psychedelic", 5));
		System.out.println();
		System.out.println();
	}
	
	private static void printEvenNumberCheck() {
		System.out.println("Question 6");
		System.out.println("-------------------");
		System.out.println("10 : " + EvenNumberChecker.isEven(10));
		System.out.println("5  : " + EvenNumberChecker.isEven(5));
		System.out.println("2  : " + EvenNumberChecker.isEven(2));
		System.out.println("1  : " + EvenNumberChecker.isEven(1));
		System.out.println();
		System.out.println();
	}
	
	private static void printEmployeeComparison() {
		System.out.println("Question 7");
		System.out.println("----------");
		Employee emp1 = new Employee("Billy Bob", "Slingblade", 35);
		Employee emp2 = new Employee("Miley Cyrus", "Disney", 20);
		ArrayList<Employee> emps = new ArrayList<Employee>();
		emps.add(emp2);
		emps.add(emp1);
		System.out.println("Unsorted employees: " + "[" + emps.get(0).getName() + ", " + emps.get(0).getDepartment() + ", " + emps.get(0).getAge() + " : " + emps.get(1).getName() + ", " + emps.get(1).getDepartment() + ", " + emps.get(1).getAge() + "]");
		Collections.sort(emps, new EmployeeComparator());
		System.out.println("Sorted employees: " + "[" + emps.get(0).getName() + ", " + emps.get(0).getDepartment() + ", " + emps.get(0).getAge() + " : " + emps.get(1).getName() + ", " + emps.get(1).getDepartment() + ", " + emps.get(1).getAge() + "]");
		System.out.println();
		System.out.println();
	}
	
	private static void printPalindromes() {
		System.out.println("Question 8");
		System.out.println("-----------");
		ArrayList<String> beginningList = new ArrayList<String>();
		beginningList.add("karan");
		beginningList.add("madam");
		beginningList.add("tom");
		beginningList.add("civic");
		beginningList.add("radar");
		beginningList.add("sexes");
		beginningList.add("jimmy");
		beginningList.add("kayak");
		beginningList.add("john");
		beginningList.add("refer");
		beginningList.add("billy");
		beginningList.add("did");
		System.out.println("Beginning List : " + beginningList);
		System.out.println("Palindromes    : " + Palindrome.returnPalindromes(beginningList));
		System.out.println();
		System.out.println();
	}
	
	private static void printPrimeNumbers() {
		System.out.println("Question 9");
		System.out.println("-------------");
		ArrayList<Integer> oneThroughOneHundred = new ArrayList<Integer>();
		for(int i = 1; i <= 100; i++) {
			oneThroughOneHundred.add(i);
		}
		System.out.println("Prime Numbers: " + PrimeNumbers.returnPrimeNumbers(oneThroughOneHundred));
		System.out.println();
		System.out.println();
	}
	
	private static void printMinimum() {
		System.out.println("Question 10");
		System.out.println("-------");
		System.out.println("1 vs 3, Minimum = " + Minimum.findMinimum(1, 3));
		System.out.println("5 vs 2, Minimum = " + Minimum.findMinimum(5, 2));
		System.out.println();
		System.out.println();
	}
	
	private static void printAccessedFloats() {
		System.out.println("Question 11");
		System.out.println("----------------------------------");
		Accessor accessor = new Accessor();
		System.out.println("Accessor accessed " + accessor.access());
		System.out.println();
		System.out.println();
	}
	
	private static void printEvenNumbers() {
		System.out.println("Question 12");
		System.out.println("------------");
		int[] oneThroughOneHundred = new int[100];
		for(int i = 0; i < 100; i++) {
			oneThroughOneHundred[i] = i + 1;
		}
		EvenNumbers.printEvenNumbers(oneThroughOneHundred);
		System.out.println();
		System.out.println();
	}
	
	private static void printPyramid() {
		System.out.println("Question 13");
		System.out.println("-------");
		Pyramid.printPyramid();
		System.out.println();
		System.out.println();
	}
	
	private static void printSwitch() {
		System.out.println("Question 14");
		System.out.println("---------------------");
		System.out.println("Option 1: ");
		Switch.demonstrateSwitch(1);
		System.out.println();
		System.out.println("Option 2: ");
		Switch.demonstrateSwitch(2);
		System.out.println();
		System.out.println("Option 3: ");
		Switch.demonstrateSwitch(3);
		System.out.println();
		System.out.println();
	}
	
	private static void printOperations() {
		Operable operators = new Operations();
		System.out.println("Question 15");
		System.out.println("-----------");
		System.out.println("4 + 2 = " + operators.addition(4, 2));
		System.out.println("4 - 2 = " + operators.substraction(4, 2));
		System.out.println("4 * 2 = " + operators.multiplication(4, 2));
		System.out.println("4 / 2 = " + operators.division(4.0, 2.0));
		System.out.println();
		System.out.println();
	}
	
	private static void question16() {
		System.out.println("Question 16");
		System.out.println("-----------");
		System.out.println("See com.hw.week01.q16");
		System.out.println();
		System.out.println();
	}
	
	private static void question17() {
		System.out.println("Question 17");
		System.out.println("-----------");
		System.out.println("See com.hw.week01.q17");
		System.out.println();
		System.out.println();
	}
	
	private static void printConcreteStringOutput() {
		System.out.println("Question 18");
		System.out.println("----------------------");
		ConcreteStrings strings = new ConcreteStrings();
		System.out.println("Capital contains uppercase letters : " + strings.containsUpperCaseLetters("Capital"));
		System.out.println("Capital to uppercase is " + strings.toUpperCase("Capital"));
		System.out.println("10 + 10 = " + strings.addTen("10"));
		System.out.println();
		System.out.println();
	}
	
	private static void printArrayListModifications() {
		System.out.println("Question 19");
		System.out.println("-----------");
		ArrayList<Integer> oneThruTen = new ArrayList<Integer>();
		oneThruTen.add(1);
		oneThruTen.add(2);
		oneThruTen.add(3);
		oneThruTen.add(4);
		oneThruTen.add(5);
		oneThruTen.add(6);
		oneThruTen.add(7);
		oneThruTen.add(8);
		oneThruTen.add(9);
		oneThruTen.add(10);
		System.out.println("1 to 10: ");
		for(int number : oneThruTen) {
			System.out.print(number + " ");
		}
		System.out.println();
		System.out.println("Even numbers: ");
		for(int number : oneThruTen) {
			if(number % 2 == 0) {
				System.out.print(number + " ");
			}
		}
		System.out.println();
		System.out.println("Odd numbers: ");
		for(int number : oneThruTen) {
			if (number % 2 != 0) {
				System.out.print(number + " ");
			}
		}
		System.out.println();
		System.out.println("No primes: ");
		for(int number : oneThruTen) {
			int numberOfDivisors = 0;
			for(int i = 1; i < oneThruTen.size(); i++) {
				if (number % i == 0) {
					numberOfDivisors++;
				}
			}
			if (numberOfDivisors > 2) {
				System.out.print(number + " ");
			}
		}
		System.out.println();
		System.out.println();
		System.out.println();
	}
	
	private static void printData() {
		System.out.println("Question 20");
		System.out.println("-----------");
		try {
			BufferedReader reader = new BufferedReader(new FileReader("src/com/hw/week01/Data.txt"));
			String line = null;
			while((line = reader.readLine()) != null) {
				String[] data = line.split(":");
				System.out.println("Name: " + data[0] + " " + data[1]);
				System.out.println("Age: " + data[2]);
				System.out.println("State: " + data[3] + " State");
				System.out.println();
				
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

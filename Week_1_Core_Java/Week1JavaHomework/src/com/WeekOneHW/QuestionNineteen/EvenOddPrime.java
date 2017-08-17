package com.WeekOneHW.QuestionNineteen;

import java.util.ArrayList; //Importing the util for the ArrayList

public class EvenOddPrime {

	public static void main(String[] args) {
		
		//Sets up the ArrayList and runs a simple loop to fill the list from 1 to 10
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 1; i <= 10; i++)
			list.add(i);
		
		//Runs each function which will output the results
		EvenNums(list);
		OddNums(list);
		PrimeNums(list);

	}

	public static void EvenNums(ArrayList<Integer> arr) {
		/*
		 * The EvenNums method first establishes an int variable which will contain the result of the even numbers added together.
		 * To get that result, an enhanced for loop is ran and for each value that has zero remainder after modulus its added to the variable.
		 * It's then outputted.
		 */
		int result = 0;
		for(int i: arr) {
			if(i%2 == 0)
				result += i;
		}
		System.out.println(result);
	}
	public static void OddNums(ArrayList<Integer> arr) {
		/*
		 * The OddNums method operates exactly like the EvenNums method, with the difference being the loop checks for values that have some remainder after modulus.
		 */
		int result = 0;
		for(int i: arr) {
			if(i%2 != 0)
				result += i;
		}
		System.out.println(result);
	}
	public static void PrimeNums(ArrayList<Integer> arr) {
		/*
		 * The PrimeNums method runs a regular for loop(since we are modifying the data).
		 * Since 2 is considered Prime we go ahead and have it removed.
		 * For the remaining values its an if/else if statement that if they are not divisble by 2 or 3 then its removed.
		 * Finally the remaining list gets outputted.
		 */
		for(int i = 1; i<= arr.size() - 1; i++) {
			if(arr.get(i) == 2)
				arr.remove(i);
			if(arr.get(i)%2 != 0) {
				arr.remove(i);
				
			}
			else if(arr.get(i)%3 != 0) {
				arr.remove(i);
				
			}
		}
		System.out.println(arr);
	}
}

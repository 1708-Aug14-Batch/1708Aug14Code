package com.WeekOneHW.QuestionNine;

import java.util.*; //Importing in Java util to use the ArrayList

public class PrimeNumbers {

	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<Integer>(); //Creating an Integer ArrayList to store the 1 to 100 values
		
		
		for(int i = 1; i <= 100; i++) //Simple for loop to add 1 to 100 to the list
			list.add(i);
		
		System.out.println(list);
		
		
		for(int i = 0; i <= 100; i++) {
			if(isPrime(i))
				System.out.print(i + " ");
		}
		
		

		
	}
	
	static boolean isPrime(int num) {
		
		if(num == 1) {
			return false;
		}
		if(num == 2) {
			return true;
		}
		if(num%2 == 0)
			return false;
		for(int i = 3; i*i<=num;i += 2) {
			if(num%i==0)
				return false;
		}
		return true;
	
	}
}

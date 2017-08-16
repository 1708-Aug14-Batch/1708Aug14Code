package problem12;

import java.util.ArrayList;

public class Problem12 {
	//Q12. Write a program to store numbers from 1 to 100 in an array. 
	//Print out all the even numbers from the array. 
	//Use the enhanced FOR loop for printing out the numbers.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int max = 100;
		
		ArrayList<Integer> evenArrList = new ArrayList<>();
		
		// Add 1-100 to array
		
		for(int x = 1; x <= max; x++) {
			evenArrList.add(x);
		}
		
		// Enhance loop print
		
		for(Integer x:evenArrList) {
			if(x%2==0)System.out.println(x);
		}
		
	}

}

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
		
		// Add all even by starting at 2 and adding 2
		
		for(int x = 2; x <= max; x+=2) {
			evenArrList.add(x);
		}
		
		// Enhance loop print
		
		for(Integer x:evenArrList) {
			System.out.println(x);
		}
		
	}

}

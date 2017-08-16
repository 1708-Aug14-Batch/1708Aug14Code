package problem9;

import java.util.ArrayList;

public class Problem9 {
	//Q9. Create an ArrayList which stores numbers from 1 to 100 
	//and prints out all the prime numbers to the console.

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int max = 100;
		
		ArrayList<Integer> intArrList = new ArrayList<>();
		
		// loop from 1-100, add each value to the arraylist
		// checks for prime while looping and prints if prime
		
		for(int x = 1; x<=max; x++) {
			intArrList.add(x);
			boolean prime = true;
			for(int y = 2; y<x; y++) {
				if(x%y == 0) {
					prime = false;
					break;
				}
			}
			if(prime == true) {
				System.out.println(x);
			}
		}	
	}
}

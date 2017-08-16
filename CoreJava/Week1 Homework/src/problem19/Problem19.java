package problem19;

import java.util.ArrayList;

public class Problem19 {
	//Q19. Create an ArrayList and insert integers 1 through 10. 
	//Display the ArrayList. Add all the even numbers up and display the result. 
	//Add all the odd numbers up and display the result. 
	//Remove the prime numbers from the ArrayList and print out the remaining ArrayList.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> intArrList = new ArrayList<>();
		
		// add 1-10 to arraylist
		
		for(int x=1;x<=10;x++) {
			intArrList.add(x);
		}
		
		int totalEven = 0;
		int totalOdd = 0;
		
		// totals even and odds
		
		System.out.println("ArrayList values");
		for(Integer x:intArrList) {
			System.out.print(x + "\t");
			if(x%2 == 0) {
				totalEven += x;	
			}
			else {
				totalOdd += x;
			}
		}
		
		System.out.println("\nTotal Even Value: " + totalEven);
		System.out.println("Total Odd Value: " + totalOdd);
		
		// remove primes
		
		for(int x = 1; x<=10; x++) {

			boolean prime = true;
			
			for(int y = 2; y<x; y++) {
				if(x%y == 0) {
					prime = false;
					break;
				}
			}
			
			if(prime == true) {
				intArrList.remove(Integer.valueOf(x));
			}
		}	
		
		System.out.println("ArrayList without primes " + intArrList);
	}

}

package questionNine;

import java.util.ArrayList;

public class PrimeTestArrayList {
	
	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<>();
		//creates empty ArrayList
		for(int i =1; i<101;i++) {
			boolean isPrime = false;
			//this variable will be true if i is prime, and false when it is not
			//it is reset at the beginning if each number
			//this for loop will check if i is prime
			for(int j:numbers) {
				//i is prime if it is not divisible by any preceeding numbers
				//however, it must be included that j is not 1 because
				//prime numbers are divisible by 1
				if(i%j == 0 && j!=1) {
					//if it is not prime, set isPrime to false
					//break the loop because only 1 circumstance is enough to rule out primality
					isPrime = false;
					break;
				}
				else {
					//if it is relatively prime to j, isPrime is set to true,
					//however it continues through the loop because it still might not be prime
					isPrime = true;
				}
			}
			if(isPrime) {
				//prints that i is prime if it hasn't failed primality testing
				System.out.println(i+" is prime");
			}
			numbers.add(i);
			//finally, this appends list with each number from 1 - 100
			//this had to be done at the end in order to not disrupt 
			//enhanced for loop used in primality test
		}
	}
}

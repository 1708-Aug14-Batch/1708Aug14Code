package Q9;

import java.util.ArrayList;

public class PrimeNumbers {
	//Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime numbers to the console.
	
	public static void main(String[] args) {
		ArrayList<Integer> list100 = new ArrayList();
		for(int i = 1; i <= 100; i++) {
			list100.add(i);
		}
		System.out.println("Prime numbers between 1 and 100");
		for(Integer num:list100) {
			if(isPrime(num)) {
				System.out.print(" " + num);
			}
		}
		System.out.println();
	}

	//checks whether an int is prime or not.
	static boolean isPrime(int n) {
		if (n == 1) return false;
	    //check if n is a multiple of 2 (except 2, which is true)
	    if (n == 2) return true;
	    else if (n % 2 == 0) return false;
	    //if not, then just check the odds
	    for(int i = 3; i * i <= n; i += 2) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}
}

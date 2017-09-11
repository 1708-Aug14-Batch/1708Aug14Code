package Q19;

import java.util.ArrayList;

public class Numbers {
	// Create an ArrayList and insert integers 1 through 10. Display the ArrayList. 
	// Add all the even numbers up and display the result. 
	// Add all the odd numbers up and display the result. 
	// Remove the prime numbers from the ArrayList and print out the remaining ArrayList.
	
	static ArrayList<Integer> int10 = new ArrayList();
	
	public static void main(String[] args) {
		for(int i = 1; i <= 10; i++) {
			int10.add(i);
		}
		System.out.println(int10);
		addEvenOdd();
		remPrime();
	}
	
	public static void addEvenOdd() {
		int sum1 = 0;
		int sum2 = 0;
		for(Integer x:int10) {
			if(x % 2 == 0) {
				sum1 = sum1 + x;
			} else {
				sum2 = sum2 + x;
			}
		}
		System.out.println("Even numbers added together is: " + sum1);
		System.out.println("Odd numbers added together is: " + sum2);
	}
	
	public static void remPrime() {
		for(int i = 0; i < int10.size(); i++) {
			if(isPrime(int10.get(i))) {
				int10.remove(i);
			}
		}
		System.out.println(int10);
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

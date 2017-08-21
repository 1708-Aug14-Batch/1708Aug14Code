package question.nineteen;

import java.util.ArrayList;

public class ArraylistMethods {

	public static void main(String[] args) {
		
		ArrayList<Integer> arr = new ArrayList<>();
		
		for (int i = 1; i <= 10; i++) {
			arr.add(i);
		}
		
		System.out.println(arr.toString());
		System.out.println();
		printEvensAndOdds(arr);
		removePrimes(arr);
		
	}
	
	static void printEvensAndOdds(ArrayList<Integer> arr) {
		
		ArrayList<Integer> evens = new ArrayList();
		ArrayList<Integer> odds = new ArrayList();
		
		for (Integer i: arr) {
			if (i % 2 == 0) {
				evens.add(i);
			}
			else {
				odds.add(i);
			}
		}
		System.out.println(evens.toString());
		System.out.println();
		System.out.println(odds.toString());
		
	}
	
	static void removePrimes(ArrayList<Integer> arr) {
		for (int i = 0; i < arr.size(); i++) {
			if(isPrime(arr.get(i)) == true) {
				arr.remove(i);
				i--;
			}
		}
		System.out.println(arr.toString());
	}
	
	static boolean isPrime(Integer c) {
		//eliminates 0 & 1 as they are not prime
		if (c == 0 || c == 1) {
			return false;
		}
		//since we know 2, 3, & 5 are prime we make sure these values return true
		if (c == 2 || c == 3 || c == 5) {
			return true;
		}
		if (c % 2 == 0 || c % 3 == 0) {
			return false;
		}

		return true;
	}

}

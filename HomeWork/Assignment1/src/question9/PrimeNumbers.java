package question9;

import java.util.ArrayList;

/**
 * Create an ArrayList which stores numbers from 1 to 100 
 * and prints out all the prime numbers to the console.
 * @author josh wurdemann
 *@version 8/19/2017
 */
public class PrimeNumbers {
	
	public static void printList(ArrayList<Integer> in){
		for(int s: in){
			System.out.println(s);
		}
	}
	
	
	public static boolean isPrime(int in){
	
		if( in == 1){
			return false;
		}
		
		if( in == 2 || in == 3 || in == 5 || in == 7){
			return true;
		}
		if(in % 2 == 0 || in % 3 == 0 || in % 5 == 0 || in % 7 == 0){
			
				return false;
			}
					
		return true;
		
	}
	public static void addToList(ArrayList<Integer> in){
		for(int i = 0; i <= 100; i++){
			in.add(i);
		}
	}
	public static void main(String[] args) {
		ArrayList<Integer> prime = new ArrayList<>();
		addToList(prime);
		//printList(prime);
        
		for(int i = 0; i < prime.size(); i++){
			int number = prime.get(i);
			if(isPrime(number)){
				System.out.println(number);
			}
		
		}
		
	}
}
package question19;

import java.util.ArrayList;

import question6.EvenInterger;
import question9.PrimeNumbers;
/**
 * Create an ArrayList and insert integers 1 through 10. Display the ArrayList. 
 * Add all the even numbers up and display the result. Add all the odd numbers
 *  up and display the result. Remove the prime numbers from the ArrayList 
 *  and print out the remaining ArrayList.
 * @author joshw
 *
 */
public class SortArrayList {
	public static boolean isEven(int number){

		if( number % 2 == 0){
			return true;
		}
		return false;
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
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();

		/* populates list with numbers up to 10*/
		for(int i = 0; i < 10; i++){
			list.add(i);
			System.out.print(i +": ");
		}

		/** Adds up all the even numbers*/
		int result = 0;
		int sum = 0;
		for(int i = 0; i < list.size(); i++){
			/** checks to see if even*/
			if(isEven(i)){
				result = result + i;
			} else{
				if(!isEven(i)){
					sum = sum + i;
				}
			}

		}
		System.out.println("");
		System.out.println(result);
		System.out.println(sum);
	

	/** Checks to see if prime and if so remove and then print the list*/
	for(int i = 0; i < list.size(); i++){
		if(isPrime(i)){
			list.remove(i);
			}
	}
	
	/** prints off newlist without prime numbers*/
	 for(int newList: list){
		 System.out.print(newList + ":");
	 }

	}
}

package questionNinetn;

import java.util.ArrayList;

public class ArrayListDisplay {
	
	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<>();
		for(int i=1;i<11;i++) {
			//loops through the numbers 1-10
			array.add(i);
			//adds them to the ArrayList
		}
		int evenSum=0;
		int oddSum =0;
		//initialized sums for odds and evens
		for(int i:array) {
			//loops through array
			System.out.print(i+" ");
			if(i%2==0) {
				//decided if this integer is even
				evenSum += i;
				//adds to even sum
			}
			else {
				//if it's not even, it's odd
				oddSum += i;
			}
		}
		
		System.out.println(" ");
		System.out.println("Sum of all even numbers: "+evenSum);
		System.out.println("Sum of all odd numbers: "+oddSum);
		//simply prints out the results
		
		int i=0;
		while(i<array.size()) {
			//creates isPrime as a variable to check if the element is prime
			boolean isPrime = false;
			int element = array.get(i);
			//gets each element
			for(int j=1;j<element;j++) {
				//checks if the element is not prime (if it is divisible by anything
				//other than 1 and itself
				if((element)%j==0 && j!=1) {
					//if it is not prime, sets isPrime to false and exits for loop
					isPrime =false;
					break;
				}
				else {
					//if it does pass this test, it is prime until proven not prime
					isPrime = true;
				}
			}
			if(isPrime==true) {
				//if at the end of this loop, isPrime is true, then the element definitely is prime
				array.remove(i);
				//i must be decremented, because after removing this item, the index of the next item
				//will decrease by one
				i--;
			}
			//increment i to proceed with while loop
			i++;
		}
		
		for(int j:array) {
			//simply prints out the new ArrayList
			System.out.print(j+" ");
		}
	}

}

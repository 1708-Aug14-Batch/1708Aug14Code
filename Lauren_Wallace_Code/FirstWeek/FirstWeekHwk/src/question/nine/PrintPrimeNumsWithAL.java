package question.nine;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PrintPrimeNumsWithAL {

	public static void main(String[] args) {
		
		printPrimeAL(createAL(100));
		
	}
	
	static List<Integer> createAL(int size) {
		
		List<Integer> nums = new ArrayList<Integer>();
		
		for (int i = 0; i < size+1; i++) {
			nums.add(i);
		}
		System.out.println(nums.toString());
		return nums;
	}
	
	static void printPrimeAL(List<Integer> nums) {
		//filters the List<Integer> to create a List called primes 
		List<Integer> primes = nums.stream().filter(num ->
		{
			//eliminates 0 & 1 as they are not prime
			if (num == 0 || num == 1) {
				return false;
			}
			//since we know 2, 3, & 5 are prime we make sure these values return true
			if (num == 2 || num == 3 || num == 5) {
				return true;
			}
			if (num % 2 == 0 || num % 3 == 0) {
				return false;
			}
			for(int i = 3; i < Math.sqrt(num); i+=2) {
				if (num % i == 0 || num % Math.sqrt(num) == 0) { 
					return false; }
				}

			return true;
		}
				).collect(Collectors.toList());
		System.out.println(primes.toString());
	}

}

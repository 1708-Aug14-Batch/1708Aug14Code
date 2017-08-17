package Q9;

import java.util.ArrayList;

public class Primes {
	
	public static ArrayList<Integer> getPrimes(ArrayList<Integer> nums) {
		ArrayList<Integer> ret = new ArrayList<>();
		
		for (Integer n : nums) {
			ret.add(n);
			for (int i = 2; i <= Math.sqrt(n); i++) {
				if (n % i == 0) {
					ret.remove(n);
					break;
				}
			}
		}
		
		return ret;
	}

	public static void main(String[] args) {
		
		ArrayList<Integer> nums = new ArrayList<>();
		for (int i = 0; i < 100; i++) nums.add(i+1);

		nums = getPrimes(nums);
		for (Integer n : nums) {
			System.out.print(n + ", ");
		}		
	}
}

package Q9;

import java.util.ArrayList;
import java.util.List;

public class Primes {
	public static void main(String[] args) {
		List<Integer> ints = new ArrayList<Integer>();
		for(int i = 1; i <= 100; i++){
			ints.add(i);
			if(isPrime(i)) System.out.println(i);
		}
	}
	
	static boolean isPrime(int n){
		if(n <= 1) return false;
		for(int i = 2; i <= Math.sqrt((double) n); i++){
			if(n%i == 0) return false;
		}
		return true;
	}
}

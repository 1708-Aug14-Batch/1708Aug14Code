package questionTwo;

import java.util.ArrayList;

public class Fibonacci {

	public static void main(String[] args) {
		//creates array with the first two fibonacci numbers
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(0);
		numbers.add(1);
		int length = numbers.size();
		
		//continues through arrayList until the 26th entry
		while (length < 26) {
			//produces the next number by adding the two preceeding numbers
			int number = numbers.get(length-1) + numbers.get(length-2);
			//adds the new number to the arrayList
			numbers.add(number);
			length = numbers.size();
			}
		
		for (int i : numbers) {
			//prints out the numbers
			System.out.print(i+" ");
		}
		
		}

}

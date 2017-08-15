package questionTwo;

import java.util.ArrayList;

public class QuestionTwo {
	
	

	public static void main(String[] args) {
		//recursive funcion
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(1);
		int length = numbers.size();
		
		
		while (length < 25) {
			int number = numbers.get(length-1) + numbers.get(length-2);
			numbers.add(number);
			length = numbers.size();
			}
		
		for (int i : numbers) {
			System.out.print(i+" ");
		}
		
		}

}

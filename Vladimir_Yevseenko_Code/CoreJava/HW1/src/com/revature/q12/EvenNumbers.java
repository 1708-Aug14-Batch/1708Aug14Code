package com.revature.q12;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class EvenNumbers {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		/*
		 * Filling the list using a Stream
		 */
		IntStream.range(1,  101).forEach(i -> list.add(i));
		
		System.out.println("Even numbers in 1-100: ");
		
		/*
		 * Using Java 8 streams to print each even number
		 */
		list.stream()
			.filter(i -> i % 2 == 0)
			.forEach(i -> System.out.print(i + " "));
		
		System.out.println();
		
		/*
		 * Just as an aside, the following code is more interesting
		 * and does all of the above in essentially one line
		 */
		IntStream.range(1, 101)
			.filter(i -> i % 2 == 0)
			.forEach(i -> System.out.print(i + " "));
	}
	
}

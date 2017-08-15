package com.hw.q12;
import java.util.ArrayList;

public class Q12 {

	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (int i = 1; i <= 100; i++)
			numbers.add(i);
		for (int n: numbers)
		{
			if (n%2 == 0)
				System.out.println(n);
		}
	}

}

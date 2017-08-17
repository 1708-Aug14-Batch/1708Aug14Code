package com.revature.q12;

import java.util.ArrayList;

public class EvenNumbers {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i=1; i <= 100; i++)
			list.add(i);
		System.out.println("Even numbers in 1-100: ");
		for (int i: list)
			if (i % 2 == 0)
				System.out.print(i + " ");
	}
}

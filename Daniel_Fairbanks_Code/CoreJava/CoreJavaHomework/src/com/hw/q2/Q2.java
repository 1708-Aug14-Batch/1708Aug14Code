package com.hw.q2;

import java.util.ArrayList;

public class Q2 {
	
	public ArrayList<Integer> fib(int numElements)
	{
		ArrayList<Integer> elements = new ArrayList<Integer>();
		if (numElements == 0)
			return elements;
		int first = 0;
		elements.add(first);
		if (numElements == 1)
			return elements;
		int second = 1;
		elements.add(second);
		if (numElements == 2)
			return elements;

		for (int i = 3; i <= numElements; i++)
		{
			elements.add(first+second);
			first = second;
			second = first+second;
		}
		return elements;
	}
	
	public static void main(String[] args) {
		/*int first = 0;
		int second = 1;
		System.out.println(first);
		System.out.println(second);
		for (int i = 3; i <= 25; i++)
		{
			System.out.println(first+second);
			first = second;
			second = first+second;
		}*/
	}
}

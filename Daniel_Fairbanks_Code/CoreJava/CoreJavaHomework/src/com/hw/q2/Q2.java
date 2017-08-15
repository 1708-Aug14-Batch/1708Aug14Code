package com.hw.q2;

public class Q2 {
	
	public static void main(String[] args) {
		int first = 0;
		int second = 1;
		System.out.println(first);
		System.out.println(second);
		for (int i = 3; i <= 25; i++)
		{
			System.out.println(first+second);
			first = second;
			second = first+second;
		}
	}
}

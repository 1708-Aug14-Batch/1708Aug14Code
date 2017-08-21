package com.ex.Q9;

import java.util.ArrayList;

public class Q9 {
	private static boolean isPrime(int i)
	{
		int counter = 0;

		for(int j = 1; j <= i; j++)
			if( i % j == 0)
				counter++;

		if( i <= 3 )
			return true;
		else if( counter > 2)
			return false;
		else
			return true;
	}


	public static void main(String[] args)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();

		for(int i = 1; i <= 100; i++)
		{
			list.add(i);
			if( isPrime(i) )
				System.out.print(i + ", ");
		}
	}
}

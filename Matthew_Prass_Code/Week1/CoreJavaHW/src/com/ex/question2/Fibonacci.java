package com.ex.question2;

public class Fibonacci {

	public static void main(String[] args) 
	{
		//starts at c=a+b
		int a = 0;
		int b = 1;
		int c;
		
		//going through it 25 times
		for(int i = 0; i < 25; i++)
		{
			c = a+b;
			System.out.print(" " + c);
			a= b;
			b = c;
			
		}
	}

}

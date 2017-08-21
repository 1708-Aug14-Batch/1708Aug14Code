package com.ex.question12;

public class EvenArray {
	public static void main(String[] args) {
		
		//array of 100 spaces
		int[] arr = new int[100];
		
		//1,2,3,4,etc.
		for(int i =1; i<101; i++)
		{
			arr[i-1] = i;
		}
		
		//find every even number in the array and print it
		for(int x:arr)
		{
			if(x%2==0)
				System.out.println(x);
		}
	}

}

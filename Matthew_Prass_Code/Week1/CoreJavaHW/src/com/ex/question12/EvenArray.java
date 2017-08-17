package com.ex.question12;

public class EvenArray {
	public static void main(String[] args) {
		
		int[] arr = new int[100];
		
		for(int i =1; i<101; i++)
		{
			arr[i-1] = i;
		}
		
		for(int x:arr)
		{
			if(x%2==0)
				System.out.println(x);
		}
	}

}

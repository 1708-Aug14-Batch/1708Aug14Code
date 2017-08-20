package com.question13;

public class question13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] triangle = {0,1,0,1,0,1,0,1,0,1};
		
		System.out.println(triangle[0]);
		for(int i=1; i<3; i++)
			System.out.print(triangle[i]);
		System.out.println();
		for(int i=3; i<6; i++)
			System.out.print(triangle[i]);
		System.out.println();
		for(int i=6; i<10; i++)
			System.out.print(triangle[i]);
		System.out.println();

	}

}

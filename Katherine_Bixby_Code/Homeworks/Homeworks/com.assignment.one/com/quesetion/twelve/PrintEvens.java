package com.quesetion.twelve;

import java.util.ArrayList;

public class PrintEvens {

	public static int max;
	public static ArrayList<Integer> theInts = new ArrayList<Integer>();

	public PrintEvens(int maximum) {
		super();
		PrintEvens.max = maximum;
		generateArray();
	}
	
	private static void generateArray() {
		for(int i=0;i<max-1;i++) {
			theInts.add(i);
		}
	}
	public void printEvens() {
		for(int i:theInts) {
			if(theInts.get(i)%2==0) {
				System.out.print(theInts.get(i)+" ");
			}
		}
	}
	
}

package com.question.thirteen;

import java.util.ArrayList;

public class TrianglePattern {

	static int numRows;

	public TrianglePattern(int numRows) {
		super();
		TrianglePattern.numRows = numRows;
	}
	
	
	private ArrayList<Integer> getLine(ArrayList<Integer> lastLine){
		ArrayList<Integer> nextLine = new ArrayList<Integer>();
		int lastNum = lastLine.get(lastLine.size()-1);
		int lineSize = lastLine.size()+1;
		for(int i=0;i<lineSize;i++) {
			if(lastNum==0) {
				nextLine.add(1);
			}
			else {
				nextLine.add(0);
			}
			lastNum=nextLine.get(i);
		}
		
		return nextLine;
	}
	
	public static void printArrays(ArrayList<Integer> toPrint) {
		for(int i=0;i<toPrint.size();i++) {
			System.out.print(toPrint.get(i));
		}
	}
	
	
	public void printTriangle() {
		ArrayList<Integer> firstLine = new ArrayList<Integer>();
		firstLine.add(0);
		ArrayList<Integer> nextLine = new ArrayList<Integer>();
		ArrayList<Integer> currentLine = firstLine;
		for(int n=0;n<numRows;n++) {
			if(n==0) {
				printArrays(firstLine);
				System.out.println("");
			}
			else {
				nextLine = getLine(currentLine);
				currentLine = nextLine;
				printArrays(nextLine);
				System.out.println("");
			}
		}
	}
	
}

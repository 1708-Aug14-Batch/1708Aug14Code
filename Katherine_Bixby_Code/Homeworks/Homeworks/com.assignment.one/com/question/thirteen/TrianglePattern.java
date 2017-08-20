package com.question.thirteen;

import java.util.ArrayList;

/**
 * Display triangles on the console as follows (iterable and can go further)
 * 0
 * 1 0
 * 1 0 1
 * 0 1 0 1
 * 
 * @author Katie
 */
public class TrianglePattern {

	static int numRows;

	/**
	 * The number of rows to make...can't keep it simple with just 4
	 * @param numRows
	 * 		The number of rows
	 */
	public TrianglePattern(int numRows) {
		super();
		TrianglePattern.numRows = numRows;
	}
	
	/**
	 * Calculating each line to be displayed in the pattern as
	 * an array list of integers (so the next line can index
	 * this line's last number)
	 * @param lastLine
	 * 		What the last line was before this current one was generated
	 * @return
	 * 		The values of this line
	 */
	private ArrayList<Integer> getLine(ArrayList<Integer> lastLine){
		ArrayList<Integer> nextLine = new ArrayList<Integer>();
		int lastNum = lastLine.get(lastLine.size()-1);	// the pattern makes it so it's always 0 1 0 1... if you delete the new lines
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
	
	/**
	 * Printing the line array
	 * @param toPrint
	 * 		The array to be printed in a line
	 */
	public static void printArrays(ArrayList<Integer> toPrint) {
		for(int i=0;i<toPrint.size();i++) {
			System.out.print(toPrint.get(i));
		}
	}
	
	/**
	 * Printing the entire triangle by printing one line of it after the other
	 */
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

package com.question.fourteen;

import java.util.Random;

public class SwitchStatement {

	public void runSwitch(int theCase) {
		switch(theCase) {
			case 1: 
				Random rand = new Random();
				int randNum = rand.nextInt(500) + 1;
				double printThis = findSqrt(randNum);
				System.out.println("The Square Root of "+randNum+" is: "+printThis);
				break;
			case 2:
				System.out.println(java.time.LocalDateTime.now());
				break;
			case 3:
				String thisString = "I am learning Core Java";
				String[] splittyString = thisString.split(" ");
				System.out.println("Element 2 in the sentence "+thisString+" is: "+splittyString[2]);
				break;
		}
	}
	
	private double findSqrt(double num) {
		double root = Math.sqrt(num);
		return root;
	}
	
}

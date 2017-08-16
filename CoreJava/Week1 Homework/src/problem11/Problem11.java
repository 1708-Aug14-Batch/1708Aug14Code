package problem11;

import problem11package2.TwoFloatVars;

public class Problem11 {
	//Q11. Write a program that would access two float-variables 
	//from a class that exists in another package. 
	//Note, you will need to create two packages to demonstrate the solution.

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Creates instance of TwoFloatVars and calls the get methods
		
		TwoFloatVars twoFloatVars = new TwoFloatVars();
		
		System.out.println("Height: " + twoFloatVars.getHeight() +
				"\nSize: " + twoFloatVars.getSize());
		
	}

}

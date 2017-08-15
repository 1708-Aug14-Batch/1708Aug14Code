package question11;

/*
 * Q11. Write a program that would access two float-variables from a class
 * that exists in another package. Note, you will need to create two
 * packages to demonstrate the solution.
 */

import question10.FindMin;

// This will access the float variables contained in package question10
public class FloatAccessor {
	
	public static void main(String[] args) {
		FindMin.float1 = (float) 4.2;
		FindMin.float2 = (float) 2.4;
		
		System.out.println(FindMin.float1 + ", " + FindMin.float2);
	}

}

package Q11a;

import Q11b.FloatVars;

public class AccessFloatVars {
	// Write a program that would access two float-variables from a class that exists in another package.
	// Note, you will need to create two packages to demonstrate the solution.
	public static void main(String[] args) {
		float x;
		float y;
		
		x = FloatVars.a;
		y = FloatVars.b;
		
		System.out.println("Local variable x: " + x);
		System.out.println("Package variable a: " + FloatVars.a);
		System.out.println("Local variable y: " + y);
		System.out.println("Package variable b: " + FloatVars.b);
	}

}

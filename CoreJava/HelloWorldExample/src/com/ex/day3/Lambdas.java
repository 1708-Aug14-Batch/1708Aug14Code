package com.ex.day3;

public class Lambdas {
	/* Functional Programming
		- Integrated in java 8
		- Support functional programming in Java and add several 
		benefits that developers can take advantage of, including
		ease of use, a concise way to represent a method interface
		using an expression, code reduction, improvement to the 
		collection and concurrency libraries. However, debugging 
		is a more complex process
		
		Lambda expressions 
		- allow for the creation and use of single method classes
		- They have a basic syntax that allows the omission of 
			modifiers, the return type, and optional parameters
		- Full syntax includes a parameter list with explicit or 
			implicit target types, the arrow operator, and the 
			body with statements
			 -The target type is the type of object in which a
			 	lambda is bound
			 -Multiple target types must be enclosed in parenthesis,
			 	a body with multiple statements must be enclosed in braces. 
					(parameter list) -> expression 
					(parameter list) -> {statements;}
	 */

	//instance of MyFunctionalInterface declared as a static variable
	static MyFunctionalInterface multiply = (int... nums)->{
		int product = 1;
		for(int i:nums){
			product *= i;
		}
		return product;
	};
	
	public static void main(String[] args) {
		
		//instance of MyFunctionalInterface local to main method
		MyFunctionalInterface add = (int... nums ) ->{
			int sum = 0;
			for(int i : nums){
				sum =+ i;
			}
			return sum;
		};
		
		//use of local object
		System.out.println(add.functioning(1, 2, 3, 5, 6));
		
		// use of static object
		System.out.println(multiply.functioning(1, 2, 3, 4, 5, 6));
	}
	
	
	
	/*
	 * Functional interfaces
	- Lambda expressions must have a functional interface, also 
		called a single abstract method, which provide a target 
		for lambda expressions as well as method references. 
	- They must have exactly one abstract method. Because of this, 
		the method name is known, and it is excluded from the
		actual lambda expression
	- An example of an FI that also includes default methods is 
		Java's Predicate FI
	 */
	interface MyFunctionalInterface{
		int functioning (int... nums); // varArgs - variable # of arguments
	}


}

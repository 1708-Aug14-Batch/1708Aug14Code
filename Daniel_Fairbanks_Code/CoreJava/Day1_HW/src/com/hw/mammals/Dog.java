package com.hw.mammals;
import com.hw.interfaces.Animal;

/*
 * The following class Dog is implemented from the interface Animal.
 * This is a form of INHERITANCE.
 * If this class was created as an abstract class, then this would be a form of ABSTRACTION.
 * This would make Dog uninstantiable and work as a generalization for any breeds inheriting from it.
 */
public class Dog implements Animal {
	
	public void talk() {
		System.out.println("The dog barked!");
	}

	public void move() {
		System.out.println("The dog walked.");
	}
	
	public void playCatch() {
		System.out.println("The dog is playing catch.");
	}
	
	public void sleep() {
		System.out.println("The dog is sleeping.");
	}
}

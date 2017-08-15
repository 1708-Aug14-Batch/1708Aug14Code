package com.revature.oop_principles;

/*
 *  this interface provides abstraction over the 
 *  behavior of classes that implement/are Edible
 *  we do not need to worry about the implementation
 *  that implementors of Edible use
 *  all that matters is that we are able to use
 *  the eat() method on anything that is instanceof Edible
 */
public interface Edible {
	void eat();
}

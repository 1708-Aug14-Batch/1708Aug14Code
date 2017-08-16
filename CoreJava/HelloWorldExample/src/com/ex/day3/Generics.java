package com.ex.day3;

import java.util.ArrayList;

public class Generics {
	/*
	 * Generics enable types (classes and interfaces) to
	 * be parameters when defining classes, interfaces, 
	 * and methods. They provide a way for you to reuse the
	 * same code with different inputs. The difference between
	 * these and "formal" parameters in method declarations
	 * is that the inputs to formal parameters are values, 
	 * while the inputs here are types
	 * Benefits: Generics add stability to your code by making more
	 * of your bugs detectable at compile time. Elimination
	 * of casting. Enabling programmers to implement 
	 * generic algorithms
	 */
	public static void main(String[] args) {


		ArrayList<String> strings = new ArrayList<String>();
		ArrayList things = new ArrayList();
		things.add(1);
		things.add("hello");
		things.add(new Object());


		Box<Integer> integerBox = new Box<Integer>();
		Box<String> stringBox = new Box<String>();
	}
}


class RegularBox{

	private Object object;

	public void set(Object object){	this.object = object;}
	public Object get() {return object;}
	/*
	 * since the methods accept or return an Object, you are
	 * able to pass in any type of object, an there is no way
	 * to verify at compile time how the class is used. 
	 */
}

class Box<T>{
	// T stands for type
	private T t;

	public void set(T t){this.t = t;}
	public T get(){ return t;}
	/*
	 * All occurrences of object are replaced by T. A type 
	 * variable can be any non-primitive type you specify
	 * 
	 */

	// --------------- Multi-type parameters ------------

	interface Pair<K,V>{

	}
}
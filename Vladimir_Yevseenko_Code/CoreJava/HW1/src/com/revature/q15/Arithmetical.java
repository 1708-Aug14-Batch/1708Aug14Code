package com.revature.q15;

/*
 * An interface to provide behavior of arithmetic operations for any type
 */
public interface Arithmetical<T> {
	T add(T t);
	T subtract(T t);
	T multiply(T t);
	T divide(T t);
}

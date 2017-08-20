package com.question.fifteen;

/**
 * Interface with the required methods for a simple operand
 * 
 * @author Katie
 *
 */

public interface OperandInterface {

	/**
	 * Adds two numbers together
	 * @param one
	 * 		First number to add
	 * @param two
	 * 		Second number to add
	 * @return
	 * 		Sum
	 */
	double addition(double one,double two);
	
	/**
	 * Subtracts two numbers
	 * @param one
	 * 		First number
	 * @param two
	 * 		Number to subtract from first number
	 * @return
	 * 		Sum
	 */
	double subtraction(double one, double two);
	
	/**
	 * Divides two numbers
	 * @param one
	 * 		First number
	 * @param two
	 * 		Number to divide the first one by
	 * @return
	 * 		The product
	 */
	double division(double one, double two);
	
	/**
	 * Multiplies two numbers
	 * @param one
	 * 		First number
	 * @param two
	 * 		Second number
	 * @return
	 * 		The product
	 */
	double multiplication(double one, double two);
}

package com.question.eighteen;

/**
 * Methods for that subclass to inherit
 * @author Katie
 *
 */
public abstract class AbstractSuper {
	
	/**
	 * Checks if there is a capital letter within a string
	 * @param str
	 * 		The string to check
	 * @return
	 * 		Whether or not there is a capital letter in it
	 */
	public abstract boolean capsCheck(String str);
	
	/**
	 * Makes every letter in a string a capital letter
	 * @param str
	 * 		The string to make capital
	 * @return
	 * 		The capital string
	 */
	public abstract String makeCaps(String str);
	
	/**
	 * Takes in a string containing a number and adds ten to it
	 * @param str
	 * 		The string number to add ten to
	 * @return
	 * 		The sum of str as an int + 10
	 */
	public abstract int addTen(String str);
	
}

package com.WeekOneHW.QuestionEightteen;



public class ConcreteSubClass extends SuperClassExample{ //My subclass extending the abstract superclass

	public static void main(String[] args) {

		ConcreteSubClass run = new ConcreteSubClass(); //Creating a new instance of the subclass so that I can run the abstract methods
		System.out.println(run.upperCheck("this is a test")); //Running the method to check if there are any uppercase characters
		System.out.println(run.convertUpper("This is another test")); //Running the method to convert to all caps
		System.out.println(run.parseExample("8")); //Running the method to add 10
		
		
	}
	@Override
	boolean upperCheck(String str) { //The upperCheck method. 
		/*
		 * First we create a char array to store the string in.
		 * Then we use an enhanced for-loop to check if each character is uppercase or not.
		 * If it is then return true
		 */
		char[] list = str.toCharArray();
		for(int i: list) {
			if(Character.isUpperCase(i)) {
				return true;
			}
		}
		
		
		return false;
	}

	@Override
	String convertUpper(String str) { //The convertUpper method
		/*
		 * This method simply sets a temp string variable to the string arguement.
		 * Then it takes it and coverts it to uppercase letter. It then returns
		 */
		String temp = new String(str);
		temp = str.toUpperCase();
		
		return temp;
	}

	@Override
	int parseExample(String str) { //The parseExample method
		/*
		 * Simple created an Integer wrapper class set to the string variable (which parses it).
		 * Then I added 10 to the result and returned. 
		 */
		Integer num = new Integer(str);
		int result = num + 10;
		
		return result;
	}

}

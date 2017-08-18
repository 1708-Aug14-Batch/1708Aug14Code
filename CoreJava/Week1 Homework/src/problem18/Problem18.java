package problem18;

public class Problem18 {
//		Q18. Write a program having a concrete subclass that inherits 
//		three abstract methods from a superclass.  
//		Provide the following three implementations in the subclass 
//		corresponding to the abstract methods in the superclass: 
//
//		Check for uppercase characters in a string, and 
//		return ‘true’ or ‘false’ depending if any are found.
//		Convert all of the lower case characters to uppercase 
//		in the input string, and return the result. 
//		Convert the input string to integer and add 10, output the result to the console.
//		Create an appropriate class having a main method to test the above setup.

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AbstractImplementation ai = new AbstractImplementation();
		
		String test = "HEllO WOrLD";
		
		System.out.println("String is: " + test);
		System.out.print("Contain uppercase? ");
		System.out.println(ai.containUppercase(test));
		
		System.out.println("Convert to uppercase");
		System.out.println(ai.converUppercase(test));
		
		String integer = "20";
		
		System.out.println("String is: " + integer);
		System.out.println("Convert to int and add 10");
		ai.stringToIntPlus10(integer);
		
	}

}
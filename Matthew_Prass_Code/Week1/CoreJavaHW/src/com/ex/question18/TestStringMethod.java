package com.ex.question18;

public class TestStringMethod {
	
	public static void main(String[] args) {
		
		//extends abstract class(and therefore has implementation)
		ModifyStrings m = new ModifyStrings();
		
		
		//testing out methods
		System.out.println(m.isUpper("lalala"));
		System.out.println(m.isUpper("lalalA"));
		
		System.out.println(m.toUpper("cat"));
		
		m.idk("123");
	}

}

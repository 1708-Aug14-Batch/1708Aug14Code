package com.ex.question18;

public class TestStringMethod {
	
	public static void main(String[] args) {
		
		ModifyStrings m = new ModifyStrings();
		
		System.out.println(m.isUpper("lalala"));
		System.out.println(m.isUpper("lalalA"));
		
		System.out.println(m.toUpper("cat"));
		
		m.idk("123");
	}

}

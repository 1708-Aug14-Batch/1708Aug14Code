package com.day3;

public class InstantNestedClasses {
	
	
	public static void main(String[] args) {
		NestedClasses outerObject = new NestedClasses();
		NestedClasses.MemberClass memClass = outerObject.new MemberClass();
		
		memClass.doOtherThings();
		memClass.message();
		
	}

}

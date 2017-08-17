package com.ex.day3;

import com.ex.day3.NestedClasses.memberClass;

public class NestedClasses {
/*
 * Java allows us to write classes within other classes
 * These are called nested classes
 * 
 * Benefits:
 * - logical grouping of classes only used in one place
 * - increases encapsulation
 * -more readable and maintainable code
 * 
 * Types:
 * -static - declared as a static member of another class
 */
	int a = 0;
	static int b = 0;
	
	
	static class staticClass{
		void message() {
			System.out.println("hi, I am in my inner class");
			System.out.println(b); //Can only access static variables from static classes
		}
	}
	
	class memberClass{
		void message() {
			System.out.println("hi i am in my member class");
			System.out.println(a + b); //Can access static and non static from regular classes
		}
	}
	public static void main(String[] args) {
		System.out.println("inside main method");
		class localClass{
			void message() {
				System.out.println("inside local class");
				System.out.println();
			}
		}
		myInterface anonClass = new myInterface() {

			@Override
			public void doThings() {
				System.out.println("doing things");
				
			}

			@Override
			public void doOtherThings() {
				System.out.println("doing other things");
				
			}
			
		};
		
		//inside of main
		
		staticClass stat = new staticClass();
		stat.message();
		
//		NestedClasses.memberClass mem = new NestedClasses.memberClass();
//		mem.message();
		
	}
	

}

interface myInterface{
	void doThings();
	void doOtherThings();
}

class Other{
	int a;
	String message;
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	NestedClasses nested = new NestedClasses();
	memberClass mc = nested.new memberClass();
	
	//mc.message();
}

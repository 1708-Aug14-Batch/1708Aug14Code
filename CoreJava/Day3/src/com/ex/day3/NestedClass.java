package com.ex.day3;

public class NestedClass {
	/*
	 * Java allows us to write classes within other
	 * classes, these are called nested classes
	 * 
	 * Benefits:
	 * - Logical grouping of classes only used in one place
	 * - increased encapsulation
	 * - more readable and maintaniable code
	 * 
	 * Types:
	 * - static: declared as a static member of another class
	 * 
	 * 
	 */
	
	int a1 = 0;
	static int b1 = 0;
	
	static class staticClass {
		void message() {
			System.out.println("I am in my inner class");
			System.out.println(b1);   // cannot print a1 because it is not static
		}
	}
	
	class memberClass {
		void message() {
			System.out.println("I am in my member class");
			System.out.println(a1);
			System.out.println(b1);
		}
	}
	
	public static void main(String[] args) {
		System.out.println("inside main method");
		class localClass{
			void message() {
				System.out.println("inside local class");
				System.out.println(b1);   // cannot print a1 because it is not static
			}
		}
	}
	
	Other anon = new Other() {
	// this is an anonymous class
		
	};
	
	MyInterface anonClass = new MyInterface() {
		public void doThings() {
			System.out.println("doing Things");
		}
		public void doOtherThings() {
			System.out.println("doing other Things");
		}
	};
	
}	

interface MyInterface{
	void doThings();
	void doOtherThings();
}

	class Other {
		int a;
		String message;
		
		public int getA() {
			return 1;
		}
	}


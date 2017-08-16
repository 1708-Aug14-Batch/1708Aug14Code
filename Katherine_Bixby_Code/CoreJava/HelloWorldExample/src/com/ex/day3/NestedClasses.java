package com.ex.day3;

public class NestedClasses {

	/*
	 * Java allows us to write classes within other classes
	 * there are called nested classes
	 * 
	 * Benefits:
	 * - logical grouping of classes only used in one place
	 * - increases encapsulation
	 * - more readable and maintainable code
	 * 
	 * Types:
	 * - static - declared as a static member of another class
	 */
	int a = 0;
	static int b = 0;
	
	static class StaticClass{
		void message() {
			System.out.println("Hi, I am in my inner class");
			System.out.println(b);
		}
	}
	class MemberClass{
		void message() {
			System.out.println("Hi, I am in my member class");
			System.out.println(a+b);
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println("Inside main method");
		class LocalClass{
			void message() {
				System.out.println("Inside local class");
				System.out.println(b);
			}
		}
		
	}
	MyInterface AnonClass = new MyInterface() {
		public void doThings(){
			System.out.println("doing things");
		}
		public void doOtherThings() {
			System.out.println("doing other things");
		}
	};
	
	
	

	
	
	
	
}



interface MyInterface{
	void doThings();
	void doOtherThings();
}


class Other{
	int a;
	String message;
	public int getA() {
		return a;
	}
}

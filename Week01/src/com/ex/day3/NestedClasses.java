package com.ex.day3;

public class NestedClasses {
	/*
	 * java allows us to write 
	 * classes within other classes. These 
	 * are called nested classes.
	 * 
	 * Benefits:
	 * 	-logical grouping of classes only used in one place
	 * 	-increases encapsulation
	 * 	-more readable and maintainable code
	 * 
	 * Types:
	 * 	-static - declared as a static member of another class
	 */
	
	int a = 0;
	static int b = 0;
	
	// nested class
	static class StaticClass {
		void message() {
			System.out.println("I'm an static inner class");
			System.out.println(b);
		}
	}
	
	// member inner class
	class MemberClass {
		void message() {
			System.out.println("I'm a member inner class");
			System.out.println(a + b);
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Inside main method");
		class localClass {
			void message() {
				System.out.println("Inside local class");
				System.out.println(b);
			}
		}
		StaticClass stat = new StaticClass();
		stat.message();
		NestedClasses nest = new NestedClasses();
		MemberClass mem = nest.new MemberClass();
	}
	
	MyInterface anonClass = new MyInterface() {

		@Override
		public void doThings() {
			System.out.println("doing things");
		}

		@Override
		public void doOtherThings() {
			System.out.println("Doing other things");
		}
	};
}

interface MyInterface {
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
	
}

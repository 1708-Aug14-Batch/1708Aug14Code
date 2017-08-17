package com.ex.day3;

import com.ex.day3.NestedClasses.MemberClass;

public class NestedClasses {
	/*
	 * Java allows us to write classes within other classes; 
	 * these are called nested classes
	 * 
	 * Benefits:
	 * logical grouping of classes only used in one place
	 * increases encapsulation
	 * more readable and maintainable code
	 * 
	 * Types:
	 * static - declared as a static member of another class
	 */
	
	int a = 0;
	static int b = 0;
	
	static class StaticClass {
		void message() {
			System.out.println("I am in my inner class");
			System.out.println(b);
		}
	}
	
	class MemberClass {
		void message() {
			System.out.println("hi i am in my inner class");
			System.out.println(a + b);
		}
	}
	
	public static void main(String[] args) {
		System.out.println("inside main method");
		class localClass{
			void message() {
				System.out.println("inside local class");
				System.out.println(b);
			}
		}
	}
	
	MyInterface  anonClass = new MyInterface() {

		@Override
		public void doThings() {
			// TODO Auto-generated method stub
			System.out.println("Do things!");
			
		}

		@Override
		public void doOtherThings() {
			// TODO Auto-generated method stub
			System.out.println("Do other things!");
		}
		
	};
	//inside of main
	
	StaticClass stat = new StaticClass();
	stat.message();
	
	MemberClass mem = new NestedClasses.MemberClass();
	mem.message();

}

interface MyInterface{
	void doThings();
	void doOtherThings();
}

class Other {
	
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
	MemberClass mc = nested.new MemberClass();
}
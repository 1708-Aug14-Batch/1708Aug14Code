package com.ex.day3;

import com.ex.day3.NestedClasses.MemberClass;

public class NestedClasses {

	//classes within classes
	//benefits:
	//-logical grouping of classes only used in one place
	//-increase encapsulation
	//-more readable and maintainable code
	
	//types:
	//-static
	//-member 
	int a = 0;
	static int b = 0;
	
	static class StaticClass{
		void message() {
			System.out.println("static");
			//both are static, can reference b but not a
			System.out.println(b);
		}
	}
	class MemberClass{
		void message()
		{
			System.out.println("member!");
			//can access both
			System.out.println(a+b);
		}
	}
	
	public static void main(String[] args) {
		System.out.println("main method");
		class localClass
		{
			void message()
			{
				System.out.println("inside local!");
				System.out.println(b);
			}
		}
	
	
	MyInterface anon = new MyInterface() {

		@Override
		public void doThings() {
			System.out.println("doing things");
			
		}

		@Override
		public void doOtherThings() {
			System.out.println("doing other things");
			
		}
		
	};
	StaticClass stat = new StaticClass();
	stat.message();
	
	}
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
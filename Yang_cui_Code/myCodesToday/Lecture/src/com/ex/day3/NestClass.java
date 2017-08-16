package com.ex.day3;

public class NestClass {
	
	int a=0;
	int b=0;
	public static void main(String[] args){
		
	}
	
	MyInterface anonClass=new MyInterface(){

		@Override
		public void doThings() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void doOtherThings() {
			// TODO Auto-generated method stub
			
		}
		
	};
	
	StaticClass stat=new StaticClass();
	stat.message();
	NestedClass.MemberClass mem= new NestedClass.MemberClass();
	mem.message();
}

interface MyInterface{
	public void doThings();
	public void doOtherThings();
}

class Other{
	int a;
	String message;
	
	public int getA(){
		return a;
	}
	
	public void setA(int a){
		this.a=a;
	}
	
	public String getMessage(){
		return message;
	}
	
	public void setMessage(String message){
		this.message=message;
	}
}
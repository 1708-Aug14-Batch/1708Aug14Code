package com.ex.day4;

public class DoMath {
	private static DoMath singleMath = new DoMath( );
	private DoMath(){}
	
	public static DoMath getInstance(){
		return singleMath;
	}
	
	public int add(int a, int b){
		return a+b;
	}
	public int sub(int a, int b){
		return a-b;
	}
	public int mlx(int a, int b){
		return a*b;
	}
	public int div(int a, int b){
		return a/b;
	}
}

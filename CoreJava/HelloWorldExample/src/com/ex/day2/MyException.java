package com.ex.day2;

public class MyException extends Exception{
	
	public String getMessage(){
		return "You've thrown a custom exception!";
	}

}

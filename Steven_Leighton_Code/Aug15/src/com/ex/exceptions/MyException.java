package com.ex.exceptions;

public class MyException extends Exception{

	@Override
	public String getMessage(){
		return "Custom exception thrown";
	}
	
	
}

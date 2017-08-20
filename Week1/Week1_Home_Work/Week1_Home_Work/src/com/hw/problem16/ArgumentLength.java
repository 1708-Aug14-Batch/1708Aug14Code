package com.hw.problem16;

public class ArgumentLength {

	public static void main(String[] args) {
		
		System.out.println("Command line args:");
		
		for (String arg: args){
			System.out.println(arg + " is of length " + arg.length());
		}
	

	}

}

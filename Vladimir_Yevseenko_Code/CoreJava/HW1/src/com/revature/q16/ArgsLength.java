package com.revature.q16;

public class ArgsLength {
	public static void main(String[] args) {
		System.out.println("Cmdline args:");
		for (String arg: args)
			System.out.println(arg + " is of length " + arg.length());
	}
}

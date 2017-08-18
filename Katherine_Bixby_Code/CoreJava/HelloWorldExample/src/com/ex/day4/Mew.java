package com.ex.day4;

public class Mew {

	private static Mew mew = new Mew();
	
	private Mew() {}
	
	public static Mew returnMew() {
		return mew;
	}
	public void noise() {
		System.out.println("Mewww");
	}
	public void peek() {
		System.out.println("                       /\\\r\n" + 
				"                      /  )\r\n" + 
				"                     /   )\r\n" + 
				"                    /    )\r\n" + 
				"                   /     }\r\n" + 
				"                  /     /                   .*.  \r\n" + 
				"                 /    /*\\                  /   \\\r\n" + 
				"                /   ./** \\_~~~~******~~~__/     \\\r\n" + 
				"               /   /(                            \\\r\n" + 
				"              /  / /  ___                         )\r\n" + 
				"             /  / (  /  /\\ \\        / /*****\\      )\r\n" + 
				"            /  / {  (  { \\          /    { |       }\r\n" + 
				"                {    ****^^          ^^******     )");
	}
	
}
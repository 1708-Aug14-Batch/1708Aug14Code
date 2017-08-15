package com.ex.Main;

public class OverridingShirt {
	public static void main(String[] args){
		/*
		 * These lines after the comments represent Polymorphism
		 * Using method overloading by creating an object of the SuperClass and
		 * calling getMaterial Method.
		 */
		Shirt shirt = new Shirt("George", "Cotten", 16.90, "Walmart");
		System.out.println("Shirt is made of: " + shirt.getMaterial());
		//This creates an Object of Subclass and after it call the getMaterial Method
		LeviS le = new LeviS("Levi's","Denim",18.99,"Walmart");
		System.out.println("Shirt is made of: " + le.getMaterial());
		//These line after the comment represent Abstraction
		ShirtAbstract myShirt = new TornShirt();
		myShirt.torn();
		myShirt.repair();
	}
}

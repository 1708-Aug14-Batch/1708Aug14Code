package com.ex.day4;

public class FactoryObject {

	private int idNumber;
	
	FactoryObject(int idNumber) {
		this.idNumber = idNumber;
	}
	
	public void doThing() {
		System.out.println("Object number " + idNumber + " does a thing");
	}
	
}

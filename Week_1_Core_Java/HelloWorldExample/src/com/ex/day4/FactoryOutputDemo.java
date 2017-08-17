package com.ex.day4;

public class FactoryOutputDemo {

	public static void main(String[] args) {
		CreateFactory test = new CreateFactory();
		
		FactoryInterfaceDemo ftd1 = test.getInfo("TEST") ;
			
		ftd1.printInfo();
	

	}

}

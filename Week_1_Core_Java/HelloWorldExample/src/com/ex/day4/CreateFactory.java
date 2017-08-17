package com.ex.day4;

public class CreateFactory {

	public FactoryInterfaceDemo getInfo(String test){
		
		if(test.equalsIgnoreCase("TEST"))
			return new FactoryPrint();
		
		return null;
		
	}
}

package com.ex.day4;

public class FruitFactory {
	
	public Fruit getFruit(String whatFruit){
		
		if(whatFruit==null)
			return null;
		
		if(whatFruit.equalsIgnoreCase("APPLE"))
			return new Apple();
		else if(whatFruit.equalsIgnoreCase("ORANGE"))
			return new Orange();
		else if(whatFruit.equalsIgnoreCase("GRAPE"))
			return new Grape();
		else if(whatFruit.equalsIgnoreCase("H2OMELLON"))
			return new H2OMellon();
		else
			return null;
	}
}

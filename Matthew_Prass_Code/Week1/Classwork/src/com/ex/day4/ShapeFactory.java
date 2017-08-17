package com.ex.day4;


public class ShapeFactory {

	public FactoryShapes getShape(String shapeType)
	{
		if(shapeType == null)
			return null;
		
		if(shapeType.equalsIgnoreCase("CIRCLE"))
			return new Cricle();
		if(shapeType.equalsIgnoreCase("SQUARE"))
			return new Square();
		if(shapeType.equalsIgnoreCase("TRIANGLE"))
			return new Triangle();
		
		return null;
	}
}

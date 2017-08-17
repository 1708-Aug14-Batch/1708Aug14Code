package com.ex.day4;

public class ShapeFactoryDemo {

	public static void main(String[] args) {
		ShapeFactory sf = new ShapeFactory();
		
		FactoryShapes circ = sf.getShape("CIRCLE");
		
		circ.draw();
		
		FactoryShapes tri = sf.getShape("TRIANGLE");
		
		tri.draw();
		
		FactoryShapes sqr = sf.getShape("SQUARE");
		
		sqr.draw();

	}

}

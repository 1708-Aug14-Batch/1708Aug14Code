package com.ex.day4;

public class Factory {
	
	public FactoryObject createObject(int num) {
		return new FactoryObject(num);
	}

}

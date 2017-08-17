package com.ex.day4;

public final class Singleton {
	
	private static final Singleton INSTANCE = new Singleton();
	
	public String TestString;

    private Singleton() {}

    public static Singleton getInstance() {
        return INSTANCE;
    }
    
    public Product factory(int ID) {
    	switch(ID) {
    	case 0:
    		Product one = new Product();
    		one.setName("one");
    		return one;
    	case 1:
    		Product two = new Product();
    		two.setName("two");
    		return two;
    	}
    	return null;
    }
	
}

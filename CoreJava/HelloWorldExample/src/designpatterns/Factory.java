package designpatterns;

import java.util.HashMap;
import java.util.Map;

public class Factory {
	
	private Map<String, Class> register = new HashMap<>();
	
	public void registerProduct(String productId, Class cls) {
		register.put(productId, cls);
	}
	
	
	/*
	public Object createProduct(String productId) {
		switch (productId) {
		case "Object1":
			return new Object();
		case "Object2":
			return new Object();
		case "Object3":
			return new Object();
		default:
		}
		return null;
	}
	*/
}

package designpatterns;

public class Singleton {
	
	private static Singleton instance = null;
	public int count;
	
	private Singleton() {
		count = 0;
	}
	
	public static Singleton getInstance() {
		if (instance == null) instance = new Singleton();
		return instance;
	}
	
	public void hello() {
		System.out.println("Hello, singleton!");
	}
}

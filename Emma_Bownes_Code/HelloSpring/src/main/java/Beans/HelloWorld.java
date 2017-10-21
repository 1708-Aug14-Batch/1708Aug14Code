package Beans;

public class HelloWorld {
	
	private String message;
	private String test;
	
	public HelloWorld() {
		System.out.println("In empty");
	}
	
	
	public HelloWorld(String test) {
		System.out.println(test);
	}
	
	public void setMessage(String message) {
		
		this.message = message;
	}
	
	public void getMessage() {
		System.out.println("Your message: "+this.message);
	}
	
	public void init() {
		System.out.println("Initializing Bean");
	}

	public void destroy() {
		System.out.println("destroying");
	}
}

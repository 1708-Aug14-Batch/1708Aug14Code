package beans;

public class HelloWorld {

	private String message;
	private String text;

	
	
	public HelloWorld() {
		
		System.out.println("Empty arg - HelloWorld");
	}

	public HelloWorld(String text) {
		System.out.println("Text arg - HelloWorld");
	}

	public String getMessage() {
		System.out.println(message);
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void init() {
		System.out.println("init helloworld bean");
	}
	
	public void destroy() {
		System.out.println("destroy helloworld bean");
	}
}

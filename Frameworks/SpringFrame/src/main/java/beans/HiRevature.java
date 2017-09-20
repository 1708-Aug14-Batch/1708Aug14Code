package beans;

public class HiRevature {

	private HelloWorld hello;
	
	
	public HiRevature(HelloWorld hello) {
		super();
		this.hello = hello;
	}

	public void setHello(HelloWorld hello) {
		this.hello = hello;
	}

	public HelloWorld getHello() {
		return hello;
	}
	
	public void getHelloMessage() {
		hello.getMessage();
	}
}

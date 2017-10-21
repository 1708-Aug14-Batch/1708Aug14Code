package Beans;

public class HiRev {

	
	private HelloWorld hello;
	
	
	public HiRev() {
	}
	public HiRev(HelloWorld hello) {
		this.hello = hello;
	}
	
	public void getHelloMessage() {
		hello.getMessage();

	}

	public HelloWorld getHello() {
		return hello;
	}

	public void setHello(HelloWorld hello) {
		this.hello = hello;
	}

	
}

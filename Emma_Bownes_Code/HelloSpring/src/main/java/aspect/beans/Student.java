package aspect.beans;

import org.springframework.stereotype.Component;

@Component
public class Student {
	
	public void cry() {
		
		System.out.println("Genesis is making me miserable. wahh");
		
		
	}
	
	public void exist() {
		
		System.out.println("why are we here");
	}
	
	public void eat() {
		System.out.println("Yum.");
	}

}

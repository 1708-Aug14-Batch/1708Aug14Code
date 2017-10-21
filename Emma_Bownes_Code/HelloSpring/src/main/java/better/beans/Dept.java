package better.beans;

import org.springframework.stereotype.Component;

@Component
public class Dept {
	
	private String name;

	public Dept() {
	}

	public Dept(String desc) {
		this.name = desc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}

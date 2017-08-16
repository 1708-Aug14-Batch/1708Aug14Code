package Q14;

public class Student {
	private String name;
	private String age;
	private String state;
	
	public Student(){
		super();
	}
	public Student(String name, String age, String state){
		super();
		this.name=name;
		this.age=age;
		this.state=state;
	}
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	public String getAge() {
		// TODO Auto-generated method stub
		return this.age;
	}
	
	public String getState() {
		// TODO Auto-generated method stub
		return this.state;
	}
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name=name;
		
	}
	public void setAge(String age) {
		// TODO Auto-generated method stub
		this.age=age;
		
	}
	public void setState(String state) {
		// TODO Auto-generated method stub
		this.state=state;
		
	}
}

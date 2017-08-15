package Q7;

public class Employee {
	private String name;
	private short age;
	private String department;
	
	public Employee(String name, short age, String department) {
		this.name = name;
		this.age = age;
		this.department = department;
	}
	
	public String getName() { return name; }
	public short getAge() { return age; }
	public String getDepartment() { return department; }
	
	public void setName(String name) { this.name = name; }
	public void setAge(short age) { this.age = age; }
	public void setDepartment(String department) { this.department = department; }
}

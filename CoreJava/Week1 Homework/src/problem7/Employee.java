package problem7;

public class Employee {

	private String fname;
	private String lname;
	private String dept;
	private int age;
	
	
	public Employee(String fname, String lname, String dept, int age) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.dept = dept;
		this.age = age;
	}
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [fname=" + fname + ", lname=" + lname + ", dept=" + dept + ", age=" + age + "]";
	}
	
	
}

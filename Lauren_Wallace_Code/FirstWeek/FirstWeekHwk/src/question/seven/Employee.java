package question.seven;

public class Employee implements Comparable {
	
	private String name;
	private String dept;
	private int age;
	
	public Employee() {
		this.name = "Generic person";
		this.dept = "Health sector";
		this.age = 18;
	}
	
	public Employee(String name, String dept, int age) {
		this.name = name;
		this.dept = dept;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	public int compareToName(Employee emp) {
		if(this.name == emp.name) {
			return 0;
		}
		return this.name.charAt(0) > emp.name.charAt(0) ? 1:-1;
	}
	
	public int compareToDept(Employee emp) {
		if(this.dept == emp.dept) {
			return 0;
		}
		return this.dept.charAt(0) > emp.dept.charAt(0) ? 1:-1;
	}

	public int compareToAge(Employee emp) {
		if(this.age == emp.age) {
			return 0;
		}
		return this.age > emp.age ? 1:-1;
	}

}

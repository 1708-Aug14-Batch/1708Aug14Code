package Q7;

public class Employee implements Comparable<Employee>{
	private String name;
	private String department;
	private int age;
	
	public Employee(String name, String department, int age){
		this.name=name;
		this.department=department;
		this.age=age;
	}
	
	public String getName(){
		return name;
	}
	
	public String getDepartment(){
		return department;
	}
	
	public int getAge(){
		return age;
	}

	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		if((this.name).compareTo(o.name)==0)
			if((this.department).compareTo(o.department)==0)
				if(this.age>=o.age)
					return 1;
				else
					return -1;
			else if((this.department).compareTo(o.department)<0)
				return -1;
			else
				return 1;
		else if((this.name).compareTo(o.name)<0)
			return -1;
		else
			return 1;
	}
}

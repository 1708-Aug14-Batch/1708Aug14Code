package question.seven;

public class SortWithComparingInterface {

	public static void main(String[] args) {
		
		Employee emp1 = new Employee("James", "Computer Science", 20);
		Employee emp2 = new Employee("James", "Mathematics", 25);
		
		Employee emp3 = new Employee("Abby", "Music", 30);
		Employee emp4 = new Employee("Rowan", "Mathematics", 26);
		
		Employee emp5 = new Employee("Zach", "Liberal Arts", 23);
		Employee emp6 = new Employee("Nicole", "Physical Education", 23);
		
		//sorts using the result from the compareTo method that I overloaded for emp1 & emp2
		sortByNameLeastToGreat(emp1, emp2);
		sortByDeptLeastToGreat(emp1, emp2);
		sortByAgeLeastToGreat(emp1, emp2);
		
		System.out.println();
		
		//sorts using the result from the compareTo method that I overloaded for emp1 & emp5
		sortByNameLeastToGreat(emp1, emp5);
		sortByDeptLeastToGreat(emp1, emp5);
		sortByAgeLeastToGreat(emp1, emp5);
		
		System.out.println();
		
		//sorts using the result from the compareTo method that I overloaded for emp3 & emp4
		sortByNameLeastToGreat(emp3, emp4);
		sortByDeptLeastToGreat(emp3, emp4);
		sortByAgeLeastToGreat(emp3, emp4);
		
		System.out.println();
		
		//sorts using the result from the compareTo method that I overloaded for emp4 & emp5
		sortByNameLeastToGreat(emp4, emp5);
		sortByDeptLeastToGreat(emp4, emp5);
		sortByAgeLeastToGreat(emp4, emp5);
		
		System.out.println();
		
		//sorts using the result from the compareTo method that I overloaded for emp4 & emp5
		sortByNameLeastToGreat(emp5, emp6);
		sortByDeptLeastToGreat(emp5, emp6);
		sortByAgeLeastToGreat(emp5, emp6);
		
		//This alphabet is to check that the compareTo name works
		//String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

	}
	
	//prints the Employee names based on the sort
	static void sortByNameLeastToGreat(Employee emp1, Employee emp2) {
		int result = emp1.compareToName(emp2);
		switch(result) {
		case -1: System.out.println(emp1.getName());
				 System.out.println(emp2.getName());
				 break;
		case 0: System.out.println(emp1.getName() + " " + emp2.getName());
				break;
		case 1: System.out.println(emp2.getName());
				System.out.println(emp1.getName());
				break;
		}
	}
	
	//prints the Employee age based on the sort
	static void sortByAgeLeastToGreat(Employee emp1, Employee emp2) {
		int result = emp1.compareToAge(emp2);
		switch(result) {
		case -1: System.out.println(emp1.getAge());
				 System.out.println(emp2.getAge());
				 break;
		case 0: System.out.println(emp1.getAge() + " " + emp2.getAge());
				break;
		case 1: System.out.println(emp2.getAge());
				System.out.println(emp1.getAge());
				break;
		}
	}
	
	//prints the Employee department based on the sort
	static void sortByDeptLeastToGreat(Employee emp1, Employee emp2) {
		int result = emp1.compareToDept(emp2);
		switch(result) {
		case -1: System.out.println(emp1.getDept());
				 System.out.println(emp2.getDept());
				 break;
		case 0: System.out.println(emp1.getDept() + " " + emp2.getDept());
				break;
		case 1: System.out.println(emp2.getDept());
				System.out.println(emp1.getDept());
				break;
		}
	}

}

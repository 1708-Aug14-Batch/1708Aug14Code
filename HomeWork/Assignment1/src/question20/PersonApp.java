package question20;

import java.util.ArrayList;

public class PersonApp {
	static PersonIO io;
	/*public static void getPerson(){
		io = new PersonIO();
		ArrayList<Person> list = io.readPerson();
		for(Person s: list ){
			System.out.println(s.toString());
		}*/

	public static void main(String[] args) {
		
			PersonIO io = new PersonIO();
			
		 ArrayList<Person> newPerson = io.readPerson();
		for(Person i: newPerson){
			System.out.println("Name:   " + i.getMyFirstName() + i.getMyLastName());
			System.out.println("Age:    " + i.getMyAge() + " years" );
			System.out.println("State:  " + i.getMyState()+ "\n");
		}
			
	}
}

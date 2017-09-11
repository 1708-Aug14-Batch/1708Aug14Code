package Q20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {
	// Write a program that would read from the file and print it out to the screen in the following format:
	// Name: Mickey Mouse
	// Age: 35 years
	// State: Arizona State

	static String filename = "src/com/ex/files/Data.txt";
	
	public static void main(String[] args) {
		ArrayList<Person> person = new ArrayList();
		person = getAllPersons();
		for(Person p:person) {
			System.out.println("Name: " + p.getFirstName() + " " + p.getLastName());
			System.out.println("Age: " + p.getAge() + " years");
			System.out.println("State: " + p.getState() + " State");
			System.out.println();
		}
	}
	
	public static ArrayList<Person> getAllPersons() {
		ArrayList<Person> list = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(filename));) {
			String line = null;
			while ((line = br.readLine()) != null) {
					Person person = new Person();
					String[] temp = line.split(":");
					person.setFirstName(temp[0]);
					person.setLastName(temp[1]);
					person.setAge(temp[2]);
					person.setState(temp[3]);
					list.add(person);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
}

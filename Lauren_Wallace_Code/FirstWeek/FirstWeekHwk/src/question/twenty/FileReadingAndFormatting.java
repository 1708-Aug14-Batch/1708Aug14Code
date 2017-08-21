package question.twenty;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileReadingAndFormatting {

	public static void main(String[] args) {
		
		String filename = "src/com/ex/files/Data.txt";
		
		ArrayList<Person> list = new ArrayList<Person>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
			
			String line = null;
			while((line = br.readLine()) != null) {
				Person temp = new Person();
				//.split takes in a regular expression
				String[] states = line.split(":");
				temp.setFname(states[0]);
				temp.setLname(states[1]);
				temp.setAge(Integer.parseInt(states[2]));
				temp.setArea(states[3]);
				list.add(temp);
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		for(Person p: list) {
			System.out.println("Name: " + p.getFname() + " " + p.getLname());
			System.out.println("Age: " + p.getAge() + " years");
			System.out.println("State: " + p.getArea() + " state");
			System.out.println();
		}
	}

}

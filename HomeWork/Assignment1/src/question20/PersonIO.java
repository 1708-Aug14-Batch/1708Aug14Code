package question20;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PersonIO {
	static String filename =  "resources/data.txt";
	public void writePerson(ArrayList<Person> personList){

		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename))){

			for(Person somePerson : personList) {
				String text = "";
				text = text.concat("Name: " + somePerson.getMyFirstName() + "\n");
				text = text.concat("Name: " + somePerson.getMyLastName() + "\n");
				text = text.concat("Age: " + somePerson.getMyAge() + "\n");
				text = text.concat("State" + somePerson.getMyState());

				bw.write(text);
				bw.newLine();
				bw.flush();
			}
		} catch(IOException e){
			e.printStackTrace();
		}
	}
	public ArrayList<Person> readPerson(){
		ArrayList<Person> list = new ArrayList<Person>();

		try(BufferedReader br = new BufferedReader(new FileReader(filename));){

			String line = null;

			while ((line = br.readLine()) != null){
				if(line.equals("")) {
					continue;
				}
				Person temp = new Person();
				String[] states = line.split(":");
				temp.setMyFirstName(states[0]);
				temp.setMyLastName(states[1]);
				temp.setMyAge(states[2]);
				temp.setMyState(states[3]);
				list.add(temp);
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}

		return list;
	}


}
package com.ex.day3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class StudentIO {

	static String filename = "src/com/ex/files/students.txt";

	public void writeStudents(Student s){
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))){
			String text ="";

			//define format
			text+=s.getFirstname()+":";
			text+=s.getLastname()+":";
			text+=s.getEmail()+"\n";

			bw.write(text);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<Student> getStudents(){

		ArrayList<Student> list = new ArrayList<Student>();

		try(BufferedReader br = new BufferedReader(new FileReader(filename))){

			String line = null;
			while( (line=br.readLine()) != null){
				Student temp = new Student();
				String[] states = line.split(":");
				temp.setFirstname(states[0]);
				temp.setLastname(states[1]);
				temp.setEmail(states[2]);

				list.add(temp);
			}


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public void addAllStudents(ArrayList<Student> students) {

		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, false))){

			for(Student s : students){
				String text ="";

				//define format
				text+=s.getFirstname()+":";
				text+=s.getLastname()+":";
				text+=s.getEmail()+"\n";

				bw.write(text);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}

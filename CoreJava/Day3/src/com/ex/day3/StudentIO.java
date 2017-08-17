package com.ex.day3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class StudentIO {
	static String filename = "src/com/ex/files/students.txt";
	static String tempFile = "src/com/ex/files/temp.txt";
	
	public void writeStudent(Student s) {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true));) {
			String text = "";
			
			text = text.concat(s.getFirstName() +":");
			text = text.concat(s.getLastName() + ":" );
			text = text.concat(s.getEmail() + "\n");
			
			bw.write(text);
			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Student> readStudents() {
		ArrayList<Student> list = new ArrayList<>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(filename));) {
			String line = null;
			while((line = br.readLine()) != null) {
				Student temp = new Student();
				String[] states = line.split(":");
				temp.setFirstName(states[0]);
				temp.setLastName(states[1]);
				temp.setEmail(states[2]);
				list.add(temp);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void deleteFile() {
		new File(filename).delete();
	}

	public void updateStudent() {
		
	}
}







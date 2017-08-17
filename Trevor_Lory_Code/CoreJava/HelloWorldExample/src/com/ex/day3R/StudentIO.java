package com.ex.day3R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.ex.pojos.Student;

public class StudentIO {

	static String filename = "src/com/ex/files/students.txt";
	
	public void writeStudent (Student s) {
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))) {
			String text = "";
			text = text.concat(s.getFirstname() + ":");
			text = text.concat(s.getLastname() + ":");
			text = text.concat(s.getEmail() + "\n");
			bw.write(text);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
public void writeStudent (ArrayList<Student> s, boolean b) {
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, b))) {
			for(Student stu: s) {
				String text = "";
				text = text.concat(stu.getFirstname() + ":");
				text = text.concat(stu.getLastname() + ":");
				text = text.concat(stu.getEmail() + "\n");
				bw.write(text);
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Student> readStudents() {
		ArrayList<Student> list = new ArrayList<Student>();
		try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line = null;
			while((line=br.readLine()) != null) {
				String[] params = line.split(":");
				Student temp = new Student(params[0], params[1], params[2]);
				list.add(temp);
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}

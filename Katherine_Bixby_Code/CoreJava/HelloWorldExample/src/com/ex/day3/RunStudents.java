package com.ex.day3;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import com.ex.pojos.Student;

public class RunStudents {
	
	static StudentIO io;
	
	public static void main(String[] args) {
		//changeStudent();
		exterminateStudent();
	}
	
	static void addStudent() {
		io = new StudentIO();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your first name: ");
		String fn = scan.nextLine().trim();
		System.out.println("Enter your last name: ");
		String ln = scan.nextLine().trim();
		System.out.println("Enter your email: ");
		String email = scan.nextLine().trim();
		Student student = new Student(fn,ln,email);
		io.writeStudent(student);
		scan.close();
	}
	static void getStudents() {
		io = new StudentIO();
		ArrayList<Student> students = io.readStudents();
		for(Student s:students) {
			System.out.println(s.toString());
		}
	}
	static void changeStudent() {
		io = new StudentIO();
		ArrayList<Student> theStudents = io.readStudents();
		theStudents = io.updateStudent(theStudents);
		String filename="src/com/ex/day3/students.txt";
		try {
			PrintWriter pw = new PrintWriter(filename);
			pw.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int i=0;i<theStudents.size();i++) {
			try(BufferedWriter bw = 
					new BufferedWriter(new FileWriter(filename,true))) {
				String text = "";
				text = text.concat(theStudents.get(i).getFirstName()+":");
				text = text.concat(theStudents.get(i).getLastName()+":");
				text = text.concat(theStudents.get(i).getEmail()+"\n");
				
				bw.write(text);
			}catch(IOException e){
				e.printStackTrace();
			}
		}	
	}
	static void exterminateStudent() {
		io = new StudentIO();
		ArrayList<Student> theStudents = io.readStudents();
		theStudents = io.deleteStudent(theStudents);
		String filename = "src/com/ex/day3/students.txt";
		try {
			PrintWriter pw = new PrintWriter(filename);
			pw.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int i=0;i<theStudents.size();i++) {
			try(BufferedWriter bw = 
					new BufferedWriter(new FileWriter(filename,true))) {
				String text = "";
				text = text.concat(theStudents.get(i).getFirstName()+":");
				text = text.concat(theStudents.get(i).getLastName()+":");
				text = text.concat(theStudents.get(i).getEmail()+"\n");
				
				bw.write(text);
			}catch(IOException e){
				e.printStackTrace();
			}
		}	
	}
	
}

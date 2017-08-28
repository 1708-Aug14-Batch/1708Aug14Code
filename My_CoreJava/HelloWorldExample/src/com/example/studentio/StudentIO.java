package com.example.studentio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentIO {

	public static final String FILENAME = "src/com/example/studentio/students.txt";
	
	public static void writeStudent(Student s) {
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME, true))) {
			
			String text = "";
			text += s.getFirst() + ':';
			text += s.getLast() + ':';
			text += s.getEmail() + '\n';
			
			bw.write(text);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Student> readStudents() {
		ArrayList<Student> students = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
			
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] props = line.split(":");
				if (props.length != 3) continue;
				students.add(new Student(props[0], props[1], props[2]));
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return students;
	}
	
	public static void addStudent() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter your first name: ");
		String first = scan.nextLine();
		System.out.println("Enter your last name: ");
		String last = scan.nextLine();
		System.out.println("Enter your email: ");
		String email = scan.nextLine();
		
		scan.close();
			
		writeStudent(new Student(first, last, email));
	}
	
	public static void getStudents() {		
		for (Student s : readStudents()) {
			System.out.println(s);
		}
	}
	
	public static void updateStudent(String toUpdate, String first, String last, String email) {
		if (toUpdate == null || (first == null && last == null && email == null)) return;
		
		Student student = doRemove(toUpdate);
		if (first != null) student.setFirst(first);
		if (last != null) student.setLast(last);
		if (email != null) student.setEmail(email);
		
		writeStudent(student);		
	}
	
	private static Student doRemove(String email) {	
		Student ret = null;
		for (Student s : readStudents()) {
			File file = new File(FILENAME);
			file.delete();
			if (email.equals(s.getEmail())) {
				ret = s;
			}
			else {
				writeStudent(s);
			}
		}
		return ret;
	}
	
	public static Student removeStudent() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the email of the student you want to remove: ");
		String email = scan.nextLine();
		scan.close();
		
		return doRemove(email);
	}
	
	public static void main(String[] args) {
		
		getStudents();
		
		removeStudent();
		
	}
}

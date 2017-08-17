package com.ex.day3R;

import java.util.ArrayList;
import java.util.Scanner;

import com.ex.pojos.Student;

public class RunStudents {

	static StudentIO io;
	
	public static void main(String[] args) {
		//addStudent();
		//getStudents();
		//deleteStudent();
		updateStudent();
	}
	
	static void addStudent() {
		io = new StudentIO();
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter your first name: ");
		String fn = scan.nextLine().trim();
		
		System.out.println("Enter your last name: ");
		String ln = scan.nextLine().trim();
		
		System.out.println("Enter your email: ");
		String em = scan.nextLine().trim();
		
		Student s = new Student(fn, ln, em);
		
		io.writeStudent(s);
	}
	
	static void getStudents() {
		io = new StudentIO();
		ArrayList<Student> stu = io.readStudents();
		
		for(Student st : stu) {
			System.out.println(st.toString());
		}
	}
	
	static void deleteStudent() {
		io = new StudentIO();
		ArrayList<Student> stu = io.readStudents();
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Delete Student Info:\nEnter students first name: ");
		String fn = scan.nextLine().trim();
		
		System.out.println("Enter students last name: ");
		String ln = scan.nextLine().trim();
		
		System.out.println("Enter students email: ");
		String em = scan.nextLine().trim();
		
		for(Student s : stu) {
			if(s.getFirstname().equals(fn) && s.getLastname().equals(ln) && s.getEmail().equals(em)) {
				stu.remove(s);
			}
		}
		
		io.writeStudent(stu, false);
	}
	
	static void updateStudent() {
		io = new StudentIO();
		ArrayList<Student> stu = io.readStudents();
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Update Student Info:\nEnter students first name: ");
		String fn = scan.nextLine().trim();
		
		System.out.println("Enter students last name: ");
		String ln = scan.nextLine().trim();
		
		System.out.println("Enter students email: ");
		String em = scan.nextLine().trim();
		
		
		System.out.println("change that Students Info:\nEnter students first name: ");
		String fn2 = scan.nextLine().trim();
		
		System.out.println("Enter students last name: ");
		String ln2 = scan.nextLine().trim();
		
		System.out.println("Enter students email: ");
		String em2 = scan.nextLine().trim();
		
		for(Student s : stu) {
			if(s.getFirstname().equals(fn) && s.getLastname().equals(ln) && s.getEmail().equals(em)) {
				s.setFirstname(fn2);
				s.setLastname(ln2);
				s.setEmail(em2);
			}
		}
		
		io.writeStudent(stu, false);
	}
}

package com.ex.day3;

import java.util.ArrayList;
import java.util.Scanner;

import com.ex.pojos.Student;

public class RunStudents {
	
	static StudentIO io; //Made instance variable of StudentIO to initialize in each method

	public static void main(String[] args) {
		int choice = 0;
		Scanner input = new Scanner(System.in);
		//StudentIO io = new StudentIO(); //Using StudentIO.java for writing the object to a file.
		
		System.out.println("1 to add, 2 to update, 3 to delete"); //Getting user choice for adding, updating or deleting
		choice = input.nextInt();
		if(choice == 1) { //Add the student with choice 1
			addStudent();
		}
		else if(choice == 2) { //Change the student with choice 2. Get the user input for what they want changed
			System.out.println("1 for Firstname, 2 for lastname, 3 for Email");
			choice = input.nextInt();
			changeStudents(choice);
			
		}
		else if(choice == 3) { //Delete the student with 3
			deleteStudents();
		}


	}

	static void addStudent() { //The Add student function
		io = new StudentIO();
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter your first name: ");
		String fn = input.nextLine().trim(); //.trim() is used to cut off any whitespaces used while typing
		System.out.println("Enter your last name: ");
		String ln = input.nextLine().trim();
		System.out.println("enter your email: ");
		String em = input.nextLine().trim();
		
		Student student = new Student(fn,ln,em); //Creating a student object and feeding it the recently inputted variables
		
		io.writeStudent(student);
	}
	static void getStudents() { //The get students function
		io = new StudentIO();
		ArrayList<Student> students = io.readStudents();
		for(Student s: students) {
			System.out.println(s.toString());
		}
	}
	static void changeStudents(int num) { // The change students function
		io = new StudentIO(); //Create a new StudentIO object
		Scanner input = new Scanner(System.in); //Bring in the scanner for input
		String temp; //Temp value used for storing the email used in the search
		
		
		ArrayList<Student> students = io.readStudents(); //Bringing in the students from the IO file
		System.out.println("Enter the email of the person you want to change: "); //Get the email the user wants to search for
		temp = input.nextLine().trim();
		
		
		for(Student s: students) { //Enchanced for loop stepping through the students ArrayList
			/*
			 * The following runs depending on the value given in the main function.
			 * If the choice was 1 the user will input a new first name.
			 * 2 for last name, and 3 for email.
			 * It will then step through the loop and check to see if the email is present.
			 * If it is, then it will change and then run the updateStudents function in the IO
			 */
			if(num == 1) { 
				if(s.getEmail().contains(temp)) {
					System.out.println("Enter the new first name: ");
					String str = input.nextLine().trim();
					s.setFirstname(str);
					io.updateStudents(students);
					}
				}
			else if(num == 2) {
				if(s.getEmail().contains(temp)) {
					System.out.println("Enter the new last name: ");
					String str = input.nextLine().trim();
					s.setLastname(str);
					io.updateStudents(students);
					}
				}
			else if(num == 3) {
				if(s.getEmail().contains(temp)) {
					System.out.println("Enter the new email: ");
					String str = input.nextLine().trim();
					s.setEmail(str);
					io.updateStudents(students);
					}
				}
			}
		}
	static void deleteStudents() { //DeleteStudents method
		/*
		 * Same as the above code, except there is no user choice to bring down as there is only one thing to do here
		 * After getting the email it steps through an enhanced for loop to see if the email is present
		 * If so, it sets the values to "" or default.
		 */
		
		io = new StudentIO();
		Scanner input = new Scanner(System.in);
		String temp;
		
		
		ArrayList<Student> students = io.readStudents();
		System.out.println("Enter the email of the person you want to delete: ");
		temp = input.nextLine().trim();
		
		for(Student s: students) {
			if(s.getEmail().equals(temp)) {
				s.setFirstname("");
				s.setLastname("");
				s.setEmail("");
				io.updateStudents(students);
			}
		}
	}
			}
		
	


			
	


package com.revature.student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class StudentIO {
	public void writeStudent(String path, Student s) {
		try (BufferedWriter w = new BufferedWriter(new FileWriter(path, true))) {
			w.write(s.getFirst() + ":" + s.getLast() + ":" + s.getEmail() + "\n");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public void writeStudents(String path, Student[] st) {
		try (BufferedWriter w = new BufferedWriter(new FileWriter(path, true))) {
			for (Student s: st)
				w.write(s.getFirst() + ":" + s.getLast() + ":" + s.getEmail() + "\n");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public ArrayList<Student> readStudents(String path) {
		try (BufferedReader r = new BufferedReader(new FileReader(path))) {
			ArrayList<Student> students = new ArrayList<>();
			String line;
			while ((line = r.readLine()) != null) {
				String[] split = line.split(":");
				students.add(new Student(split[0], split[1], split[2]));
			}
			return students;
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	
	public void removeStudent(String path, Student s) throws NoSuchElementException {
		ArrayList<Student> students = readStudents(path);
		if (!students.remove(s))
			throw new NoSuchElementException();
		try (BufferedWriter w = new BufferedWriter(new FileWriter(path, false))) {
			for (Student student: students)
				w.write(student.getFirst() + ":" + student.getLast() + ":" + student.getEmail() + "\n");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	
	public void replaceStudent(String path, Student replaced, Student replacee) throws NoSuchElementException {
		ArrayList<Student> students = readStudents(path);
		int idx = students.indexOf(replaced);
		if (!students.remove(replaced))
			throw new NoSuchElementException();
		students.add(idx, replacee);
		try (BufferedWriter w = new BufferedWriter(new FileWriter(path, false))) {
			for (Student student: students)
				w.write(student.getFirst() + ":" + student.getLast() + ":" + student.getEmail() + "\n");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}

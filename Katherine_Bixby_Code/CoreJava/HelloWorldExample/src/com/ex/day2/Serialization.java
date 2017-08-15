package com.ex.day2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.ex.pojos.Honda;

public class Serialization {

	static String filename = "src/com/ex/day2/bytestream.txt";
	public static void main(String[] args) {
//		Honda honda = new Honda();
//		honda.setDescription("This honda is amazing. 5/5 woo");
//		honda.setModel("some new one");
//		honda.setMpg(10000);
//		writeObject(honda);
		
		Honda h = (Honda) readObject();
		System.out.println(h);
		
	}
	static void writeObject(Object obj) {
		try(ObjectOutputStream oos = 
				new ObjectOutputStream(
						new FileOutputStream(filename))){
			oos.writeObject(obj);
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	static Object readObject() {
		Object obj = null;
		try(ObjectInputStream ois =
				new ObjectInputStream(
						new FileInputStream(filename))){
			obj = ois.readObject();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return obj;
	}
}

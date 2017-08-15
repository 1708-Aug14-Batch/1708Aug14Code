package com.ex.Ser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.ex.pojos.Tesla;

public class Serialization {

	static String file = "src/com/ex/files/bytestream.txt";
	
	public static void main(String[] args) {
		Tesla tesla = new Tesla();
		tesla.setDescription("This Tesla is amazing! 5/7 would ride again!");
		tesla.setModel("One with Electricity power");
		tesla.setMpg(0);
		
		//writeObject(tesla);
		
		Tesla t = (Tesla) readObject();
		System.out.println(t.getDescription());
	}
	
	static void writeObject(Object o) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
			oos.writeObject(o);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static Object readObject() {
		Object obj = null;
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
			obj = ois.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
}

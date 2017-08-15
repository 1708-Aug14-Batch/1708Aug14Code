package com.ex.day2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.x.pogos.Honda;

public class Serialization {
	static String filename = "src/com/ex/files/bytestream2.txt";
	public static void main(String[] args) {
		
		//Honda honda = new Honda();
		//honda.setDescription("ah-may-zing");
		//honda.setModel("some new one idk");
		//honda.setMpg(10000);
		
		//writeObject(honda);
		Honda h = (Honda)readObject();
		System.out.println(h.getModel());
	}
	
	static void writeObject(Object o)
	{
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename)))
		{
			oos.writeObject(o);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	static Object readObject()
	{
		Object obj = null;
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename)))
		{
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

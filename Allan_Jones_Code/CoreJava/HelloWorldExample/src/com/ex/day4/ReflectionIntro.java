package com.ex.day4;

import java.lang.reflect.Field;

public class ReflectionIntro {
	
	public static void main(String[] args) {

		String var = "Foo";
		
		System.out.println("value: " + var);
		
		Class<String> string = String.class;
		
		try {
			Field field = string.getDeclaredField("value");
			field.setAccessible(true);
			field.set(var, "different".toCharArray());
			System.out.println("New value: " + var);
			System.out.println("Foo");
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Integer in = 1;
		
		System.out.println("value " + in);
		
		Class<Integer> integer = Integer.class;
		
		int i = 1;
		
		try{
			
			Field field = integer.getDeclaredField("value");
			field.setAccessible(true);
			field.set(in, 2);
			System.out.println("New value: " + in);
			System.out.println((Integer)i + (Integer)i);
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		
		System.out.println(add(1, 1));
		
	}
	
	public static Integer add(Integer a, Integer b){
		
		return a+b;
		
	}


}

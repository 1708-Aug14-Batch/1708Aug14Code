package com.ex.sandbox;

/*
 * Used for testing code and exceptions. For learning purposes only
 */

public class Sandbox {
	
	public static void main(String[] args) {
		implicitCasting();
		
		StringBuilderAndBuffer();
		
		Strings();
	}
	
	public static void implicitCasting() {
		int i1 = 1;
		Integer i2 = 2;
		int i3;
		Integer i4;
		
		i1 += i2;
		i2 += i1;
		
		i3 = i1;
		i3 = i2;
		i4 = i1;
		i4 = i2;
		
		// ERROR
		//float b = 33.32;
		
		System.out.println("No exceptions thrown");
	}
	
	public static void StringBuilderAndBuffer() {
		StringBuffer buf = new StringBuffer("Buffer");
		StringBuilder build = new StringBuilder("Builder");
		
		System.out.println(buf + "\n" + build + "\n");
		
		buf.append(" and stuff");
		build.append(buf);
		
		System.out.println(buf + "\n" + build + "\n");
		
		buf.insert(0, "INSERT");
		build.insert(6, "TEXT");
		
		System.out.println(buf + "\n" + build + "\n");
		
		System.out.println(buf.insert(2, "ADD").append(build).insert(10, "SUBTRACT"));
		System.out.println(build.append("MULTIPLY").insert(3, buf).append("DIVIDE"));
		
		StringBuffer buff2 = new StringBuffer("world");
		StringBuffer buff3 = new StringBuffer("world");
		StringBuilder build2 = new StringBuilder("world");
		StringBuilder build3 = new StringBuilder("world");
		
		System.out.println(buff2 == buff2);
		System.out.println(buff2 == buff3);
		System.out.println(build2 == build3);
		System.out.println(build2 == build3);
		System.out.println(buff2.equals(buff2));
		System.out.println(buff2.equals(buff3));
		System.out.println(buff2.equals(build2));
		System.out.println(buff2.equals(build3));
		System.out.println(buff2.toString() == buff3.toString());
		System.out.println(build2.toString().equals(build3.toString()));
		System.out.println(buff2.toString().equals(build2.toString()));
		System.out.println();
	}
	
	public static void Strings() {
		String s1 = "hello";
		String s2 = "hello";
		String s3 = s1;
		String s4 = "";
		s4 = "hello";
		
		System.out.println(s1 == s2);
		System.out.println(s2 == s3);
		System.out.println(s3 == s4);
		System.out.println(s1.equals(s2));
		System.out.println(s2.equals(s3));
		System.out.println(s3.equals(s4));
		
	}

}
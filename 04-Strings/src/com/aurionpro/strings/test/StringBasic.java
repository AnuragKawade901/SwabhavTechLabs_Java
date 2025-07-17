package com.aurionpro.strings.test;

public class StringBasic {
public static void main(String[] args) {
	String s1 = "hello";
	System.out.println(s1.hashCode());
	String s2 = "hello";
	System.out.println(s2.hashCode());
	System.out.println(s1 == s2);
	
	String s3 = new String("hello");
	String s4 = new String("hello");
	System.out.println(s3.hashCode());
	System.out.println(s4.hashCode());

	System.out.println(s3 == s4);
	String s5 = "hello";
	s5 = s5.concat("world");
	System.out.println(s5);
	
	
	StringBuilder stringbuilder = new StringBuilder("hello");
	System.out.println(stringbuilder);
	
	stringbuilder.append("World");
	System.out.println(stringbuilder);
}
}

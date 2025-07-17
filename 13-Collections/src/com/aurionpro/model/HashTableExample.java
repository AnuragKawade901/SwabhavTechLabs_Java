package com.aurionpro.model;

import java.nio.file.spi.FileSystemProvider;
import java.util.Hashtable;

public class HashTableExample {
public static void main(String[] args) {
	Hashtable<Integer, String> table = new Hashtable<Integer, String>();
	
	//Inserting element
	table.put(1, "A");
	table.put(2, "S");
	table.put(3, "D");
	table.put(4, "F");
	table.put(5, "G");
	table.put(6, "H");
	System.out.println(table);
	
	//putIfAbsent
	table.putIfAbsent(9, "V");
	System.out.println(table);
	
	//get the value as per the object key
	System.out.println(table.get(1));
	
	//removes the object key
	System.out.println(table.remove(9));
	//remove with object key and value
	System.out.println(table.remove(6, "H"));
	
	//contain gives t/f if present as per value or key
	System.out.println(table.containsKey(2));
	System.out.println(table.containsValue("I"));
	//size gives the size of the hashtable
	System.out.println(table.size());
	//tell if the hashtable is emplty or not
	System.out.println(table.isEmpty());
	
	//clear removes everything in the hashtable
	//table.clear();
//	System.out.println(table);
	//gives the key in hashtable
	System.out.println(table.keySet());
	//gives the values in the hashtable
	System.out.println(table.values());
	//replaces the value
	table.replace(1, "A");
	table.replace(1, "A", "M");
	System.out.println(table);
	
	//entrySet()
	System.out.println(table.entrySet());
	//clone
	System.out.println(table.clone()+"Cloned hashtable");

	//equal()
	System.out.println(table.equals(table));
	//hash code
	System.out.println(table.hashCode());

	
}
}

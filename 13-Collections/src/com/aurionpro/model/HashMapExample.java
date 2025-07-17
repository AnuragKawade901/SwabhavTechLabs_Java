package com.aurionpro.model;

import java.util.HashMap;

public class HashMapExample {
	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
		//Inserting element
		map.put(1, "A");
		map.put(2, "S");
		map.put(3, "D");
		map.put(4, "F");
		map.put(5, "G");
		map.put(6, "H");
		System.out.println(map);
		
		//putIfAbsent
		map.putIfAbsent(9, "V");
		System.out.println(map);
		
		//get the value as per the object key
		System.out.println(map.get(1));
		
		//removes the object key
		System.out.println(map.remove(9));
		//remove with object key and value
		System.out.println(map.remove(6, "H"));
		
		//contain gives t/f if present as per value or key
		System.out.println(map.containsKey(2));
		System.out.println(map.containsValue("I"));
		//size gives the size of the hashmap
		System.out.println(map.size());
		//tell if the hashmap is emplty or not
		System.out.println(map.isEmpty());
		
		//clear removes everything in the hashmap
		//map.clear();
//		System.out.println(map);
		//gives the key in hashmap
		System.out.println(map.keySet());
		//gives the values in the hashmap
		System.out.println(map.values());
		//replaces the value
		map.replace(1, "A");
		map.replace(1, "A", "M");
		System.out.println(map);
	}
}

package com.aurionpro.model;

import java.util.LinkedHashMap;

public class LinkedHashMapExample {
	public static void main(String[] args) {
		LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>();

		// Inserting element
		linkedHashMap.put(1, "A");
		linkedHashMap.put(2, "S");
		linkedHashMap.put(7, "D");
		linkedHashMap.put(4, "F");
		linkedHashMap.put(5, "G");
		linkedHashMap.put(6, "H");
		System.out.println(linkedHashMap);

//		// putIfAbsent
//		linkedHashMap.putIfAbsent(9, "V");
//		System.out.println(linkedHashMap);
//
		// get the value as per the object key
		System.out.println(linkedHashMap.get(1));
//
//		// removes the object key
		System.out.println(linkedHashMap.remove(9));
//		// remove with object key and value
		System.out.println(linkedHashMap.remove(6, "H"));
//
//		// contain gives t/f if present as per value or key
		System.out.println(linkedHashMap.containsKey(2));
		System.out.println(linkedHashMap.containsValue("I"));
//		// size gives the size of the hashlinkedHashMap
		System.out.println(linkedHashMap.size());
//		// tell if the hashlinkedHashMap is emplty or not
		System.out.println(linkedHashMap.isEmpty());
//
//		// clear removes everything in the hashlinkedHashMap
//		// linkedHashMap.clear();
////		System.out.println(linkedHashMap);
//		// gives the key in hashlinkedHashMap
		System.out.println(linkedHashMap.keySet());
//		// gives the values in the hashlinkedHashMap
		System.out.println(linkedHashMap.values());
//		// replaces the value
		linkedHashMap.replace(1, "A");
		linkedHashMap.replace(1, "A", "M");
	System.out.println(linkedHashMap);
		
		//getOrDefault
		
		System.out.println(linkedHashMap.getOrDefault(4, "F"));
	}

}

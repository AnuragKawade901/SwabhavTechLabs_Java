package com.aurionpro.model;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayCollections {
	public static void main(String[] args) {
		ArrayList<Integer> marks = new ArrayList<>();
		// add element
		marks.add(1);
		marks.add(2);
		marks.add(4);
		marks.add(6);
		System.out.println(marks);

		// add element as per index
		marks.add(0, 3);
		System.out.println(marks);

		// addAll
		ArrayList<Integer> marks1 = new ArrayList<>();
		marks1.add(5);
		marks1.add(6);
		marks1.addAll(marks);
		System.out.println(marks1);

		// addAll with index
		marks1.addAll(5, marks);
		System.out.println(marks1);

		// addAll aslist
		marks.addAll(Arrays.asList(0, 9, 8, 4, 5, 6));
		System.out.println(marks);

		// remove
		marks.remove(0);
		System.out.println(marks);

		// removeAll
		marks.removeAll(marks1);
		System.out.println(marks);

//	//retainAll
//	marks.retainAll(marks1);
//	System.out.println(marks);

		// size
		System.out.println(marks.size());

		// clear
//	marks.clear();
//	
//	marks.contains(marks1);
//	System.out.println(marks);

		// isEmpty
		System.out.println(marks.isEmpty());

		// hashcode
		System.out.println(marks.hashCode());

		// clone
		System.out.println(marks.clone());

		ArrayList<String> list = new ArrayList<String>();// Creating arraylist
		list.add("Ravi");// Adding object in arraylist
		list.add("Vijay");
		list.add("Ravi");
		list.add("Ajay");
		// using for each
		for (String result : list) {
			System.out.println(result);

		}
		  System.out.println(marks);
		  
		  LinkedList<books>
	}
}

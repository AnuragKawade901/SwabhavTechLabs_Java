package com.aurionpro.student.model;

import java.util.Comparator;

public class NameDescComparator implements Comparator<Student>{

	@Override
	public int compare(Student student1, Student student2) {
		return student2.getName().compareToIgnoreCase(student1.getName());
	}

}

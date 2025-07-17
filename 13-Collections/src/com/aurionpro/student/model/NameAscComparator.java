package com.aurionpro.student.model;

import java.util.Comparator;

public class NameAscComparator implements Comparator<Student>{

	@Override
	public int compare(Student student1, Student student2) {
		return student1.getName().compareToIgnoreCase(student2.getName());
	}

}

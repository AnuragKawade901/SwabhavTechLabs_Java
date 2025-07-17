package com.aurionpro.student.model;

import java.util.Comparator;

public class IDDescComparator implements Comparator<Student>{

	@Override
	public int compare(Student student1, Student student2) {
		return Integer.compare(student2.getId(), student1.getId());
	}

}

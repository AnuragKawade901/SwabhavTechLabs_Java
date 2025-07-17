package com.aurionpro.comparator.model;

public class CandidateNameAge {
	String name;
	int age;

	public CandidateNameAge(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	@Override
	public String toString() {
		return "CandidateNameAge [name=" + name + ", age=" + age + "]";
	}
}

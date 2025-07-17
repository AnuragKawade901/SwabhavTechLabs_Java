package com.aurionpro.polymorphism.model;

import java.util.ArrayList;

public class Attendance {
	ArrayList<String> attendanceList = new ArrayList<>();

	public void markAttendance() {
		attendanceList.add("Genral Attendance Marked");
		System.out.println("General Attendance marked");
	}
	public void markAttendance(String name) {
		attendanceList.add(name);
		
		System.out.println("Attendance marked for: "+name);
	}
	public void markAttendance(String[] names) {
		for(String name : names) {
			attendanceList.add(name);
			
			System.out.println("Attendacne marked for: "+name);
		}
	}
	public void showAttendance() {
		System.out.println("\nAttendance List: ");
		for(String name: attendanceList) {
			System.out.println("-"+name);
		}
	}
}

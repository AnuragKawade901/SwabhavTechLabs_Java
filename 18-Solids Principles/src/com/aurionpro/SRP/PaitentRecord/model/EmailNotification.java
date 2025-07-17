package com.aurionpro.SRP.PaitentRecord.model;

public class EmailNotification {
	public void emailNotification(PatientRecord paitentRecord) {
		System.out.println("Email sent to ---> " + paitentRecord.getPatientEmail());
	}
}

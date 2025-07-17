package com.aurionpro.SRP.PaitentRecord.model;

public class PatientRecord {
	private String patientName;
	private int patientNumber;
	private String doctorName;
	private String patientEmail;
	
	public PatientRecord(String patientName, int patientNumber, String doctorName, String patientEmail) {
		this.patientName = patientName;
		this.doctorName = doctorName;
		this.patientEmail = patientEmail;
		this.patientNumber = patientNumber;		
	}

	public String getPatientName() {
		return patientName;
	}

	public int getPatientNumber() {
		return patientNumber;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public String getPatientEmail() {
		return patientEmail;
	}
	
	
	
}

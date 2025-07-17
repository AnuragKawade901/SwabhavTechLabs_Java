package com.aurionpro.DIP.EcommerceNotification.solution.model;

public class EmailSender implements INotification{

	@Override
	public void send(String message) {
		System.out.println("Email sent: "+message);
		
	}
	
}

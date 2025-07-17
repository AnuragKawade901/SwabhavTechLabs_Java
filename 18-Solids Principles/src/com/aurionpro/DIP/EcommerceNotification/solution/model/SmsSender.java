package com.aurionpro.DIP.EcommerceNotification.solution.model;

public class SmsSender implements INotification{

	@Override
	public void send(String message) {
System.out.println("Sms sent: "+message);		
	}

}

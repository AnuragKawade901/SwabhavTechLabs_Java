package com.aurionpro.DIP.EcommerceNotification.solution.model;

public class WhatsAppSender implements INotification{

	@Override
	public void send(String message) {
		System.out.println("WhatsApp message sent: "+message);		
	}

}

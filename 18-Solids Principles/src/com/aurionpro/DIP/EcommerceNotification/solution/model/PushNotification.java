package com.aurionpro.DIP.EcommerceNotification.solution.model;

public class PushNotification implements INotification{

	@Override
	public void send(String message) {
		System.out.println("Push notifcation sent: "+message);
		
	}

}

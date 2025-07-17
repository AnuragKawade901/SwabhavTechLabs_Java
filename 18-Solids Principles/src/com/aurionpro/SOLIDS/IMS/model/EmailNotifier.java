package com.aurionpro.SOLIDS.IMS.model;

public class EmailNotifier implements INotifier{
	public void send(String message) {
        System.out.println("[EMAIL] Notification sent: " + message);
    }
}

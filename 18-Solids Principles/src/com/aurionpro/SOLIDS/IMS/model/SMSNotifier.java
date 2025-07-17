package com.aurionpro.SOLIDS.IMS.model;

public class SMSNotifier implements INotifier{
    public void send(String message) {
        System.out.println("[SMS] Notification sent: " + message);
    }
}

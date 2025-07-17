package com.aurionpro.DIP.EcommerceNotification.solution.test;

import java.util.Arrays;

import com.aurionpro.DIP.EcommerceNotification.solution.model.EmailSender;
import com.aurionpro.DIP.EcommerceNotification.solution.model.INotification;
import com.aurionpro.DIP.EcommerceNotification.solution.model.OrderService;
import com.aurionpro.DIP.EcommerceNotification.solution.model.PushNotification;
import com.aurionpro.DIP.EcommerceNotification.solution.model.SmsSender;
import com.aurionpro.DIP.EcommerceNotification.solution.model.WhatsAppSender;

public class EcommerceNotificationTest {
public static void main(String[] args) {
	INotification email = new EmailSender();
	INotification sms = new SmsSender();
	INotification push =  new PushNotification();
	INotification whatsapp = new WhatsAppSender();
	
	OrderService orderService = new OrderService(Arrays.asList(email, push, sms, whatsapp));
	orderService.placeOrder("Iphone");
}
}

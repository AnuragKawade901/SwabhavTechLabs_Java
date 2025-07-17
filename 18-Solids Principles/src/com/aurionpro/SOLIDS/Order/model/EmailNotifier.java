package com.aurionpro.SOLIDS.Order.model;

public class EmailNotifier implements Notifier{

	@Override
	public void sendNotification(Order order) {
		System.out.println("Email sent to customer for order: " + order.getProductType());
		
	}

}

package com.aurionpro.DIP.EcommerceNotification.solution.model;

import java.util.List;

public class OrderService {
	private List<INotification> notifiers;
	public OrderService(List<INotification> notifiers) {
        this.notifiers = notifiers;
    }

    public void placeOrder(String orderDetails) {
        System.out.println("Placing order: " + orderDetails);
        notifyAllChannels("Your order for '" + orderDetails + "' has been placed.");
    }

    private void notifyAllChannels(String message) {
        for (INotification notifier : notifiers) {
            notifier.send(message);
        }
}
}


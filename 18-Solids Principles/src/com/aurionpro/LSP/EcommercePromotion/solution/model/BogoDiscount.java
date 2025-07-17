package com.aurionpro.LSP.EcommercePromotion.solution.model;

public class BogoDiscount implements IDiscountStrategy {

	@Override
	public double applyDiscount(Cart cart) {
		double total = 0;
		for (Item item : cart.getItems()) {
			int qty = item.getQuantity();
			int payableQty = qty / 2 + qty % 2; // BOGO: Buy 1 Get 1
			total += payableQty * item.getPrice();
		}
		return total;

	}
}

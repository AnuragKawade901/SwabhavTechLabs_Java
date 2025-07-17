package com.aurionpro.LSP.EcommercePromotion.solution.model;

public class NoDiscount implements IDiscountStrategy{

	@Override
	public double applyDiscount(Cart cart) {
        return cart.getTotalAmount(); 
	}

}

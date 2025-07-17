package com.aurionpro.SOLIDS.IMS.model;

public class ReorderService {
	public void reorder(Product product) {
        System.out.println("Reorder placed for 20 units of '" + product.getName() + "'");
        product.setQuantity(product.getQuantity() + 20);
    }
}

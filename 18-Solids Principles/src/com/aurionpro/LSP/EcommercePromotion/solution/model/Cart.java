package com.aurionpro.LSP.EcommercePromotion.solution.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<Item> items = new ArrayList<>();

	public void addItem(Item item) {
		items.add(item);
	}

	public List<Item> getItems() {
		return items;

	}

	public double getTotalAmount() {
		return items.stream().mapToDouble(Item::getTotal).sum();
	}
}

package com.aurionpro.comparator.model;

import java.util.Comparator;

public class TransactionComparator implements Comparator<Transaction>{
	 @Override
	    public int compare(Transaction t1, Transaction t2) {
	        int amountCompare = Double.compare(t2.getAmount(), t1.getAmount()); // Descending
	        if (amountCompare != 0) return amountCompare;

	        return Integer.compare(t1.getId(), t2.getId()); // Fallback to ID ascending
	    }
}

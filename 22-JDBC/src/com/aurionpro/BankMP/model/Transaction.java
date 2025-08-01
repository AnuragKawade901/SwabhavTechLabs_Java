package com.aurionpro.BankMP.model;

import java.sql.Timestamp;

public class Transaction {
    private int id;
    private Long fromAcc;
    private Long toAcc;
    private double amount;
    private String type;
    private Timestamp timestamp;

    public Transaction(int id, Long fromAcc, Long toAcc, double amount, String type, Timestamp timestamp) {
        this.id = id;
        this.fromAcc = fromAcc;
        this.toAcc = toAcc;
        this.amount = amount;
        this.type = type;
        this.timestamp = timestamp;
    }

	public int getId() {
		return id;
	}

	public Long getFromAcc() {
		return fromAcc;
	}

	public Long getToAcc() {
		return toAcc;
	}

	public double getAmount() {
		return amount;
	}

	public String getType() {
		return type;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFromAcc(Long fromAcc) {
		this.fromAcc = fromAcc;
	}

	public void setToAcc(Long toAcc) {
		this.toAcc = toAcc;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
    
}

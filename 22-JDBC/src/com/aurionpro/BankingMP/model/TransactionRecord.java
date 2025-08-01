package com.aurionpro.BankingMP.model;

import java.sql.Timestamp;

public class TransactionRecord {
    private int id;
    private int accountId;
    private double amount;
    private String type;
    private Timestamp timestamp;
    private Integer relatedAccountId;

    public TransactionRecord(int accountId, double amount, String type, Integer relatedAccountId) {
        this.accountId = accountId;
        this.amount = amount;
        this.type = type;
        this.relatedAccountId = relatedAccountId;
    }

    // Getters and setters (optional if only used for reading)
    public int getAccountId() { return accountId; }
    public double getAmount() { return amount; }
    public String getType() { return type; }
    public Timestamp getTimestamp() { return timestamp; }
    public Integer getRelatedAccountId() { return relatedAccountId; }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
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

	public void setRelatedAccountId(Integer relatedAccountId) {
		this.relatedAccountId = relatedAccountId;
	}
    
    
}

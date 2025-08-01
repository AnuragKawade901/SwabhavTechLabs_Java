package com.aurionpro.BankingMP.model;

public class Account {
	private int id;
    private String name;
    private double balance;
    private String password;
    private String mobile;
    private String email;
    private int pin;

    public Account(int id, String name, double balance, int pin) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.pin = pin;
    }

    public Account(int id, String name, double balance, String password, String mobile, String email, int pin) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.password = password;
        this.mobile = mobile;
        this.email = email;
        this.pin = pin;
    }

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getBalance() {
		return balance;
	}

	public String getPassword() {
		return password;
	}

	public String getMobile() {
		return mobile;
	}

	public String getEmail() {
		return email;
	}

	public int getPin() {
		return pin;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}


}
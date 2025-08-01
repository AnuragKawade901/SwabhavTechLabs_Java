package com.aurionpro.BankMP.model;

public class Customer {
    private String customerId;
    private String name;
    private String surname;
    private String mobile;
    private String email;
    private String password;
    private int pin;

    public Customer(String customerId, String name, String surname, String mobile, String email, String password, int pin) {
        this.customerId = customerId;
        this.name = name;
        this.surname = surname;
        this.mobile = mobile;
        this.email = email;
        this.password = password;
        this.pin = pin;
    }
    // Getters & Setters

	public String getCustomerId() {
		return customerId;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getMobile() {
		return mobile;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public int getPin() {
		return pin;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}
    
}
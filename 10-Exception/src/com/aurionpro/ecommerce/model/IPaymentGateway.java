package com.aurionpro.ecommerce.model;

public interface IPaymentGateway {
	void pay(double amount);
	void refund(double amount);
}
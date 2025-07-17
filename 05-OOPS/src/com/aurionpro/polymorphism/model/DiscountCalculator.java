package com.aurionpro.polymorphism.model;

public class DiscountCalculator {
 public double calculateDiscount(double price) {
	 return price - (price *0.05);
 }
 
 public double calculateDiscount(double price, String coupon) {
	 double discount = coupon.equalsIgnoreCase("SAVE10")?0.10:0.05;
	 return price - (price * discount);
 }
 public double calculateDiscount(double price, String coupon, boolean isMember){
	 double discount = 0.05;
	 if(coupon.equalsIgnoreCase("SAVE10")) {
		 discount = 0.10;
	 }
	 if(isMember) {
		 discount += 0.05;
	 }
	 return price - (price * discount);
 }
}

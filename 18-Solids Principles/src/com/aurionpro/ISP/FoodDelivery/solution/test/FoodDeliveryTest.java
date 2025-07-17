package com.aurionpro.ISP.FoodDelivery.solution.test;

import com.aurionpro.ISP.FoodDelivery.solution.model.CustomerUser;
import com.aurionpro.ISP.FoodDelivery.solution.model.ICustomerOperations;
import com.aurionpro.ISP.FoodDelivery.solution.model.IRestaurantOperations;
import com.aurionpro.ISP.FoodDelivery.solution.model.RestaurantOwner;

public class FoodDeliveryTest {
	 public static void main(String[] args) {
	        ICustomerOperations customer = new CustomerUser();
	        IRestaurantOperations owner = new RestaurantOwner();

	        System.out.println("---- Customer Operations ----");
	        customer.placeOrder();
	        customer.trackOrder();
	        customer.rateDriver();

	        System.out.println("\n---- Restaurant Operations ----");
	        owner.manageRestaurant();
	    }
}

package com.aurionpro.test;

import com.aurionpro.model.Bike;
import com.aurionpro.model.Car;

public class VehicleTest {
	public static void main(String[] args) {
		Car car = new Car();
		Bike bike = new Bike();

		car.start();
		car.features();
		car.stop();

		bike.start();
		bike.features();
		bike.stop();
		
	}
}
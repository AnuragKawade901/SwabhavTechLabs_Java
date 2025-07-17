package com.aurionpro.vehicle.model;

public class Car implements IVehicleControl{
	private boolean isRunning = false;

	@Override
	public void start() {
		if (isRunning) {
			System.out.println("🚗 Car is already running.");
		} else {
			isRunning = true;
			System.out.println("🚗 Car started.");
		}
	}

	@Override
	public void stop() {
		if (!isRunning) {
			System.out.println("🚗 Car is already stopped.");
		} else {
			isRunning = false;
			System.out.println("🚗 Car stopped.");
		}
	}

	@Override
	public void changeGear(int gear) {
		if (!isRunning) {
			System.out.println("❌ Start the car before changing gear.");
			return;
		}
		if (gear < 1 || gear > 6) {
			System.out.println("❌ Car supports gear 1 to 6 only.");
			return;
		}
		System.out.println("🚗 Car changed to gear " + gear);
	}
}

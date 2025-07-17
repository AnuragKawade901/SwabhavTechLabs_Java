package com.aurionpro.vehicle.model;

public class Bike implements IVehicleControl{
	private boolean isRunning = false;

	@Override
	public void start() {
		if (isRunning) {
			System.out.println("🏍️ Bike is already running.");
		} else {
			isRunning = true;
			System.out.println("🏍️ Bike started.");
		}
	}

	@Override
	public void stop() {
		if (!isRunning) {
			System.out.println("🏍️ Bike is already stopped.");
		} else {
			isRunning = false;
			System.out.println("🏍️ Bike stopped.");
		}
	}

	@Override
	public void changeGear(int gear) {
		if (!isRunning) {
			System.out.println("❌ Start the bike before changing gear.");
			return;
		}
		if (gear < 1 || gear > 5) {
			System.out.println("❌ Bike supports gear 1 to 5 only.");
			return;
		}
		System.out.println("🏍️ Bike changed to gear " + gear);
	}
}

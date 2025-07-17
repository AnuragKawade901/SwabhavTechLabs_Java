package com.aurionpro.vehicle.model;

public class Truck implements IVehicleControl{
	private boolean isRunning = false;

	@Override
	public void start() {
		if (isRunning) {
			System.out.println("🚛 Truck is already running.");
		} else {
			isRunning = true;
			System.out.println("🚛 Truck started.");
		}
	}

	@Override
	public void stop() {
		if (!isRunning) {
			System.out.println("🚛 Truck is already stopped.");
		} else {
			isRunning = false;
			System.out.println("🚛 Truck stopped.");
		}
	}

	@Override
	public void changeGear(int gear) {
		if (!isRunning) {
			System.out.println("❌ Start the truck before changing gear.");
			return;
		}
		if (gear < 1 || gear > 8) {
			System.out.println("❌ Truck supports gear 1 to 8 only.");
			return;
		}
		System.out.println("🚛 Truck changed to gear " + gear);
	}
}

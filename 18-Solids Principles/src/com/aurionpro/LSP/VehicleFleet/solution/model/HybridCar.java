package com.aurionpro.LSP.VehicleFleet.solution.model;

public class HybridCar implements IElectricVehicle, IFuelVehicle{

	@Override
	public void start() {
System.out.println("Hybrid Car started");		
	}

	@Override
	public void stop() {
		System.out.println("Hybrid Car stopped");		
		
	}

	@Override
	public void refuel() {
		System.out.println("Hybrid Car reflued");		
		
	}

	@Override
	public void recharge() {
		// TODO Auto-generated method stub
		System.out.println("Hybrid Car recharged");		
	}

}

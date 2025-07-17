package com.aurionpro.LSP.VehicleFleet.solution.model;

public class ElectricCar implements IElectricVehicle {

	@Override
	public void start() {
System.out.println("Electric car Started");		
	}

	@Override
	public void stop() {
System.out.println("Electric car stopped");		
	}

	@Override
	public void recharge() {
System.out.println("Electric car recharged");		
	}

}

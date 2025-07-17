package com.aurionpro.LSP.VehicleFleet.solution.test;

import com.aurionpro.LSP.VehicleFleet.solution.model.ElectricCar;
import com.aurionpro.LSP.VehicleFleet.solution.model.IElectricVehicle;
import com.aurionpro.LSP.VehicleFleet.solution.model.IFuelVehicle;
import com.aurionpro.LSP.VehicleFleet.solution.model.IVehicle;
import com.aurionpro.LSP.VehicleFleet.solution.model.PetrolCar;

public class FleetManagement {
public static void main(String[] args) {
	IFuelVehicle petrol = new PetrolCar();
	IElectricVehicle tesla = new ElectricCar();
	
	 petrol.start();
     petrol.refuel();
     petrol.stop();

     tesla.start();
     tesla.recharge();
     tesla.stop();
     
     IVehicle[] vehicles = { (IVehicle) petrol, (IVehicle) tesla };

     for (IVehicle v : vehicles) {
         v.start();
         v.stop();
     }
}
}

package com.aurionpro.vehicle.test;

import java.util.Scanner;

import com.aurionpro.vehicle.model.Bike;
import com.aurionpro.vehicle.model.Car;
import com.aurionpro.vehicle.model.IVehicleControl;
import com.aurionpro.vehicle.model.Truck;

public class VehicleTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		IVehicleControl[] vehicles = {
			new Car(), new Bike(), new Truck()
		};
		String[] names = { "Car", "Bike", "Truck" };

		while (true) {
			System.out.println("\n ----Vehicle Control System----");
			for (int i = 0; i < names.length; i++) {
				System.out.println((i + 1) + ". " + names[i]);
			}
			System.out.println("4. Exit");
			System.out.print("Choose a vehicle (1-4): ");

			try {
				int choice = Integer.parseInt(scanner.nextLine());

				if (choice == 4) {
					System.out.println(" Exiting Vehicle System.");
					break;
				}

				if (choice < 1 || choice > 4) {
					System.out.println("❌ Invalid option. Try again.");
					continue;
				}

				IVehicleControl vehicle = vehicles[choice - 1];
				String vehicleName = names[choice - 1];
				handleVehicleControl(vehicle, vehicleName, scanner);

			} catch (NumberFormatException e) {
				System.out.println("❌ Please enter a valid numeric choice.");
			}
		}
		scanner.close();
	}

	private static void handleVehicleControl(IVehicleControl vehicle, String name, Scanner scanner) {
		while (true) {
			System.out.println("\n-- " + name + " Control Menu --");
			System.out.println("1. Start");
			System.out.println("2. Stop");
			System.out.println("3. Change Gear");
			System.out.println("4. Go Back");
			System.out.print("Choose action: ");

			try {
				int action = Integer.parseInt(scanner.nextLine());

				switch (action) {
					case 1:
						vehicle.start();
						break;
					case 2:
						vehicle.stop();
						break;
					case 3:
						System.out.print("Enter gear number: ");
						int gear = Integer.parseInt(scanner.nextLine());
						vehicle.changeGear(gear);
						break;
					case 4:
						return;
					default:
						System.out.println("❌ Invalid action.");
				}
			} catch (NumberFormatException e) {
				System.out.println("❌ Enter a valid number.");
			}
		}
	}
}

package com.aurionpro.smarthome.test;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.aurionpro.smarthome.model.Fan;
import com.aurionpro.smarthome.model.IControllable;
import com.aurionpro.smarthome.model.Light;
import com.aurionpro.smarthome.model.Speaker;
import com.aurionpro.smarthome.model.TV;

public class SmartHomeTest2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		IControllable[] devices = { new Light(), new Fan(), new TV(), new Speaker() };
		String[] deviceNames = { "Light", "Fan", "TV", "Speaker" };

		while (true) {
			System.out.println("\n===== Smart Home Controller =====");
			System.out.println("1. Control All Devices");
			System.out.println("2. Control Specific Device");
			System.out.println("3. Exit");
			System.out.print("Choose an option: ");

			try {
				int choice = sc.nextInt();
				sc.nextLine(); // consume newline

				switch (choice) {
					case 1:
						for (int i = 0; i < devices.length; i++) {
							devices[i].turnOn();
							System.out.print(deviceNames[i] + " - Enter mode: ");
							String mode = sc.nextLine();
							devices[i].setMode(mode);
							devices[i].turnOff();
						}
						break;

					case 2:
						controlSpecificDevice(devices, deviceNames, sc);
						break;

					case 3:
						System.out.println("Exiting... Smart Home Controller shutting down.");
						sc.close();
						System.exit(0);

					default:
						System.out.println("❌ Invalid option. Try again.");
				}
			} catch (InputMismatchException e) {
				System.out.println("❌ Invalid input. Please enter a number.");
				sc.nextLine(); // clear the buffer
			}
		}
	}

	private static void controlSpecificDevice(IControllable[] devices, String[] deviceNames, Scanner sc) {
		while (true) {
			System.out.println("\n-- Select a Device to Control --");
			for (int i = 0; i < deviceNames.length; i++) {
				System.out.println((i + 1) + ". " + deviceNames[i]);
			}
			System.out.println((deviceNames.length + 1) + ". Go Back");
			System.out.print("Your choice: ");

			try {
				int deviceChoice = sc.nextInt();
				sc.nextLine(); // consume newline

				if (deviceChoice == deviceNames.length + 1) {
					return; // Go back to main menu
				}

				if (deviceChoice < 1 || deviceChoice > deviceNames.length) {
					System.out.println("❌ Invalid device selection.");
					continue;
				}

				IControllable device = devices[deviceChoice - 1];
				String deviceName = deviceNames[deviceChoice - 1];

				while (true) {
					System.out.println("\n-- " + deviceName + " Control --");
					System.out.println("1. Turn ON");
					System.out.println("2. Set Mode");
					System.out.println("3. Turn OFF");
					System.out.println("4. Go Back");
					System.out.print("Choose action: ");

					int action = sc.nextInt();
					sc.nextLine(); // consume newline

					switch (action) {
						case 1:
							device.turnOn();
							break;
						case 2:
							System.out.print("Enter mode: ");
							String mode = sc.nextLine();
							device.setMode(mode);
							break;
						case 3:
							device.turnOff();
							break;
						case 4:
							return; // Back to device selection
						default:
							System.out.println("❌ Invalid action.");
					}
				}

			} catch (InputMismatchException e) {
				System.out.println("❌ Please enter a number.");
				sc.nextLine(); // clear buffer
			}
		}
	}
}

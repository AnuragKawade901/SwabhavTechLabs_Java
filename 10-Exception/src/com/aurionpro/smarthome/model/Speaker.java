package com.aurionpro.smarthome.model;

public class Speaker implements IControllable {
//	@Override
//	public void turnOn() {
//		System.out.println("Speaker turned ON");
//	}
//
//	@Override
//	public void turnOff() {
//		System.out.println("Speaker turned OFF");
//	}
//
//	@Override
//	public void setMode(String mode) {
//		if (!mode.equalsIgnoreCase("Bass") && !mode.equalsIgnoreCase("Treble")) {
//			System.out.println("Invalid Speaker mode. Defaulting to Bass.");
//			mode = "Bass";
//		}
//		System.out.println("Speaker mode set to: " + mode);
//	}
	private boolean isOn = false;

	@Override
	public void turnOn() {
		isOn = true;
		System.out.println("Speaker turned ON");
	}

	@Override
	public void turnOff() {
		isOn = false;
		System.out.println("Speaker turned OFF");
	}

	@Override
	public void setMode(String mode) {
		if (!isOn) {
			System.out.println("❌ Speaker is OFF. Please turn it ON before setting mode.");
			return;
		}
		if (!mode.equalsIgnoreCase("Bass") && !mode.equalsIgnoreCase("Treble")) {
			System.out.println("Invalid Speaker mode. Defaulting to Bass.");
			mode = "Dim";
		}
		System.out.println("Speaker mode set to: " + mode);
	}

	@Override
	public boolean isDeviceOn() {
		return isOn;
	}

	@Override
	public void setPowerStatus(boolean status) {
		this.isOn = status;
	}
}

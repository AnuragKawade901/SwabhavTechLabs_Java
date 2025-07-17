package com.aurionpro.smarthome.model;

public class TV implements IControllable {
//	@Override
//	public void turnOn() {
//		System.out.println("TV turned ON");
//	}
//
//	@Override
//	public void turnOff() {
//		System.out.println("TV turned OFF");
//	}
//
//	@Override
//	public void setMode(String mode) {
//		if (!mode.equalsIgnoreCase("HD") && !mode.equalsIgnoreCase("4K")) {
//			System.out.println("Invalid TV mode. Defaulting to HD.");
//			mode = "HD";
//		}
//		System.out.println("TV mode set to: " + mode);
//	}
	private boolean isOn = false;

	@Override
	public void turnOn() {
		isOn = true;
		System.out.println("TV turned ON");
	}

	@Override
	public void turnOff() {
		isOn = false;
		System.out.println("TV turned OFF");
	}

	@Override
	public void setMode(String mode) {
		if (!isOn) {
			System.out.println("❌ TV is OFF. Please turn it ON before setting mode.");
			return;
		}
		if (!mode.equalsIgnoreCase("HD") && !mode.equalsIgnoreCase("4K")) {
			System.out.println("Invalid TV mode. Defaulting to HD.");
			mode = "HD";
		}
		System.out.println("TV mode set to: " + mode);
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

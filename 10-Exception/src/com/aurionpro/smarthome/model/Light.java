package com.aurionpro.smarthome.model;

public class Light implements IControllable {
	private boolean isOn = false;

	@Override
	public void turnOn() {
		isOn = true;
		System.out.println("Light turned ON");
	}

	@Override
	public void turnOff() {
		isOn = false;
		System.out.println("Light turned OFF");
	}

	@Override
	public void setMode(String mode) {
		if (!isOn) {
			System.out.println("❌ Light is OFF. Please turn it ON before setting mode.");
			return;
		}
		if (!mode.equalsIgnoreCase("Dim") && !mode.equalsIgnoreCase("Bright")) {
			System.out.println("Invalid Light mode. Defaulting to Dim.");
			mode = "Dim";
		}
		System.out.println("Light mode set to: " + mode);
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

package com.aurionpro.smarthome.model;

public class Fan implements IControllable {
//	@Override
//	public void turnOn() {
//		System.out.println("Fan turned ON");
//	}
//
//	@Override
//	public void turnOff() {
//		System.out.println("Fan turned OFF");
//	}
//
//	@Override
//	public void setMode(String mode) {
//		if (!mode.equalsIgnoreCase("Low") && !mode.equalsIgnoreCase("Medium") && !mode.equalsIgnoreCase("High")) {
//			System.out.println("Invalid Fan mode. Defaulting to Medium.");
//			mode = "Medium";
//		}
//		System.out.println("Fan mode set to: " + mode);
//	}
	private boolean isOn = false;

	@Override
	public void turnOn() {
		isOn = true;
		System.out.println("Fan turned ON");
	}

	@Override
	public void turnOff() {
		isOn = false;
		System.out.println("Fan turned OFF");
	}

	@Override
	public void setMode(String mode) {
		if (!isOn) {
			System.out.println("❌ Fan is OFF. Please turn it ON before setting mode.");
			return;
		}
		if (!mode.equalsIgnoreCase("Low") && !mode.equalsIgnoreCase("Medium") && !mode.equalsIgnoreCase("High")) {
			System.out.println("Invalid Light mode. Defaulting to Medium.");
			mode = "Medium";
		}
		System.out.println("Fan mode set to: " + mode);
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

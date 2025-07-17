package com.aurionpro.smarthome.model;

public interface IControllable {
	void turnOn();

	void turnOff();

	void setMode(String mode);

	boolean isDeviceOn();

	void setPowerStatus(boolean status);
}

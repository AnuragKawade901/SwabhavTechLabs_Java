package com.aurionpro.model;

public class AC implements IRemoteControl{
	@Override
	public void powerOn() {
		System.out.println("AC is on");
	}
	@Override
	public void powerOff() {
		System.out.println("AC is off");
	}

}

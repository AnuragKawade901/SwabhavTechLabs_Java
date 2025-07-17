package com.aurionpro.model;

public class TV implements IRemoteControl{
	
	@Override
	public void powerOn() {
		System.out.println("TV is on");
	}
	@Override
	public void powerOff() {
		System.out.println("TV is off");
	}

}

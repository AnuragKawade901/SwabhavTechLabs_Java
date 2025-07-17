package com.aurionpro.model;

public class Speaker implements IRemoteControl {

    @Override
    public void powerOn() {
        System.out.println("Speaker is now ON");
    }

    @Override
    public void powerOff() {
        System.out.println("Speaker is now OFF");
    }
}

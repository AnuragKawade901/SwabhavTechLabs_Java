package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.AC;
import com.aurionpro.model.IRemoteControl;
import com.aurionpro.model.Speaker;
import com.aurionpro.model.TV;

public class DeviceControlTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IRemoteControl device = null;

        System.out.println("Select a device to control:");
        System.out.println("1. TV");
        System.out.println("2. AC");
        System.out.println("3. Speaker");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                device = new TV();
                break;
            case 2:
                device = new AC();
                break;
            case 3:
                device = new Speaker();
                break;
            default:
                System.out.println("Invalid choice!");
        }

        if (device != null) {
            device.powerOn();
            device.powerOff();
        }

        scanner.close();
    }
}


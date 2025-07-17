package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.IRobot;
import com.aurionpro.model.Speak;
import com.aurionpro.model.Walk;



public class MultipleBehavior {
public static void main(String[] args) {
	 Scanner scanner = new Scanner(System.in);
     IRobot robo = null;

     System.out.println("Select beahviour to control:");
     System.out.println("1. walk");
     System.out.println("2. speak");
     System.out.print("Enter your choice: ");
     int choice = scanner.nextInt();

     switch (choice) {
         case 1:
             robo = new Walk();
             break;
         case 2:
             robo = new Speak();
             break;
         default:
             System.out.println("Invalid choice!");
     }

     if (robo != null) {
         robo.walk();
         robo.speak();
     }

     scanner.close();
 }
}


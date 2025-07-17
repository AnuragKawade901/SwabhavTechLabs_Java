package com.aurionpro.abstraction.test;

import java.util.Scanner;

import com.aurionpro.abstraction.model.Circle;
import com.aurionpro.abstraction.model.Shape;
import com.aurionpro.abstraction.model.Square;
import com.aurionpro.abstraction.model.Triangle;

public class ShapeDrawingTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Shape[] shapes = new Shape[3];

        System.out.println("--- Shape Drawing System ---");
        System.out.println("Options: 1. Circle  2. Square  3. Triangle");

        for (int i = 0; i < shapes.length; i++) {
            System.out.print("Enter shape choice for shape " + (i + 1) + ": ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    shapes[i] = new Circle();
                    break;
                case 2:
                    shapes[i] = new Square();
                    break;
                case 3:
                    shapes[i] = new Triangle();
                    break;
                default:
                    System.out.println("Invalid choice. Defaulting to Circle.");
                    shapes[i] = new Circle();
            }
        }

        System.out.println("\n--- Drawing Shapes ---");
        for (Shape shape : shapes) {
            shape.draw();
        }

        scanner.close();
    }
}

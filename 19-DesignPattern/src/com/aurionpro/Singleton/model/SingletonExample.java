package com.aurionpro.Singleton.model;
class MySingleton {
    // Step 1: Create a private static instance
    private static MySingleton instance;

    // Step 2: Make the constructor private so no one can create objects
    private MySingleton() {
        System.out.println("Singleton instance created.");
    }

    // Step 3: Provide a public static method to get the instance
    public static MySingleton getInstance() {
        if (instance == null) {
            instance = new MySingleton();  // Lazy initialization
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello from Singleton!");
    }
}
public class SingletonExample {
	public static void main(String[] args) {
        MySingleton s1 = MySingleton.getInstance();
        MySingleton s2 = MySingleton.getInstance();

        s1.showMessage();

        // Check if both are the same instance
        System.out.println("s1 and s2 are same: " + (s1 == s2));  // true
    }
}

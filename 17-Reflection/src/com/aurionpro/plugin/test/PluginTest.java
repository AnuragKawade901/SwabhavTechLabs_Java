package com.aurionpro.plugin.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PluginTest {
    public static void main(String[] args) throws Exception {
        // Load the Plugin class
    	Class<?> clazz = Class.forName("com.aurionpro.plugin.model.Plugin");

        // Access the private constructor
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        Object plugin = constructor.newInstance();

        // Set version = 3.1
        Field versionField = clazz.getDeclaredField("version");
        versionField.setAccessible(true);
        versionField.set(plugin, 3.1);

        // Call execute()
        Method executeMethod = clazz.getDeclaredMethod("execute");
        executeMethod.setAccessible(true);
        executeMethod.invoke(plugin);

        // Print version
        System.out.println("Plugin version: " + versionField.get(plugin));
//        
//        // Get Plugin class reference
//        Class<?> c = Class.forName("com.aurionpro.plugin.Plugin");
//        System.out.println("Class name: " + c.getName());
//
//        // Access private constructor
//        Constructor<?> constructor = c.getDeclaredConstructor();
//        constructor.setAccessible(true);
//        Object plugin = constructor.newInstance();
//
//        // Set private field 'version' to 3.1
//        Field versionField = c.getDeclaredField("version");
//        versionField.setAccessible(true);
//        versionField.set(plugin, 3.1);
//
//        // Invoke public method 'execute()'
//        Method method = c.getDeclaredMethod("execute");
//        method.setAccessible(true);
//        method.invoke(plugin);
//
//        // Print the value of 'version'
//        System.out.println("Plugin version: " + versionField.get(plugin));
    }
}


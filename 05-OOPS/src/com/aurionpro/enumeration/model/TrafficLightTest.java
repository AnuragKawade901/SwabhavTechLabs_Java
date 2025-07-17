package com.aurionpro.enumeration.model;

public class TrafficLightTest {

    public static void trafficlight(TrafficLight traffic) {
        switch (traffic) {
            case RED:
                System.out.println("Stop");
                break;
            case YELLOW:
                System.out.println("Caution");
                break;
            case GREEN:
                System.out.println("Go");
                break;
        }
    }

    public static void main(String[] args) {
        trafficlight(TrafficLight.RED);
        trafficlight(TrafficLight.YELLOW);
        trafficlight(TrafficLight.GREEN);
    }
}

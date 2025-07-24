package com.aurionpro.Observer.model;

import java.util.ArrayList;
import java.util.List;

//Observer Interface
interface WeatherObserver {
 void update(float temperature, float humidity);
}

//Subject Interface
interface WeatherStation {
 void addObserver(WeatherObserver o);
 void removeObserver(WeatherObserver o);
 void notifyObservers();
}

//Concrete Subject
class WeatherData implements WeatherStation {
 private List<WeatherObserver> observers = new ArrayList<>();
 private float temperature;
 private float humidity;

 public void addObserver(WeatherObserver o) {
     observers.add(o);
 }

 public void removeObserver(WeatherObserver o) {
     observers.remove(o);
 }

 public void notifyObservers() {
     for (WeatherObserver o : observers) {
         o.update(temperature, humidity);
     }
 }

 // Simulate new weather readings
 public void setMeasurements(float temperature, float humidity) {
     this.temperature = temperature;
     this.humidity = humidity;
     System.out.println("\n🌡️ New weather data: Temp = " + temperature + "°C, Humidity = " + humidity + "%");
     notifyObservers();
 }
}

//Concrete Observers
class PhoneDisplay implements WeatherObserver {
 public void update(float temperature, float humidity) {
     System.out.println("📱 Phone Display: Temp = " + temperature + "°C, Humidity = " + humidity + "%");
 }
}

class TVDisplay implements WeatherObserver {
 public void update(float temperature, float humidity) {
     System.out.println("📺 TV Display: Weather Updated - " + temperature + "°C / " + humidity + "%");
 }
}

class BillboardDisplay implements WeatherObserver {
 public void update(float temperature, float humidity) {
     System.out.println("🪧 Billboard: Now showing " + temperature + "°C and " + humidity + "% humidity.");
 }
}

//Main Class
public class WeatherApp {
 public static void main(String[] args) {
     WeatherData station = new WeatherData();

     WeatherObserver phone = new PhoneDisplay();
     WeatherObserver tv = new TVDisplay();
     WeatherObserver billboard = new BillboardDisplay();

     station.addObserver(phone);
     station.addObserver(tv);
     station.addObserver(billboard);

     station.setMeasurements(32.5f, 70.0f);
     station.setMeasurements(28.0f, 60.0f);
 }
}


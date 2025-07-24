package com.aurionpro.Observer.model;

import java.util.*;

//Observer Interface
interface Subscriber {
 void update(String videoTitle);
}

//Subject Interface
interface Channel {
 void subscribe(Subscriber sub);
 void unsubscribe(Subscriber sub);
 void notifySubscribers();
}

//Concrete Subject (YouTube Channel)
class YouTubeChannel implements Channel {
 private List<Subscriber> subscribers = new ArrayList<>();
 private String latestVideo;

 public void subscribe(Subscriber sub) {
     subscribers.add(sub);
 }

 public void unsubscribe(Subscriber sub) {
     subscribers.remove(sub);
 }

 public void uploadNewVideo(String title) {
     this.latestVideo = title;
     System.out.println("Channel: New video uploaded - " + title);
     notifySubscribers();
 }

 public void notifySubscribers() {
     for (Subscriber sub : subscribers) {
         sub.update(latestVideo);
     }
 }
}

//Concrete Observers
class Anu implements Subscriber {
 public void update(String videoTitle) {
     System.out.println("Anu got notified: New video -> " + videoTitle);
 }
}

class Ravi implements Subscriber {
 public void update(String videoTitle) {
     System.out.println("Ravi got notified: New video -> " + videoTitle);
 }
}

//Main Class
public class YouTubeDemo {
 public static void main(String[] args) {
     YouTubeChannel channel = new YouTubeChannel();

     Subscriber anu = new Anu();
     Subscriber ravi = new Ravi();

     channel.subscribe(anu);
     channel.subscribe(ravi);

     channel.uploadNewVideo("🎬 Learn Java in 10 Minutes!");
     channel.uploadNewVideo("🔥 Observer Pattern Explained with Cartoons");
 }
}

package com.aurionpro.model;

public class ThreadUsingThreadClass extends Thread{
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " is running");
	}
}

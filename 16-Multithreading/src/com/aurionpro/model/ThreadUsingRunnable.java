package com.aurionpro.model;

public class ThreadUsingRunnable implements Runnable{
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " is RUNNING");
	}

}

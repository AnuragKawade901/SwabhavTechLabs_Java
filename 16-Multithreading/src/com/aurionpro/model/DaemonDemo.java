package com.aurionpro.model;

public class DaemonDemo extends Thread{
	
	@Override
	public void run() {
		System.out.println("Running the Daemon Thread");
	}

}

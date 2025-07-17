package com.aurionpro.plugin.model;

public class Plugin {
	private double version;
	private Plugin() { // private
		
	}
	public void execute() {
		System.out.println("Plugin executed");
	}
}

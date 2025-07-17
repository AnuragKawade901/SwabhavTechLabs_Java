package com.aurionpro.model;

public class Counter implements Runnable {
public int count = 0;
public void increment() {
	count++;
}
@Override
public void run() {
	for(int i=1;i<1000;i++)
	{
		increment();
	}
}
}

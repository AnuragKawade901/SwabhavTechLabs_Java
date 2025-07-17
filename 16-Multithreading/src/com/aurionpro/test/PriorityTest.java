package com.aurionpro.test;

import com.aurionpro.model.PriorityDemo;

public class PriorityTest {
public static void main(String[] args) {
	
	new PriorityDemo("alpha",8).start();
	new PriorityDemo("beta",1).start();

	new PriorityDemo("gamma",3).start();

}
}

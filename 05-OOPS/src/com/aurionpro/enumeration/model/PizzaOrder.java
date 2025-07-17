package com.aurionpro.enumeration.model;

public class PizzaOrder {
public static void main(String[] args) {
	Size pizzaSize = Size.SMALL;
//	Size pizzaSize2 = Size.LARGE;
	
	switch(pizzaSize)
	{
	case SMALL:
		System.out.println("small pizza cost $150");
		break;
		
	case MEDIUM:
		System.out.println("medium pizza cost $150");
		break;
		
	case LARGE:
		System.out.println("large pizza cost $150");
		break;
	
	}
	for(Size size: pizzaSize.values())
	{
		System.out.println(size);
	}
}
}

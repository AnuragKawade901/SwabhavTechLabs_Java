//package com.aurionpro.Guitar.test;
//
//import java.util.Iterator;
//import java.util.List;
//
//import com.aurionpro.Guitar.model.Builder;
//import com.aurionpro.Guitar.model.Guitar;
//import com.aurionpro.Guitar.model.GuitarSpec;
//import com.aurionpro.Guitar.model.Inventory;
//import com.aurionpro.Guitar.model.Type;
//import com.aurionpro.Guitar.model.Wood;
//
//public class FindGuitarTest {
//	public static void main(String[] args) {
//		Inventory inventory = new Inventory();
//		initializeInventory(inventory);
//
//		GuitarSpec whatErinLike = new GuitarSpec(Builder.FENDER, "Stratocastor", Type.ELECTRIC, Wood.ALDER, Wood.ALDER, 6);
//		List matchingGuitars = inventory.search(whatErinLike);
//		if (!matchingGuitars.isEmpty()) {
//			System.out.println("Erin, you might like these guitar:");
//			for (Iterator i = matchingGuitars.iterator(); i.hasNext();) {
//				Guitar guitar = (Guitar) i.next();
//				GuitarSpec spec = guitar.getSpec();
//				System.out.println("We have a " + spec.getBuilder() + " " + spec.getModel()+ " " + spec.getNumStrings()+ "-string" + spec.getType()
//						+ " guitar:\n " + spec.getBackWood() + " back and sides,\n " + spec.getTopWood()
//						+ " top.\nYou can have it for only $" + guitar.getPrice() + "!\n ---- ");
//			}
//		} else {
//			System.out.println("Sorry, Erin, we have nothig for you.");
//		}
//	}
//
//	private static void initializeInventory(Inventory inventory) {
//		inventory.addInstrument("V95693", 1499.95, Builder.FENDER, "Stratocastor", Type.ELECTRIC, Wood.ALDER, Wood.ALDER, 6);
//		inventory.addInstrument("V9512", 1549.95, Builder.FENDER, "Stratocastor", Type.ELECTRIC, Wood.ALDER, Wood.ALDER, 6);
//
//	}
//}

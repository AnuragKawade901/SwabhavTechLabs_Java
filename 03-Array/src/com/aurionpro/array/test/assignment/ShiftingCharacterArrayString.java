package com.aurionpro.array.test.assignment;

import java.util.Scanner;

public class ShiftingCharacterArrayString {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);	
	 System.out.println("Enter:");
	 
	 String name = scanner.nextLine();
	 System.out.println("Enter the number positive or negative");
	 int shift = scanner.nextInt();
	 
	 char[] characters = name.toCharArray(); //convert the string from the user to character array
	 
	 for(int i = 0; i<characters.length;i++) {
		 char character = characters[i];
		 
		 if(Character.isLetter(character)) {
			 char base = Character.isLowerCase(character) ? 'a':'A';
			 
			 characters[i] = (char)((character - base + shift + 26)%26+base);
			 
		 }
	 }
	 String shiftedName = new String(characters);
	 System.out.println("Shifted name: " + shiftedName);
	 scanner.close();

}
}

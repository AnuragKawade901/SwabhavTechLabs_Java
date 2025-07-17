package com.aurionpro.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
public static void main(String[] args) throws FileNotFoundException {
	try (BufferedReader reader = new BufferedReader(new FileReader("demo.txt"))) {
		String line;
		while((line = reader.readLine())!=null) {
			System.out.println(line);
		}
	} catch (FileNotFoundException e) {
		throw e;
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}

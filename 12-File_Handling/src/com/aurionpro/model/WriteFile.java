package com.aurionpro.model;

import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
public static void main(String[] args) throws IOException {
	FileWriter writer = new FileWriter("demo.txt");
	writer.write("hello java, welcome to java");
	writer.close();
}
}

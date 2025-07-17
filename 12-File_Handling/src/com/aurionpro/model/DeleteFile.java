package com.aurionpro.model;

import java.io.File;

public class DeleteFile {
public static void main(String[] args) {
	File file = new File("D:\\Anurag Java\\12-File_Handling\\a.txt");
	if(file.delete()) {
		System.out.println("File deleted: "+file.getName());
	}
	else {
		System.err.println("file does not exist");
	}
}
}
package main.java.com.scg.student.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader {
	static BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static String name;
	public static int readInt() throws NumberFormatException, IOException {
		n = Integer.parseInt(reader.readLine());
		return n;
	}
	public static String readString() throws NumberFormatException, IOException {
		name = reader.readLine();
		return name;
	}
	
}
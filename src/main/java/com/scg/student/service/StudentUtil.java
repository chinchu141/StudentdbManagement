package main.java.com.scg.student.service;


import java.io.IOException;

import main.java.com.scg.student.vo.Student;

public class StudentUtil {
	public static  Student objectCreation() throws NumberFormatException, IOException {
		System.out.println("Enter Student id");
		int id = ConsoleReader.readInt();
		System.out.println("Enter Student name");
		String name = ConsoleReader.readString();
		System.out.println("Enter Student age");
	    int age = ConsoleReader.readInt();
	    Student newStudent = new Student(id,name,age);
	    return  newStudent;
		
	}

}
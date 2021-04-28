package main.java.com.scg.student.service;

import java.sql.SQLException;

import main.java.com.scg.student.vo.Student;

public interface StudentService {
	  void addStudent(Student s)throws SQLException, ValidateException;
	  void readAll() throws SQLException;
	  void deleteStudent(int id) throws SQLException;
	  void searchByName(String s) throws SQLException;
	  void update(Student updateRequest)throws SQLException;
	  void readById(int id) throws SQLException ;
	  void pageView(int pageNumber)throws SQLException;
	 

}
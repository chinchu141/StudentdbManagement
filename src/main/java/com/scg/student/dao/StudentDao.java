package main.java.com.scg.student.dao;
import java.sql.SQLException;
import java.util.List;
import main.java.com.scg.student.vo.Student;

public interface StudentDao {
	int addStudent(Student student)throws SQLException ;
	List<Student> readAll() throws SQLException; 
	int  deleteStudent(int id) throws SQLException;
	List<Student> searchbyName(String name) throws SQLException ;
	int update(Student student ) throws SQLException;
	Student readById(int id) throws SQLException;
	List<Student> pageView(int pageNumber)throws SQLException;
}
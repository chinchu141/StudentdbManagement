package main.java.com.scg.student.dao;

import java.util.List;
import main.java.com.scg.DbConnector;
import main.java.com.scg.student.vo.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class StudentDaoImplements implements StudentDao {

	private List<Student> studentList = new ArrayList<Student>();
	boolean flag;
	private Connection con;
	private Statement statement;
	private ResultSet resultSet;

	@Override
	public int addStudent(Student students) throws SQLException {
		int result = 0;
		String name = "name";//add new string
		boolean isTransactionSuccess = false;
		try {
			con = new DbConnector().getConnection();
			String query = "INSERT INTO student(studId,studName,age)VALUES(?,?,?)";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(1, students.getSid());
			statement.setString(2, students.getName());
			statement.setInt(3, students.getAge());
			result = statement.executeUpdate();
			if (result > 0)
				isTransactionSuccess = true;
		} catch (SQLIntegrityConstraintViolationException e) {
			// e.printStackTrace();
			System.out.println("Duplicate Student id : re enter ");
		} finally {
			if (isTransactionSuccess) {
				con.commit();
			} else {
				con.rollback();
			}
				con.close();
		}
		return result;
	}

	@Override
	public int deleteStudent(int id) throws SQLException {
		int result = 0;
		boolean isTransactionSuccess = false;
		// System.out.println(con.getAutoCommit());
		try {
			con = new DbConnector().getConnection();
			String query = String.format("delete from student where studId = %d", id);
			PreparedStatement statement = con.prepareStatement(query);
			result = statement.executeUpdate(query);
			if (result > 0)
				isTransactionSuccess = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (isTransactionSuccess) {
				con.commit();
			} else {
				con.rollback();
			}
			
				con.close();
		}
		return result;
	}

	@Override
	public List<Student> readAll() throws SQLException {
		boolean flag = false;
		try {
			con = new DbConnector().getConnection();
			studentList.clear();
			statement = con.createStatement();
			String query = "SELECT * FROM student";
			resultSet = statement.executeQuery(query);// send and execute SQL query in Database software
			// process the ResultSet object
			while (resultSet.next()) {
				int id = resultSet.getInt("studId");
				String studentName = resultSet.getString("studName");
				int age = resultSet.getInt("age");
				Student newStudent = new Student(id, studentName, age);
				studentList.add(newStudent);
				flag = true;
			}
			if (flag == false) {
				System.out.println("Record not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
				con.close();
		}
		return studentList;
	}

	@Override
	public int update(Student students) throws SQLException {
		int result = 0;
		boolean isTransactionSuccess = false;
		try {
			con = new DbConnector().getConnection();
			String query = "UPDATE  student SET studName = ?, age= ? WHERE  studId= ?";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, students.getName());
			statement.setInt(2, students.getAge());
			statement.setInt(3, students.getSid());
			result = statement.executeUpdate();
			if (result > 0)
				isTransactionSuccess = true;
			// System.out.println("Successfully updated");
		} catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
		} finally {
			if (isTransactionSuccess) {
				con.commit();
			} else {
				con.rollback();
			}

			
				con.close();
		}
		return result;

	}

	@Override
	public List<Student> searchbyName(String name) throws SQLException {

		boolean flag = false;
		try {
			con = new DbConnector().getConnection();
			studentList.clear();
			// Pattern pattern = Pattern.compile(name);
			statement = con.createStatement();
			String query = "SELECT * FROM student WHERE studName like '%" + name + "%'";
			resultSet = statement.executeQuery(query);// send and execute SQL query in Database software
			// process the ResultSet object
			while (resultSet.next()) {
				int id = resultSet.getInt("studId");
				String studentName = resultSet.getString("studName");
				int age = resultSet.getInt("age");
				Student newStudent = new Student(id, studentName, age);
				studentList.add(newStudent);
				flag = true;
			}
			if (flag == false) {
				System.out.println("Record not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
				con.close();
		}
		return studentList;

	}

	@Override
	public Student readById(int id) throws SQLException

	{
		Student newStudent = null;
		try {
			con = new DbConnector().getConnection();
			statement = con.createStatement();
			String query = String.format("SELECT * FROM student WHERE studId= %d", id);

			resultSet = statement.executeQuery(query);// send and execute SQL query in Database software
			while (resultSet.next()) {
				int studId = resultSet.getInt("studId");
				String studentName = resultSet.getString("studName");
				int age = resultSet.getInt("age");
				newStudent = new Student(studId, studentName, age);
				flag = true;
				return newStudent;
			}
			if (flag == false)
				System.out.println("No any students with id = " + id);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
				con.close();
		}
		return newStudent;
	}

	@Override

	public List<Student> pageView(int pageNumber) throws SQLException {
		final int limit = 4;
		int offset = 0;
		try {
			con = new DbConnector().getConnection();
			studentList.clear();
			offset = limit * (pageNumber - 1);
			String query = "select  * from student  limit ? offset ?";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(1, limit);
			statement.setInt(2, offset);
			resultSet = statement.executeQuery();// send and execute SQL query in Database software
			while (resultSet.next()) {
				int id = resultSet.getInt("studId");
				String studentName = resultSet.getString("studName");
				int age = resultSet.getInt("age");
				Student newStudent = new Student(id, studentName, age);
				studentList.add(newStudent);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
				con.close();
		}

		return studentList;
	}

}
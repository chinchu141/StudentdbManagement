package main.java.com.scg.student.service;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import main.java.com.scg.student.dao.StudentDao;
import main.java.com.scg.student.dao.StudentDaoImplements;
import main.java.com.scg.student.vo.Student;

public class StudentServiceImplements implements StudentService {
     
	 private StudentDao dao = new StudentDaoImplements();
	 boolean n = true;
	 int id,age;
	 BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
	 public List<Student> studentsList = new ArrayList<Student>();
	  
	 @Override
	 /*
	  Add student as an object to the list
	  */
	 
	 public void addStudent(Student student) throws SQLException, ValidateException {
		try {
			StudentValidator.validate(student);
			int result = dao.addStudent(student);
			if (result == 1) { 
	            System.out.println("Successfully added"); 
	        }else { 
	            System.out.println("Error"); 
	        }
		}catch(ValidateException e) {
			System.out.println(e);	
		}  
	 }
	 
	 @Override
	 /*
	  delete student by using id
	  */
	 public void deleteStudent(int id) throws SQLException {
		 try {
			StudentValidator.validateId(id);
			int result = dao.deleteStudent(id); //delete student
			if (result == 0) { 
	            System.out.println("record not found to delete"); 
	        }else { 
	            System.out.println(result+"  record found and deleted"); 
	        } 
		 }catch (ValidateException e) {
			System.out.println(e);	
		 }
     }
		  
	 
	 @Override
	 /*
	  Display all student 
	  */
	 public void readAll() throws SQLException {
		 boolean flag = false;
		 for (Student student : dao.readAll()) {
	         System.out.println( student.getSid()+"      "+ student.getName() +"           " + student.getAge());
	         flag = true;
	      }
		     
		
		     if (flag == false) {
		    	   System.out.println("Record not found");
		       } 
	 }
	      /* 
			
	 //}
	 
	 
	 @Override
	 /*
	  update student 
	  */
	 public void update(Student updateRequest) throws SQLException {
		// TODO Auto-generated method stub
		 int result;
		try {
			StudentValidator.validate(updateRequest);
			Student existingStudent = dao.readById(updateRequest.getSid());
			if(updateRequest.getName()!= null) {
				existingStudent.setName(updateRequest.getName());       
			}
			if(updateRequest.getAge()!=0) {
				existingStudent.setAge(updateRequest.getAge());       
			}
			result = dao.update(existingStudent);	
			if (result == 0) { 
	            System.out.println("record not found to update"); 
	        }else { 
	            System.out.println(result+"  record updated"); 
	        } 
		} catch (ValidateException e) {
			System.out.println(e);	
		}catch(NullPointerException e) {
			System.out.println(e);
		}
	 }
	
	 @Override
	 /*
	  search student using name
	  */
	 public void searchByName(String name) throws SQLException {
		 try {
			StudentValidator.validateName(name);
			for (Student student : dao.searchbyName(name)) {
		         System.out.println( student.getSid()+"      "+ student.getName() +"           " + student.getAge());
		      }
		 }catch (ValidateException e) {
			System.out.println(e);	
		 }
	 }
	 
	 
	 @Override
	 /*
	  search student using id
	  */
	 
	 public void readById(int id) throws SQLException {
		 try {
			StudentValidator.validateId(id);
			Student student = dao.readById(id);  // search student by student id
			System.out.println(student.toString()+"\n");
		  }catch (ValidateException e) {
			 System.out.println(e);	
		  }catch (NullPointerException e) {
			System.out.println(e);	
		  }
	 }
	
	
	
	@Override 
	 public void pageView(int pageNumber) throws SQLException {
		
		try {
			
			StudentValidator.validateId(pageNumber);
			studentsList =dao.pageView(pageNumber);
			if (studentsList.isEmpty()) {
				System.out.println("No records on this page");
			}
			
			else {
			for (Student student : studentsList) {
		         System.out.println( student.getSid()+"      "+ student.getName() +"           " + student.getAge());
		      }
			}
	   }catch (ValidateException e) {
			System.out.println(e);
	   }
	 }
	
}
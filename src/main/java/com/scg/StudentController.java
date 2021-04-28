package main.java.com.scg;

import java.io.IOException;
import java.sql.SQLException;
import main.java.com.scg.student.service.ConsoleReader;
import main.java.com.scg.student.service.StudentService;
import main.java.com.scg.student.service.StudentServiceImplements;
import main.java.com.scg.student.service.StudentUtil;
import main.java.com.scg.student.service.ValidateException;
import main.java.com.scg.student.vo.Student;

public class StudentController {
	public static void main(String[] args) throws IOException, ValidateException, SQLException{
		int id;
		String name;
		StudentService studentService = new StudentServiceImplements();
		Student student;
		while(true) {
			System.out.println("\n\n		-- Select LIST OF OPTIONS--   ");
			System.out.println("		1. Insert Student ");
			System.out.println("		2. Delete student by id");
			System.out.println("		3. Print all student info");
			System.out.println("		4. Update student info");
			System.out.println("		5. Search by name");
			System.out.println("		6. Read by id");
			System.out.println("		7. Pagination");
			System.out.println("		8. EXIT");
			System.out.println("Enter any number 1-8");
			int n = ConsoleReader.readInt();
			switch (n) {
			
			  case 1:
				 student = StudentUtil.objectCreation();
				 studentService.addStudent(student);// add student details   
			  break;
			     
			  case 2:
				System.out.println("Enter id for delete");
				id = ConsoleReader.readInt();
				studentService.deleteStudent(id);
			    break;
			    
			  case 3:
				studentService.readAll();	//read all information from list
				break;
				
			  case 4:
				System.out.println("Enter data for updation");
	            Student updateRequest = StudentUtil.objectCreation();
				studentService.update(updateRequest);// update student
			   break;
			   
			   case 5:
				System.out.println("Enter name for search");
				name = ConsoleReader.readString();
				studentService.searchByName(name); // search student by name
			    break;
			     
			  case 6:
				System.out.println("Enter id for search");
				id = ConsoleReader.readInt();
				studentService.readById(id);  // search student by student id
				break;
			    	  
			  case 7:
				 System.out.println("Enter page number");
				 int pageNumber = ConsoleReader.readInt(); 
				 studentService.pageView(pageNumber);
				 break;
				 
			  case 8:
				 System.out.println("Exited");// Exit
				 System.exit(0);
				 break;
				    
			  default:
				  System.out.println("Enter valid option");
			}

		}
		
	}

}
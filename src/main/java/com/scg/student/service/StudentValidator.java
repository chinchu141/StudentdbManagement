package main.java.com.scg.student.service;

import main.java.com.scg.student.vo.Student;
import main.java.com.scg.student.dao.StudentDao;
import main.java.com.scg.student.dao.StudentDaoImplements;

public class StudentValidator {
	StudentDao sd = new StudentDaoImplements();
	public static void validate(Student s)throws ValidateException{  
	      if(s.getSid()<0||s.getAge()<5||s.getAge()>100||s.getName().matches( "[a-zA-Z][a-zA-Z]*" )==false){
	    	  
	           throw new ValidateException("\nEnter valid data to student details\n");
	          
          }   
   }
	public static void validateId(int id)throws ValidateException{  
	      if(id < 0){
	           throw new ValidateException("\nEnter valid id\n");
	      }
	          
   }
	public static void validateName(String name)throws ValidateException{  
	      if(name.matches("[a-zA-Z][a-zA-Z]*")==false){
	           throw new ValidateException("\nEnter valid name\n");
	      }
   }
	public static void validateDb(int id)throws ValidateException{  
	      
	    	  
	           throw new ValidateException("\nEnter valid data to student details\n");
	          
        }   
	      

}
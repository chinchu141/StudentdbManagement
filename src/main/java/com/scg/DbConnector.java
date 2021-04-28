package main.java.com.scg;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DbConnector {

 public Connection getConnection() throws SQLException
	 {
		 String url = "jdbc:mysql://localhost:3306/studentdb";
	     String username = "root";
	     String password = "root";
	     Connection con = null;
	     
	     try 
	     {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	     } 
	     catch (ClassNotFoundException e1) 
	     {
	        // TODO Auto-generated catch block
	        e1.printStackTrace();
	    }

	     try 
	     {
	         con = DriverManager.getConnection(url, username, password);
	         con.setAutoCommit(false);
	     } 
	     catch (Exception e) 
	     {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	     }
	    return con;
	    }
	}
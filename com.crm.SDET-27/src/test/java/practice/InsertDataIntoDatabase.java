package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertDataIntoDatabase {
	public static void main(String[] args) throws SQLException{
		//Register the database
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		//Establish the connection with database
		 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
		 
		 //issue the statement
		 Statement statement = connection.createStatement();
		 
		 //execute query
		 int result = statement.executeUpdate("insert into studentinfo(fname,lname,address) value('Arya','ash','US')");
		 
		 //verification
		 if(result==1) {
			 System.out.println("One set data is added to database");
		 }
		else {
				 System.out.println("Data is not added to database");
			 }
		 //close the database connection
		 connection.close();
		  
	}
}

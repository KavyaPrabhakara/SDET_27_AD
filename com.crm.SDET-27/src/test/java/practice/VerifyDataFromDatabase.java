package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class VerifyDataFromDatabase {
	
	public static void main(String[] args) throws SQLException {
		String expectedfname="Manasa";
		
		//Register the database
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
				
		//Establish the connection with database
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
				 
		//issue the statement
		Statement statement = connection.createStatement();
				 
		//execute queries
		ResultSet result = statement.executeQuery("select * from studentinfo");
		while(result.next()){
				if(result.getString(2).equals(expectedfname)){
					   System.out.println("Passed");
					}
				 }
		//close the database connection
		connection.close();
	}

}

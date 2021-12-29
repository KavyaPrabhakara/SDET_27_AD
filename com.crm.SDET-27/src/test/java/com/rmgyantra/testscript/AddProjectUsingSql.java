package com.rmgyantra.testscript;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class AddProjectUsingSql {

	public static void main(String[] args) throws SQLException {
		Connection connection=null;
		try {
		//Register the database
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
						
		//Establish the connection with database
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
						 
		//issue the statement
		Statement statement = connection.createStatement();
						 
		//execute queries
		int result = statement.executeUpdate("insert into project(project_id, created_by,project_name,status, team_size) value('TY_PROJ_013','Neha','IBM','completed','20')");
				
		//verification
		if(result==1) {
		System.out.println("One project is added to database");
			}
			else {
					System.out.println("project is not added to database");
				 }
		}
		catch (Exception e) {
			e.getStackTrace();
		}
		finally {
		connection.close();
		}
	}

}

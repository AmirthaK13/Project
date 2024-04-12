package com.AspireSystemBudgetTracker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class RegisterPage {
	static Connection connection;
	public static void register() {
		// create tablbe
		/*try {
			
		connection= DBConnection.getConnection();
		Statement statement = connection.createStatement();
		 statement.executeUpdate("create table Register(username varchar(10),password varchar(20))");
		 System.out.println("table is created successfully!");
	 }
	 catch(Exception e)
		{
			System.out.println(e);
		}
		*/
		
		// insert data into table
		try
		{
			connection=DBConnection.getConnection();
			Scanner scanner = new Scanner(System.in);
   	 System.out.println("enter  username ");
   		 String username  = scanner.nextLine();
   		 System.out.println("enter password ");
   		 String password  = scanner.nextLine();
   		System.out.println("enter mobileno ");
  		 int mobileno = scanner.nextInt();
   		 
			String sql="insert into Register values(?,?,?)";
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setString(1,username);
			preparedStatement.setString(2,password);
			preparedStatement.setInt(3,mobileno);
			preparedStatement.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
}

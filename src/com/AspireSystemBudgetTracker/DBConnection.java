package com.AspireSystemBudgetTracker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DBConnection 
{
	static Connection connection;
	public static Connection getConnection()
	{
	/*try
	{
	Class.forName("com.mysql.cj.jdbc.Driver");
	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","ammu");
	System.out.println("connection created");
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	// create database
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","ammu");
		Statement statement=connection.createStatement();
		statement.executeUpdate("create database Jdbc_example");
		System.out.println("Database created successfully!");
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	return connection;
}*/
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BudgetTrackerManagement","root","ammu");
		
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		return connection;
		}
	
			
		}

package com.AspireSystemBudgetTracker;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class AdminPage {
	
	static Connection connection;
	
static String adminId="admin";
static String adminPassword="admin123";
public static void adminLogin()
{

	Scanner scanner = new Scanner(System.in);
	System.out.print("Enter username: ");
	String username = scanner.nextLine();
	System.out.print("Enter password: ");
	System.out.println("\033[8m");
    String password = scanner.nextLine();
    System.out.println("\033[0m");
	if(username.equals(adminId )&& password.equals(adminPassword))
	{
		System.out.println("loggin sucessfully! ");
		display();
		}
	else
	{
		System.out.println("invalid inputs");
	}
}
public static void display()
{
	try
	{
	Connection connection=DBConnection.getConnection();
	String sql = "select username,mobileno from register";
	PreparedStatement preparedStatement = connection.prepareStatement(sql);
	 ResultSet resultSet = preparedStatement.executeQuery();
	 System.out.println("data retrived");
	 System.out.println("username\t mobileno\t");
	 while(resultSet.next())
	 {
		 String username=resultSet.getString("username");
         int mobileno=resultSet.getInt("mobileno");
System.out.println(username +"\t          "+mobileno+"\t");
}
	}
	 catch(Exception e)
		{
			System.out.println(e);
		}

}
}



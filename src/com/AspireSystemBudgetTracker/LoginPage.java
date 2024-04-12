package com.AspireSystemBudgetTracker;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.Scanner;

public class LoginPage{
   
	static Connection connection ;
 
    public static void login() {
    
    	try {
    		connection=DBConnection.getConnection();

   
    	Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        System.out.println("\033[8m");
        String password = scanner.nextLine();
        System.out.println("\033[0m");
       String sql = "Select * from Register where username=? and password=?";
       PreparedStatement preparedStatement= connection.prepareStatement(sql);
		preparedStatement.setString(1,username);
		preparedStatement.setString(2,password);
		ResultSet result= preparedStatement.executeQuery();
        if (result.next()) {
            System.out.println("Login successful!");
            System.out.println("if you want add income enter income or add expenses or report: ");
            String input = scanner.nextLine();
    		if(input.equals("income"))
        	{
        		UserPage.incomeCategory();	
        	}
    		else if (input.equals("add expenses"))
    		{
    			ChoiceExpenses.choice();
            } 
    		else
    		{
    			Report.report();
    		}
        }
    	else {
            System.out.println("Invalid username or password. Please try again.");
            LoginPage.login();
        }
    }
    	catch(Exception e)
		{
			System.out.println(e);
		}

    }
}


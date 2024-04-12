package com.AspireSystemBudgetTracker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class UserPage {
	
    static double totalIncome = 0;
    static Connection connection;
	
	public static void incomeCategory()
	
	{
		Scanner scanner = new Scanner(System.in);
		try
		{
			connection=DBConnection.getConnection();
			
        System.out.println("If you want to add income category enter add or update enter update : ");
    	String input = scanner.nextLine();
		if(input.equals("add"))
    	{
    		UserPage.addIncome();	
    	}
		else 
		{
			UserPage.updateSetbuget();
		}
		
		
		System.out.println("If you want to add/update another category, enter 'yes'; otherwise, enter 'no':");
        String input1 = scanner.nextLine();
        if (input1.equals("yes")) {
        	UserPage.incomeCategory();
        }
        ChoiceExpenses.choice();
    }
	
	catch(Exception e)
{
	System.out.println(e);
}
	}
	public static void addIncome() {
		
			
				try
				{
					connection=DBConnection.getConnection();
				Scanner scanner = new Scanner(System.in);
				System.out.println("Enter income source : ");
				String income_source = scanner.nextLine();
				System.out.println("Enter the income amount:");
		        int income_amount = scanner.nextInt();
		        System.out.println("Enter the budget amount:");
		        int setBudget = scanner.nextInt();
		        System.out.println("Enter the income date (yyyy/mm/dd):");
		        String dateInput = scanner.next();
		        SimpleDateFormat dateformat= new SimpleDateFormat("yyyy-mm-dd");
		        		scanner.nextLine();
		        totalIncome += income_amount;
		      
		   
				String sql="insert into incomeCategory values(?,?,?,?,?)";
				PreparedStatement preparedStatement= connection.prepareStatement(sql);
				preparedStatement.setString(1,income_source);
				preparedStatement.setInt(2,income_amount);
				preparedStatement.setDouble(3,(double) totalIncome);
				preparedStatement.setInt(4,setBudget);
				preparedStatement.setString(5, dateInput);
				preparedStatement.executeUpdate();

		     System.out.println("Income added successfully.");
		    System.out.println("Total income: " + totalIncome);
		}
				catch(Exception e)
				{
					System.out.println(e);
				}
	}
	public static void updateSetbuget()
	{
		try
		 {
			Scanner scanner = new Scanner(System.in);
			    System.out.println("Enter the income date for which you want to update the setBudget:");
			    String income_source = scanner.nextLine();
			    System.out.println("Enter the new setBudget:");
			    int newSetBudget = scanner.nextInt();
			    System.out.println("Enter the income date (yyyy/mm/dd):");
		        String dateInput = scanner.next();
		        SimpleDateFormat dateformat= new SimpleDateFormat("yyyy-mm-dd");
			    scanner.nextLine();

			    String sql = "UPDATE incomeCategory SET setBudget = ? WHERE income_date = ?";
			    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			        preparedStatement.setInt(1, newSetBudget);
			        preparedStatement.setString(2, dateInput);
			        int rowsAffected = preparedStatement.executeUpdate();
			        if (rowsAffected > 0) {
			            System.out.println("Budget updated successfully for income date: " + dateInput);
			        } else {
			            System.out.println("Income date not found.");
			            UserPage.updateSetbuget();
			        }
			    }
			}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		}
	}



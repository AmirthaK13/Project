package com.AspireSystemBudgetTracker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Report {
	static Connection connection;
	static Scanner scanner=new Scanner(System.in);
	public static void report()
	{
		try
		{
		Connection connection=DBConnection.getConnection();
		System.out.println("Enter the income date (yyyy/mm/dd):");
        String dateInput = scanner.next();
        SimpleDateFormat dateformat= new SimpleDateFormat("yyyy-mm-dd");
	   // scanner.nextLine();
	 
		String sql = "select ic.income_amount,ic.setBudget,ic.income_date,ex.expense_name,ex.amount_spent,ex.expense_date,ex.totalExpense from incomeCategory ic join expense ex where ic.income_date=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		 preparedStatement.setString(1, dateInput);
		 ResultSet resultSet = preparedStatement.executeQuery();
		 System.out.println("data retrived");
		 System.out.println("income_amount\t setBudget\t income_date\t expense_name\t amount_spent\t expense_date\t  totalExpense\t");
		 while(resultSet.next())
		 {
			 int income_amount=resultSet.getInt("income_amount");
			 int setBudget=resultSet.getInt("setBudget");
			 String income_date=resultSet.getString("income_date");
			 String expense_name=resultSet.getString("expense_name");
	         int amount_spent=resultSet.getInt("amount_spent");
	         String expense_date=resultSet.getString("expense_date");
	         double totalExpense=resultSet.getDouble("totalExpense");
	         System.out.println(income_amount+"\t       "+setBudget+"\t            "+income_date+"\t          "+expense_name+"\t          "+amount_spent+"\t        "+expense_date+"\t         "+ totalExpense+"\t");
	         
	}
	}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		}
}

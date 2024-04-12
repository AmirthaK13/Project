package com.AspireSystemBudgetTracker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class ExpensePage {
	static Connection connection;
	
	 static double  totalExpense=0;
	public static void addExpense()                             //add expense
	{
		try
		{
			
			connection=DBConnection.getConnection();
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter expense name ");
		String expense_name = scanner.nextLine();
		System.out.println("enter amount spent ");
		int amount_spent = scanner.nextInt();
		 System.out.println("Enter the expense date (yyyy/mm/dd):");
	        String dateInput = scanner.next();
	        SimpleDateFormat dateformat= new SimpleDateFormat("yyyy-mm-dd");
		 scanner.nextLine();
		 totalExpense += amount_spent;
		 
		String sql="insert into expense values(?,?,?,?)";
		PreparedStatement preparedStatement= connection.prepareStatement(sql);
		preparedStatement.setString(1,expense_name);
		preparedStatement.setInt(2,amount_spent);
		preparedStatement.setString(3,dateInput);
		preparedStatement.setDouble(4, totalExpense);
		preparedStatement.executeUpdate();

        System.out.println("Expenses added successfully.");
        BudgetChecker.checkBudgetExceed(totalExpense, amount_spent);
        System.out.println("If you want to add another  enter add expense or exit : ");
    	String input = scanner.nextLine();
		if(input.equals("add expense"))
    	{
    		ExpensePage.addExpense();
    		
    	}
		else 
		{
			ChoiceExpenses.choice();
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	public static void displayExpense()                  //display expense
	{
		try
		{
		Connection connection=DBConnection.getConnection();
		String sql = "select expense_name,amount_spent,expense_date, totalExpense from expense";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		 ResultSet resultSet = preparedStatement.executeQuery();
		 System.out.println("data retrived");
		 System.out.println("expense_name\t amount_spent\t expense_date\t  totalExpense\t");
		 while(resultSet.next())
		 {
			 String expense_name=resultSet.getString("expense_name");
	         int amount_spent=resultSet.getInt("amount_spent");
	         String expense_date=resultSet.getString("expense_date");
	         double totalExpense=resultSet.getDouble("totalExpense");
	         System.out.println(expense_name+"\t          "+amount_spent+"\t        "+expense_date+"\t         "+ totalExpense+"\t");
	         
	}
		 ChoiceExpenses.choice();
		}
		 catch(Exception e)
			{
				System.out.println(e);
			}
	}
	/*public static void updateExpense()               // update expense
	{
		try
		{
			Connection connection=DBConnection.getConnection();
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the new amount spent :");
		    int amount_spent = scanner.nextInt();
		    System.out.println("Enter the expense_name:");
	        String expense_name = scanner.next();
		    scanner.nextLine();
		    System.out.println("Enter the expense date (yyyy/mm/dd):");
	        String dateInput = scanner.next();
	        SimpleDateFormat dateformat= new SimpleDateFormat("yyyy-mm-dd");
		    scanner.nextLine();
		    String sql = "update expense set amount_spent = ?,totalexpense = totalexpense + ? WHERE expense_name = ? AND expense_date = ?";
		    PreparedStatement preparedStatement = connection.prepareStatement(sql);
		    preparedStatement.setInt(1, amount_spent);
		    preparedStatement.setDouble(2, amount_spent);
		    preparedStatement.setString(3, expense_name);
		    preparedStatement.setString(4, dateInput);
		    preparedStatement.executeUpdate();
			System.out.println("expenses updated");
			ChoiceExpenses.choice();

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}*/
	public static void updateExpense() {
	    try {
	        Connection connection = DBConnection.getConnection();
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Enter the new amount spent:");
	        int newAmountSpent = scanner.nextInt();
	        System.out.println("Enter the expense_name:");
	        String expenseName = scanner.next();
	        scanner.nextLine();
	        System.out.println("Enter the expense date (yyyy/mm/dd):");
	        String dateInput = scanner.next();
	        scanner.nextLine();

	        // Retrieve old amount spent
	        String selectQuery = "SELECT amount_spent FROM expense WHERE expense_name = ? AND expense_date = ?";
	        PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
	        selectStatement.setString(1, expenseName);
	        selectStatement.setString(2, dateInput);
	        ResultSet resultSet = selectStatement.executeQuery();
	        int oldAmountSpent = 0;
	        if (resultSet.next()) {
	            oldAmountSpent = resultSet.getInt("amount_spent");
	        }

	        // Calculate difference
	        int difference = newAmountSpent - oldAmountSpent;

	        // Update amount spent and total expense
	        String updateQuery = "UPDATE expense SET amount_spent = ? WHERE expense_name = ? AND expense_date = ?";
	        PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
	        updateStatement.setInt(1, newAmountSpent);
	        updateStatement.setString(2, expenseName);
	        updateStatement.setString(3, dateInput);
	        updateStatement.executeUpdate();

	        String updateTotalQuery = "UPDATE expense SET totalexpense = totalexpense + ? WHERE expense_date= ?";
	        PreparedStatement updateTotalStatement = connection.prepareStatement(updateTotalQuery);
	        updateTotalStatement.setInt(1, difference);
	        updateTotalStatement.setString(2, dateInput);
	        updateTotalStatement.executeUpdate();

	        System.out.println("Expense updated successfully.");
	        ChoiceExpenses.choice();
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	}

	public static void deleteExpense()
	{
		try
		{
			
			Connection connection=DBConnection.getConnection();
			Scanner scanner = new Scanner(System.in);
			System.out.println("enter expense name ");
			String expense_name = scanner.nextLine();
			System.out.println("enter amount spent ");
			int amount_spent = scanner.nextInt();
			System.out.println("Enter the expense date (yyyy/mm/dd):");
	        String dateInput = scanner.next();
	        SimpleDateFormat dateformat= new SimpleDateFormat("yyyy-mm-dd");
		    scanner.nextLine();
		    String sql = "DELETE FROM expense WHERE expense_name = ? AND amount_spent = ? AND expense_date = ?";
		    PreparedStatement preparedStatement = connection.prepareStatement(sql);
		    preparedStatement.setString(1, expense_name);
		    preparedStatement.setInt(2, amount_spent);
		    preparedStatement.setString(3, dateInput);
		    preparedStatement.executeUpdate();
			System.out.println("expenses deleted");
			ChoiceExpenses.choice();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
}

package com.AspireSystemBudgetTracker;

import java.util.Scanner;

public class BudgetChecker {

	    public static void checkBudgetExceed(double totalExpense, double setBudget) {
	        if (totalExpense > setBudget) {
	            System.out.println("Alert: Total expense exceeds the set budget!");
	            System.out.println("Do you want to change budget enter change or keep going..");
	            Scanner scanner = new Scanner(System.in);
	            String input = scanner.nextLine();
	            if(input.equals("change"))
	            {
	            	UserPage.updateSetbuget();
	            }
	        }
	        else
	        {
	        	System.out.println("your under your control keep going...!!");
	        }
	    }
	}



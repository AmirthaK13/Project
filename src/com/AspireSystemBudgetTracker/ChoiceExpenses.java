package com.AspireSystemBudgetTracker;

import java.util.Scanner;

public class ChoiceExpenses {
	static Scanner scanner = new Scanner(System.in);
	public static void choice()
	{
		System.out.println("Select an option:\n1. Add Expense\n2. Display\n3. Update\n4. Delete\n5. report\n6. logout");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        switch (choice)
        {
            case 1:
                ExpensePage.addExpense();
                break;
            case 2:
            	ExpensePage.displayExpense();
                break;
            case 3:
            	ExpensePage.updateExpense();;
                break;
            case 4:
            	ExpensePage.deleteExpense();
                break;
            case 5:
            	Report.report();
            case 6:
            	System.out.println("Exiting...");
                Logout.logout();
            default:
                System.out.println("Invalid choice");
                ChoiceExpenses.choice();
		}
	}

}

package com.AspireSystemBudgetTracker;


import java.util.Scanner;

public class HomePage {
public static void homePage()
{
Scanner scanner = new Scanner(System.in);
System.out.print("Enter 'login' or 'register'or 'admin' or 'logout': ");
String input = scanner.nextLine();

if (input.equalsIgnoreCase("login")) {
LoginPage.login();
} else if (input.equalsIgnoreCase("register")) {
RegisterPage.register();
homePage();
} else if (input.equalsIgnoreCase("admin")){
	AdminPage.adminLogin();
}
else if(input.equalsIgnoreCase("logout")) {
	Logout.logout();
}
else
{
System.out.println("Invalid input.");
HomePage.homePage();
}
}
}

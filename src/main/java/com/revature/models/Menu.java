package com.revature.models;
import com.revature.dao.*;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Menu {
	
	//EmployeeDao eDao = new EmployeeDao();//so we can use its methods
	//RoleDao rDao = new RoleDao();
	Logger log = LogManager.getLogger(Menu.class);

	//All of menu options and control flow are contained within this method
		public void displayMenu(){
			
			boolean displayMenu = true; // going to use this to toggle whether the menu continues after user input
			//int in;
			Scanner scan = new Scanner(System.in);
			
			
			//pretty greeting :)
			System.out.println("\n=========================================================");
			System.out.println("Welcome to the Krusty Crab Employee Management System!");
			System.out.println("=========================================================\n");
			
			//display the menu as long as the displayMenu boolean is true
			while (displayMenu) {
				
				log.info("ENTER WHILE MAIN LOOP");
				
				System.out.println("-------------------");
				System.out.println("Choose an Option:");
				System.out.println("-------------------");
			
				//menu options
				System.out.println("hi -> get greated");
				System.out.println("employees -> show all employees");
				System.out.println("employeesById -> get employees with a certain id#");
				System.out.println("addNewEmployee -> add new employee");
				System.out.println("deleteEmployee -> delete an current employee");
				
				System.out.println("updateSalary -> update a role salary");
				
				System.out.println("exit -> exit application");
				
				
				//parse user input after they choose a menu option
				String input = scan.nextLine();
				
				//switch statement that takes the input and delivers the appropriate response
				//you may have a hard time reading allthis functionality
				//look at out dao layer interface to see everything the CLI is able to do
				
				switch (input) {
				
				
				
				case "hi": {
					System.out.println("option 1: hey what's up");
					break;//we need a break for each case
				
				
				}
				
				case "exit": {
					displayMenu = false; //this is how we break out og the while loop, ending the menu display
					System.out.println("bye!! come again.");
					
					log.warn("Closing main loop - " + displayMenu + " - DisplayMenu");
					
					break;
					
					
					
				}
	
				default: {
					System.out.println("that was incorrent input");
					break;
				}
				}//end of switch statement
			
			}//end of while loop
			
			System.out.println("Thank you for using our Krusty Crab EMS");
			scan.close();
			
			
		}//end of method
		
		
}//end of class

package com.revature.models;
import com.revature.dao.*;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Menu {
	
	ItemDao iDao = new ItemDao();//so we can use its methods
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
				
				//log.info("ENTER WHILE MAIN LOOP");
				
				System.out.println("-------------------");
				System.out.println("Choose an Option:");
				System.out.println("-------------------");
			
				//menu options
				System.out.println("hi -> get greated");
				
				System.out.println("items -> show all items");
				System.out.println("shippingLogs -> get both shippinglogs and transactions");
				//explain more details of items shipped 
				System.out.println("transaction -> get info of a shipment");
				System.out.println("buyers -> show buyers/suppliers");
				
				System.out.println("sell -> sell item");
				System.out.println("buy -> order item");
				
				System.out.println("updateBuyers -> update a customors info");
				System.out.println("addBuyers -> add new custmor info");
				
				
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
				
				case "items": {//get the List of Employees from the DAO layer
					//nothing is here yet, but will do some sql functionsallity
					
					List<Item> items = iDao.getItems();
					
					//BEN - enhanced for loop
					for (Item emp : items) {
					System.out.println(emp);
					}
					//System.out.println(employees);
					
					
					//log.info("USER RETRIVED LIST OF ALL EMPLOYEES");
					
					break;
				}
				
				case "exit": {
					displayMenu = false; //this is how we break out og the while loop, ending the menu display
					System.out.println("bye!! come again.");
					
					//log.warn("Closing main loop - " + displayMenu + " - DisplayMenu");
					
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

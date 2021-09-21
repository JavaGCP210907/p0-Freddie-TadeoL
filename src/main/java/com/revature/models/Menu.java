package com.revature.models;

import com.revature.dao.*;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Menu {
	
	ShippingLogDoa slDao = new ShippingLogDoa();
	CustomersDao cDao = new CustomersDao();
	ItemDao iDao = new ItemDao();// so we can use its methods
	Logger log = LogManager.getLogger(Menu.class);

	// All of menu options and control flow are contained within this method
	public void displayMenu() {

		boolean displayMenu = true; // going to use this to toggle whether the menu continues after user input
		// int in;
		Scanner scan = new Scanner(System.in);

		// pretty greeting :)
		System.out.println("\n=========================================================");
		System.out.println("Welcome to the Krusty Crab Employee Management System!");
		System.out.println("=========================================================\n");

		// display the menu as long as the displayMenu boolean is true
		while (displayMenu) {

			// log.info("ENTER WHILE MAIN LOOP");

			System.out.println("-------------------");
			System.out.println("Choose an Option:( X|-Not Implemented, & W|-Working on");
			System.out.println("-------------------");

			// menu options
			System.out.println("hi -> get greated");

			System.out.println("items -> show all items");
			System.out.println("shipFullLog -> get both shippinglogs and transactions details");
			System.out.println("shippingLog -> get shippinglogs");
			// explain more details of items shipped
			System.out.println("transaction -> get info of one shipment");
			System.out.println("buyers -> show buyers/suppliers");

			System.out.println("X|sell -> sell item");
			System.out.println("X|buy -> order item");

			System.out.println("W|updateBuyers -> update a customors info");
			System.out.println("X|addBuyers -> add new custmor info");
			
			System.out.println("deleteItem -> remove Item to warehouse");
			System.out.println("addItem -> add new Item to warehouse");
			

			System.out.println("exit -> exit application");

			// parse user input after they choose a menu option
			String input = scan.nextLine();

			// switch statement that takes the input and delivers the appropriate response
			// you may have a hard time reading allthis functionality
			// look at out dao layer interface to see everything the CLI is able to do

			switch (input) {

			case "hi": {
				System.out.println("option 1: hey what's up");
				break;// we need a break for each case

			}

			case "items": {// get the List of Employees from the DAO layer
				// nothing is here yet, but will do some sql functionsallity

				List<Item> items = iDao.getItems();

				// BEN - enhanced for loop
				for (Item emp : items) {
					System.out.println(emp);
				}
				// System.out.println(employees);

				// log.info("USER RETRIVED LIST OF ALL EMPLOYEES");

				break;
			}
			
			case "buyers": {// get the List of Employees from the DAO layer
				// nothing is here yet, but will do some sql functionsallity

				List<Customers> customer = cDao.getCustomers();

				// BEN - enhanced for loop
				for (Customers emp : customer) {
					System.out.println(emp);
				}
				// System.out.println(employees);

				// log.info("USER RETRIVED LIST OF ALL EMPLOYEES");

				break;
			}
			
			case "shipFullLog": {// get the List of Employees from the DAO layer
				// nothing is here yet, but will do some sql functionsallity

				List<ShippingLog> shippingLog = slDao.createshipmentItems();

				// BEN - enhanced for loop
				for (ShippingLog emp : shippingLog) {
					System.out.println(emp.toString2());
				}
				// System.out.println(employees);

				// log.info("USER RETRIVED LIST OF ALL EMPLOYEES");

				break;
			}
			
			case "shippingLog": {// get the List of Employees from the DAO layer
				// nothing is here yet, but will do some sql functionsallity

				List<ShippingLog> shippingLog = slDao.createShippingLog();

				// BEN - enhanced for loop
				for (ShippingLog emp : shippingLog) {
					System.out.println(emp.toString1());
				}
				// System.out.println(employees);

				// log.info("USER RETRIVED LIST OF ALL EMPLOYEES");

				break;
			}
			
			case "transaction" : {
				
				System.out.println("What transaction would you like to search for?\n[Enter Shipping ID]: ");
				int idInput = scan.nextInt();
				scan.nextLine();//still need this to move to the next line
				
				//what if the user inputs a string? program crashes
				//if statement, try/catch
				//polish your project a bit and add some foll proofing
				//if a # run as normal, else if !# then reloop and ask for a number
				List<ShippingLog> transaction = slDao.getShippingLogById(idInput);
				
				//BEN - enhanced for loop
				for (ShippingLog emp : transaction) {
				System.out.println(emp.toString2());
				}
				break;
				
			}
			
			case "addItem":{
				
				/*
				 * System.out.println("This will affect records, are you sure you want to do this?\n[Enter 1 for yes/0 for no]");
				String dCheck = scan.next();
				scan.nextLine();//still need this to move to the next line
				
				if(dCheck.equals("no") || dCheck.equals("No")) {
					
					break;
				}else if (dCheck.equals("no") || dCheck.equals("No")) {
				 */
				System.out.println("What is the Item's name?");
				
				String itemName = scan.nextLine();
				
				System.out.println("What is the item's department from?(1-5)");
				//System.out.println("1-Techology");
				int departmentID = scan.nextInt();
				scan.nextLine();
				
				System.out.println("What is the Item's size(xxs-xxl)?");		
				String size = scan.nextLine();
				//what if the user inputs a string? program crashes
				//if statement, try/catch
				//polish your project a bit and add some foll proofing
				//if a # run as normal, else if !# then reloop and ask for a number
				
				System.out.println("What is the Item's cost(xx.xx)?");		
				Double cost = scan.nextDouble();
				scan.nextLine();
				
				System.out.println("How much of the item is being added(xx)?");		
				int amountStocked = scan.nextInt();
				scan.nextLine();
				
				System.out.println("What is the Item's selling price(xx.xx)?");		
				Double price = scan.nextDouble();
				scan.nextLine();
				
				//create a new Employee based on these inputs
				Item emp = new Item(itemName, departmentID, size, cost, amountStocked, price);//xxx is for hire_date. gets rewriteen in the DAO
				
				iDao.addItem(emp);
				System.out.println("***Completed***");
				
				break;
			}
			
			case "deleteItem": {
				
				System.out.println("This will affect records, are you sure you want to do this?\n[Enter: 1 for yes/0 for no]");
				String dCheck = scan.next();
				scan.nextLine();//still need this to move to the next line
				
				if(dCheck.equals("no") || dCheck.equals("No") || dCheck.equals("0")) {
					
					break;
				}else if (dCheck.equals("yes") || dCheck.equals("Yes") || dCheck.equals("1")) {
				
				System.out.println("What is the Item ID# to delete?");
				//what if the user inputs a string? program crashes
				//if statement, try/catch
				//polish your project a bit and add some foll proofing
				//if a # run as normal, else if !# then reloop and ask for a number
				int empID = scan.nextInt();
				scan.nextLine();
				
				iDao.removeItem(empID);
				System.out.println("***Completed***");
				
				log.warn("USER DELETED Item# " + empID);
				
				break;
				
			}
				System.out.println("you reached the end without the getting the checks!!");
				break;
			}
			
			case "updateBuyers": {
				System.out.println("This will affect records, are you sure you want to do this?\n[Enter: 1 for yes/0 for no]");
				String dCheck = scan.next();
				scan.nextLine();//still need this to move to the next line
				
				
				
				break;
			}

			case "exit": {
				displayMenu = false; // this is how we break out og the while loop, ending the menu display
				System.out.println("bye!! come again.");

				// log.warn("Closing main loop - " + displayMenu + " - DisplayMenu");

				break;

			}
			default: {
				System.out.println("that was incorrent input");
				break;
			}
			}// end of switch statement

		} // end of while loop

		System.out.println("Thank you for using our Krusty Crab EMS");
		scan.close();

	}// end of method

}// end of class

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

			//display tables
			System.out.println("items -> show all items");
			System.out.println("shipFullLog -> get both shippinglogs and transactions details");
			System.out.println("shippingLog -> get shippinglogs");
			System.out.println("buyers -> show buyers/suppliers");

			//special n hardest, most new and self maded
			//add transaction
			System.out.println("X|sell -> sell item");
			System.out.println("X|buy -> order item");
			
			// explain more details of items shipped
			System.out.println("transaction -> get info of one Shipment");
			System.out.println("lookUpItem -> get info of one Item");
			System.out.println("lookUpCustomer -> get info of one Customer");
			//show invudal info by ID
			//item
			//buyer
	
			
			// updateCustomerAdreess, updateCustomerAllInfo
			System.out.println("updateCustomerAdreess, or updateCustomerAllInfo -> update a customors info");
			System.out.println("addBuyers -> add new custmor info");

			//can update delete to have backup graveyard items table to put old items
			System.out.println("deleteItem -> remove Item to warehouse");
			System.out.println("addItem -> add new Item to warehouse");

			//more functions update/delete/add/show
			//update item (price?) (backup table with id, price, and date changed)
			//delete buyer (need backup table to hold loss info ID)
			//add log (buy or sell)
			//update or delete a log would be illegal?
			
		
			
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
			
			case "addBuyers": {

				System.out.println("What is the User's name?");
				String username = scan.nextLine();


				System.out.println("What is the User's address?");
				String address = scan.nextLine();
				// what if the user inputs a string? program crashes
				// if statement, try/catch
				// polish your project a bit and add some foll proofing
				// if a # run as normal, else if !# then reloop and ask for a number

				System.out.println("What is the User's PhoneNumber#?");
				String phoneNumber = scan.nextLine();
				

				// create a new Employee based on these inputs
				Customers emp = new Customers(username, address, phoneNumber);// xxx is for hire_date.
																								// gets rewriteen in the
																								// DAO

				cDao.addCustomer(emp);
				System.out.println("***Completed***");

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

			case "transaction": {

				System.out.println("What transaction would you like to search for?\n[Enter Shipping ID]: ");
				int idInput = scan.nextInt();
				scan.nextLine();// still need this to move to the next line

				// what if the user inputs a string? program crashes
				// if statement, try/catch
				// polish your project a bit and add some foll proofing
				// if a # run as normal, else if !# then reloop and ask for a number
				List<ShippingLog> transaction = slDao.getShippingLogById(idInput);

				// BEN - enhanced for loop
				for (ShippingLog emp : transaction) {
					System.out.println(emp.toString2());
				}
				break;

			}

			case "addItem": {

				/*
				 * System.out.
				 * println("This will affect records, are you sure you want to do this?\n[Enter 1 for yes/0 for no]"
				 * ); String dCheck = scan.next(); scan.nextLine();//still need this to move to
				 * the next line
				 * 
				 * if(dCheck.equals("no") || dCheck.equals("No")) {
				 * 
				 * break; }else if (dCheck.equals("no") || dCheck.equals("No")) {
				 */
				System.out.println("What is the Item's name?");

				String itemName = scan.nextLine();

				System.out.println("What is the item's department from?(1-5)");
				// System.out.println("1-Techology");
				int departmentID = scan.nextInt();
				scan.nextLine();

				System.out.println("What is the Item's size(xxs-xxl)?");
				String size = scan.nextLine();
				// what if the user inputs a string? program crashes
				// if statement, try/catch
				// polish your project a bit and add some foll proofing
				// if a # run as normal, else if !# then reloop and ask for a number

				System.out.println("What is the Item's cost(xx.xx)?");
				Double cost = scan.nextDouble();
				scan.nextLine();

				System.out.println("How much of the item is being added(xx)?");
				int amountStocked = scan.nextInt();
				scan.nextLine();

				System.out.println("What is the Item's selling price(xx.xx)?");
				Double price = scan.nextDouble();
				scan.nextLine();

				// create a new Employee based on these inputs
				Item emp = new Item(itemName, departmentID, size, cost, amountStocked, price);// xxx is for hire_date.
																								// gets rewriteen in the
																								// DAO

				iDao.addItem(emp);
				System.out.println("***Completed***");

				break;
			}
			
			case "deleteItem": {

				System.out.println(
						"This will affect records, are you sure you want to do this?\n[Enter: 1 for yes/0 for no]");
				String dCheck = scan.next();
				scan.nextLine();// still need this to move to the next line

				if (dCheck.equals("no") || dCheck.equals("No") || dCheck.equals("0")) {

					break;
				} else if (dCheck.equals("yes") || dCheck.equals("Yes") || dCheck.equals("1")) {

					System.out.println("What is the Item ID# to delete?");
					// what if the user inputs a string? program crashes
					// if statement, try/catch
					// polish your project a bit and add some foll proofing
					// if a # run as normal, else if !# then reloop and ask for a number
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

			case "updateCustomerAdreess": {

				System.out.println("What BuyerID do you want to update?");
				int titleInput = scan.nextInt();
				scan.nextLine();

				// what if the user inputs a string? program crashes
				// if statement, try/catch
				// polish your project a bit and add some foll proofing
				// if a # run as normal, else if !# then reloop and ask for a number

				System.out.println("Enter a new adress: ");
				String salaryInput = scan.nextLine();

				cDao.updateCustomerAdreess(titleInput, salaryInput);

				System.out.println("***Successful***");

				break;

			}

			case "updateCustomerAllInfo": {

				/*
				 * System.out.println("What salary would you like to update? (Role Title)");
				 * String titleInput = scan.nextLine();
				 * 
				 * //what if the user inputs a string? program crashes //if statement, try/catch
				 * //polish your project a bit and add some foll proofing //if a # run as
				 * normal, else if !# then reloop and ask for a number
				 * System.out.println("Enter a new Salary: "); int salaryInput = scan.nextInt();
				 * scan.nextLine();
				 * 
				 * rDao.updateSalary(titleInput, salaryInput);
				 * 
				 * System.out.println("***Successful***");
				 * 
				 * break;
				 */
				System.out.println("What salary would you like to update? (Role Title)");
				int customerID = scan.nextInt();
				scan.nextLine();

				// what if the user inputs a string? program crashes
				// if statement, try/catch
				// polish your project a bit and add some foll proofing
				// if a # run as normal, else if !# then reloop and ask for a number

				System.out.println("Enter a new Salary: ");
				String username = scan.nextLine();

				System.out.println("Enter a new Salary: ");
				String address = scan.nextLine();

				System.out.println("Enter a new Salary: ");
				String phoneNumber = scan.nextLine();

				cDao.updateCustomerAllInfo(customerID, username, address, phoneNumber);
				;

				System.out.println("***Successful***");

				break;
			}


			case "buy": {
				/*(just have to check if item alreat in stocked or adding a new item)
				 * buy something: bring soemthing in
				 * get user info of who buying from, check if they exist
				 * update shipping log
				 * get info(name/id) of items of interset, if alrady in stroage
				 * create or locate items being brought/brought in
				 * get info of transaction like quantity or price
				 * update shipmentItemsLog
				 * update items in storage
				 * 
				 * */
				System.out.println(
						"This will affect records, are you sure you want to do this?\n[Enter: 1 for yes/0 for no]");
				String dCheck = scan.next();
				scan.nextLine();// still need this to move to the next line

				break;
			}

			case "sell": {
				/*(no check needed cuz can only sell items in stock)
				 *  sell something: take items out
				 * get user info of who you selling to, check if they exist
				 * update shipping log
				 * get info of items of interset, if aviable
				 * locate items being brought/brought in
				 * update shipmentItemsLog
				 * update items in storage
				 * 
				 * */
				System.out.println(
						"This will affect records, are you sure you want to do this?\n[Enter: 1 for yes/0 for no]");
				String dCheck = scan.next();
				scan.nextLine();// still need this to move to the next line

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

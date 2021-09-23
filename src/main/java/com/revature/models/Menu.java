package com.revature.models;

import com.revature.dao.*;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Menu {

	ShippingLogDoa slDao = new ShippingLogDoa();
	CustomersDao cDao = new CustomersDao();
	ItemDao iDao = new ItemDao();

	Logger log = LogManager.getLogger(Menu.class);

	// All of menu options and control flow are contained within this method
	public void displayMenu() {

		boolean displayMenu = true;
		boolean displayMenu0 = true;
		boolean displayMenu1 = false;
		boolean displayMenu2 = false; // going to use this to toggle whether the menu continues after user input
		boolean logIn = false;
		// int in;
		Scanner scan = new Scanner(System.in);

		// pretty greeting :)
		System.out.println("\n=========================================================");
		System.out.println("Welcome to the Fred's Inventory Management System!");
		System.out.println("=========================================================\n");

		// display the menu as long as the displayMenu boolean is true
		while (displayMenu) {

			// To-Do:
			// put log tackers
			// fix up printed menu
			// debug safty checks
			// clean up code format

			// C-create/insert, R-read/select, U-update, D-delete

			System.out.println("-------------------");
			System.out.println("Choose an Option:");
			System.out.println("-------------------");

			if (displayMenu0 & !logIn) {
				System.out.println("logIn -> Display Options: ");
			}

			// System.out.println("more -> display more options: ");

			// more functions update/delete/add/show
			// **update item (price?) (backup table with id, price, and date changed)

			System.out.println("exit -> Exit application");

			// parse user input after they choose a menu option
			String input = scan.nextLine();

			// switch statement that takes the input and delivers the appropriate response
			// you may have a hard time reading allthis functionality
			// look at out dao layer interface to see everything the CLI is able to do

			switch (input) {

			case "items": {// get the List of Employees from the DAO layer
				// nothing is here yet, but will do some sql functionsallity

				List<Item> items = iDao.getItems();

				// BEN - enhanced for loop
				for (Item emp : items) {
					System.out.println(emp);
				}
				// System.out.println(employees);

				System.out.println("Departments' #: [--1:tech---2:house---:outdoors\n4:clothes---5:food---6:tools");
				System.out.println("\n");
				printMenu();

				log.info("USER RETRIVED LIST OF ALL ITEMS");

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

				System.out.println("\n");
				printMenu();

				log.info("USER RETRIVED LIST OF ALL CUSTOMERS");

				break;
			}

			case "addBuyers": {

				System.out.println("What is the User's name? [John Smith or Wallmart]");
				String username = scan.nextLine();

				System.out.println("What is the User's address?");
				String address = scan.nextLine();
				// what if the user inputs a string? program crashes
				// if statement, try/catch
				// polish your project a bit and add some foll proofing
				// if a # run as normal, else if !# then reloop and ask for a number

				System.out.println("What is the User's PhoneNumber? [#]");
				String phoneNumber = scan.nextLine();

				// create a new Employee based on these inputs
				Customers emp = new Customers(username, address, phoneNumber);// xxx is for hire_date.
																				// gets rewriteen in the
																				// DAO

				cDao.addCustomer(emp);
				System.out.println("***Completed***");
				log.info("USER ADDED NEW CUSTOMER");
				System.out.println("\n");
				printMenu();

				break;
			}

			case "shipFullLog": {// get the List of Employees from the DAO layer
				// nothing is here yet, but will do some sql functionsallity

				List<ShippingLog> shippingLog = slDao.createshipmentItems();

				// BEN - enhanced for loop
				for (ShippingLog emp : shippingLog) {
					System.out.println(emp.toString2());
				}

				System.out.println("\nDepartments' #: --1:tech\n2:house\n3:outdoors\n4:clothes\n5:food\n6:tools");
				// System.out.println(employees);

				System.out.println("\n");
				printMenu();

				log.info("USER RETRIVED LIST OF ALL SHIPMENT INFO");

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

				System.out.println("\n");
				printMenu();

				log.info("USER RETRIVED LIST OF ALL SHIPPING LOGS");

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

				System.out.println("\n");

				System.out.println("Departments' #: [--1:tech---2:house---:outdoors\n4:clothes---5:food---6:tools]");
				log.info("USER RETRIVED THE INFO OF SHIPMENT: " + idInput);
				printOthers();
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
				System.out.println("Departments' #: [--1:tech---2:house---:outdoors\n4:clothes---5:food---6:tools");

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
				log.info("USER ADD NEW ITEM INTO WAREHOUSE");
				printInserts();

				break;
			}

			case "deleteItem": {

				System.out.println(
						"This will affect records, are you sure you want to do this?\n[Enter: 1 for yes/0 for no]");
				String dCheck = scan.next();
				scan.nextLine();// still need this to move to the next line

				if (dCheck.equals("no") || dCheck.equals("No") || dCheck.equals("0")) {

					System.out.println("********ABORTING*******");

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

				// System.out.println("you reached the end without the getting the checks!!");
				printInserts();

				break;
			}

			case "updateCustomerAddress": {

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
				log.info("USER UPDATED CUSTOMER'S ADDRESS TO: " + salaryInput);
				printInserts();
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
				System.out.println("What User would you like to update? [ID#]");
				int customerID = scan.nextInt();
				scan.nextLine();

				// what if the user inputs a string? program crashes
				// if statement, try/catch
				// polish your project a bit and add some foll proofing
				// if a # run as normal, else if !# then reloop and ask for a number

				System.out.println("What is the new Username?[Wallmart or John Smith]");
				String username = scan.nextLine();

				System.out.println("What is the new address? ");
				String address = scan.nextLine();

				System.out.println("What is the User's new phone number? [#]");
				String phoneNumber = scan.nextLine();

				cDao.updateCustomerAllInfo(customerID, username, address, phoneNumber);
				;

				System.out.println("***Successful***");
				log.info("USER UPDATE ALL INFO OF CUSTOMER: " + customerID);
				printInserts();
				break;
			}

			case "buy": {
				/*
				 * (just have to check if item alreat in stocked or adding a new item) buy
				 * something: bring soemthing in get user info of who buying from, check if they
				 * exist update shipping log get info(name/id) of items of interset, if alrady
				 * in stroage create or locate items being brought/brought in get info of
				 * transaction like quantity or price update shipmentItemsLog update items in
				 * storage
				 * 
				 */
				String itemCheck = "0";
				int empID = 0;
				int temp = 0;
				int temp3 = 0;
				int temp4 = 0;
				double temp2 = 0;
				int counter = 0;
				System.out.println(
						"This will purchase more items and/or add more in stock?\n[Enter: 1 to continue/0 to abort]");
				String dCheck = scan.next();
				scan.nextLine();// still need this to move to the next line

				if (dCheck.equals("no") || dCheck.equals("No") || dCheck.equals("0")) {

					System.out.println("***Void transaction***");

				} else if (dCheck.equals("yes") || dCheck.equals("Yes") || dCheck.equals("1")) {

					// statment starts
					System.out.println("Who is buying this? [Enter ID#]");
					// what if the user inputs a string? program crashes
					// if statement, try/catch
					// polish your project a bit and add some foll proofing
					// if a # run as normal, else if !# then reloop and ask for a number
					int custID = scan.nextInt();
					scan.nextLine();

					// statment starts
					System.out.println("Is the Item already in stock if so enter ID#? [Enter ID# or 0]");
					// what if the user inputs a string? program crashes
					// if statement, try/catch
					// polish your project a bit and add some foll proofing
					// if a # run as normal, else if !# then reloop and ask for a number
					empID = scan.nextInt();
					scan.nextLine();

					List<Item> itemA = iDao.getItemById(empID);

					// BEN - enhanced for loop
					for (Item ID : itemA) {
						System.out.println(ID.toString());
						itemCheck = "yes";
						// System.out.println(itemCheck);
					}

					if (itemCheck.equals("no") || itemCheck.equals("No") || itemCheck.equals("0")) {

						System.out.println("What is this Item called? [Ex. Ipad]");
						// what if the user inputs a string? program crashes
						// if statement, try/catch
						// polish your project a bit and add some foll proofing
						// if a # run as normal, else if !# then reloop and ask for a number
						String itemName = scan.nextLine();

						System.out.println("What type of item is this?[Department #]");

						System.out.println("Departments' #: --1:tech\n2:house\n3:outdoors\n4:clothes\n5:food\n6:tools");
						// what if the user inputs a string? program crashes
						// if statement, try/catch
						// polish your project a bit and add some foll proofing
						// if a # run as normal, else if !# then reloop and ask for a number
						int departmentID = scan.nextInt();
						scan.nextLine();

						System.out.println("how big is this item [xxx]");
						// what if the user inputs a string? program crashes
						// if statement, try/catch
						// polish your project a bit and add some foll proofing
						// if a # run as normal, else if !# then reloop and ask for a number
						String size = scan.nextLine();

						System.out.println("how much does this item cost? [$$.$$]");
						// what if the user inputs a string? program crashes
						// if statement, try/catch
						// polish your project a bit and add some foll proofing
						// if a # run as normal, else if !# then reloop and ask for a number
						double cost = scan.nextDouble();
						scan.nextLine();

						System.out.println("How much of this item is being brought?");
						// what if the user inputs a string? program crashes
						// if statement, try/catch
						// polish your project a bit and add some foll proofing
						// if a # run as normal, else if !# then reloop and ask for a number
						int amountStocked = scan.nextInt();
						scan.nextLine();

						System.out.println("How much how will this item be solded? [$$.$$]");
						// what if the user inputs a string? program crashes
						// if statement, try/catch
						// polish your project a bit and add some foll proofing
						// if a # run as normal, else if !# then reloop and ask for a number
						double price = scan.nextDouble();
						scan.nextLine();

						iDao.addItem(itemName, departmentID, size, cost, amountStocked, price);

						slDao.addShippingLog(custID);

						List<Item> transactions = iDao.getItems();

						// BEN - enhanced for loop
						for (Item emp : transactions) {
							counter++;
							temp = counter;
							temp3 = emp.getItemID();

							// System.out.println("temp: " + temp + "\ntemp2: " + temp2 + "temp3: " + temp +
							// "\ncounter: "
							// + counter + "\n---------------------");
						}

						List<ShippingLog> transactionz = slDao.createShippingLog();

						// BEN - enhanced for loop
						counter = 0;
						for (ShippingLog emp : transactionz) {
							counter++;
							temp4 = counter;

							// System.out.println("temp2: " + temp2 + "\ncounter: " + counter +
							// "\n---------------------");
						}

						slDao.addShipmentLog(amountStocked, temp4, temp3, price);
						System.out.println("***Completed***");

						log.warn("Added Item# " + empID);

						System.out.println("***Inputing new item***");

					} else if (itemCheck.equals("yes") || itemCheck.equals("Yes") || itemCheck.equals("1")) {

						System.out.println("How much of this item is being brought?");
						// what if the user inputs a string? program crashes
						// if statement, try/catch
						// polish your project a bit and add some foll proofing
						// if a # run as normal, else if !# then reloop and ask for a number
						int stock = scan.nextInt();
						scan.nextLine();

						System.out.println("how much does this item cost?[$$.$$]");
						// what if the user inputs a string? program crashes
						// if statement, try/catch
						// polish your project a bit and add some foll proofing
						// if a # run as normal, else if !# then reloop and ask for a number
						double cost = scan.nextDouble();
						scan.nextLine();

						iDao.updatAddItemStock(empID, stock);
						slDao.addShippingLog(custID);

						List<ShippingLog> transaction = slDao.createShippingLog();

						// BEN - enhanced for loop
						for (ShippingLog emp : transaction) {
							counter++;
							temp4 = counter;
							temp3 = emp.getItemID();

							// System.out.println("fristloop" + "temp: " + temp + "\ntemp2: " + temp2 +
							// "temp3: " + temp
							// + "\ncounter: " + counter + "\n---------------------");
						}

						List<ShippingLog> transactions = slDao.createshipmentItems();

						// BEN - enhanced for loop
						counter = 0;
						for (ShippingLog emp : transaction) {
							counter++;
							temp = counter;
							temp2 = emp.getPrice();

							// System.out.println("secondloop" + "temp: " + temp + "\ncounter: " + counter
							// + "\n---------------------");
						}

						List<Item> transactionsz = iDao.getItemById(empID);

						// BEN - enhanced for loop
						for (Item emp : transactionsz) {
							temp3 = emp.getItemID();
							temp2 = emp.getPrice();

							// System.out.println("thirdloop" + "temp: " + temp + "\ncounter: " + counter
							// + "\n---------------------");
						}

						slDao.addShipmentLog(stock, temp4, empID, temp2);
						System.out.println("***Completed***");

						log.warn("Added Item# " + empID);

					}
				}
				System.out.println("\n");
				printMenu();
				break;
			}

			case "sell": {
				/*
				 * (no check needed cuz can only sell items in stock) sell something: take items
				 * out get user info of who you selling to, check if they exist update shipping
				 * log get info of items of interset, if aviable locate items being
				 * brought/brought in update shipmentItemsLog update items in storage
				 * 
				 */
				int empID = 0;

				System.out.println(
						"This will change our invertory, are you sure you want to do this?\n[Enter: 1 for yes/0 for no]");
				String dCheck = scan.next();
				scan.nextLine();// still need this to move to the next line

				if (dCheck.equals("no") || dCheck.equals("No") || dCheck.equals("0")) {

					System.out.println("***Void transaction***");

				} else if (dCheck.equals("yes") || dCheck.equals("Yes") || dCheck.equals("1")) {

					// statment starts
					System.out.println("Who is buying this? [Enter User-ID#]");
					// what if the user inputs a string? program crashes
					// if statement, try/catch
					// polish your project a bit and add some foll proofing
					// if a # run as normal, else if !# then reloop and ask for a number
					int custID = scan.nextInt();
					scan.nextLine();

					System.out.println("What item is being sold? [Enter Item-ID#]");
					// what if the user inputs a string? program crashes
					// if statement, try/catch
					// polish your project a bit and add some foll proofing
					// if a # run as normal, else if !# then reloop and ask for a number
					empID = scan.nextInt();
					scan.nextLine();
					int temp = 0;
					double temp2 = 0;
					int counter = 0;

					System.out.println("How much of the item is being sold? [Enter amount]");
					// what if the user inputs a string? program crashes
					// if statement, try/catch
					// polish your project a bit and add some foll proofing
					// if a # run as normal, else if !# then reloop and ask for a number
					int stock = scan.nextInt();
					scan.nextLine();

					iDao.updateItemStock(empID, stock);
					slDao.addShippingLog(custID);

					List<ShippingLog> transaction = slDao.createShippingLog();

					// BEN - enhanced for loop
					for (ShippingLog emp : transaction) {
						counter++;
						temp = counter;
						temp2 = emp.getPrice();

						// System.out.println("temp: " + temp + "\ntemp2: " + temp2 + "\ncounter: " +
						// counter + "\n---------------------");
					}

					slDao.addShipmentLog(stock, temp, empID, temp2);

				}
				log.info("USER SOLD ITEM: " + empID);
				System.out.println("\n");
				printMenu();
				break;
			}

			case "logIn": {

				input = "more";
				log.info("USER LOGGED IN");

			}

			case "more": {
				// System.out.println("\n==============================================\n");
				// System.out.println("display more options: ");
				if (displayMenu0 && !displayMenu1) {
					displayMenu1 = true;
					displayMenu0 = false;
					displayMenu2 = false;
					logIn = true;

					printMenu();

					if (!displayMenu1) {
						printMenu();
					}

					// System.out.println("\n==============================================\n");

				} else if (displayMenu1 && !displayMenu2) {
					displayMenu2 = true;
					displayMenu0 = false;
					displayMenu1 = false;
					logIn = true;

					printInserts();

				} else {
					displayMenu0 = true;
					displayMenu1 = false;
					displayMenu2 = false;
					logIn = true;
					// System.out.println("0: " + displayMenu0 + " 1: " + displayMenu1 + " 2: " +
					// displayMenu2 + " main: " + displayMenu);

					printOthers();

					// System.out.println("\n==============================================\n");
				}

				break;

			}

			case "exit": {
				displayMenu = false; // this is how we break out og the while loop, ending the menu display
				System.out.println("Logging off");
				// print();

				log.warn("Closing main loop|| " + displayMenu + " = DisplayMenu");

				break;

			}
			default: {
				System.out.println("that was incorrent input");
				break;
			}
			}// end of switch statement

		} // end of while loop

		log.info("USER LOGGING OFF");
		System.out.println("Thank you for using our I&SM System");
		scan.close();

	}// end of method

	public void printMenu() {
		System.out.println("\nDisplay main options: ");

		System.out.println("\n=======================(Display [Read tables] )=======================\n");
		// display tables
		System.out.println("items -> show all items.");
		System.out.println("shipFullLog -> get all transactions details.");
		System.out.println("shippingLog -> get shippinglogs.");
		System.out.println("buyers -> show all buyers and suppliers.");

		System.out.println("\n======================(Transactions [Insert or update] )========================\n");

		// special n hardest, most new and self maded
		// add transaction
		System.out.println("addBuyers -> add new customer info");
		System.out.println("sell -> sell item");
		System.out.println("buy -> order item");

		System.out.println("\nmore -> display more options: \n");

	}

	public void printInserts() {
		System.out.println("\nDisplay Add/Delete options: ");

		System.out.println("\n========================(Modfiy Inventory [Delete or Insert] )======================\n");

		System.out.println("deleteItem -> remove Item to warehouse");
		System.out.println("addItem -> add new Item to warehouse");

		System.out.println("\n=======================( Update info. )=======================\n");

		// updateCustomerAdreess, updateCustomerAllInfo
		System.out.println(
				"updateCustomerAddress -> update a customors info\nupdateCustomerAllInfo -> update a customors info");
		// *delete buyer (need backup table to hold loss info ID)

		// can update delete to have backup graveyard items table to put old items
		// System.out.println("X|updateItemPrice -> update a item
		// info\nX|updateItemAllInfo -> update a item info");

		// System.out.println("\n==============================================\n");

		System.out.println("\nmore -> display more options: \n");

	}

	public void printOthers() {
		System.out.println("\nDisplay Search options: ");

		System.out.println("\n========================(Look up specfic info. [Read])======================\n");
		System.out.println("transaction -> get info of one Shipment");

		// System.out.println("X|lookUpItem -> get info of one Item");
		// System.out.println("X|lookUpCustomer -> get info of one Customer");

		System.out.println("\nmore -> display more options: \n");

	}
}// end of class

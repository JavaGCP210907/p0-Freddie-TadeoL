package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.Menu;
import com.revature.utils.ConnectionUtil;

public class Driver {
	
	public static void main(String[] args) {
		
		Logger log = LogManager.getLogger(Menu.class);


		//System.out.println("\n=========================================================");
		//System.out.println("Welcome");
		//System.out.println("=========================================================\n");

		// Create menu object

		try (Connection conn = ConnectionUtil.getConnection()) {
			System.out.println("First Connection was successful");
			log.info("USER CONNECTED");
		} catch (SQLException e) {
			System.out.println("connection failed, did not connect to postgresql database");
			e.printStackTrace();
		}

		Menu menu = new Menu();

		// use the menu's displayMenu() method to use the menu
		menu.displayMenu();

	}

}

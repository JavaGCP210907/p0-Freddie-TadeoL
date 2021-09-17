package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	//This method will eventually return an object of type Connection, which we'll use to connect to our database
		public static Connection getConnection() throws SQLException{
			
			//For compatinility with other technologies/frameworks, we'll need to register our PostgreSQL driver
			//This makes the application aware of what driver class we're using
			
			try {
				Class.forName("org.postgresql.Driver");//searching for the postgres driver, which is from dependency
			} catch(ClassNotFoundException e) {
				e.printStackTrace(); //tells us what went wrong;
			}
			
			//to like not hardcode like below,
			String url = System.getenv("url");
			String username = System.getenv("username");
			String password = System.getenv("password");
				
			
			return DriverManager.getConnection(url, username, password);
	
	
}
		
}

package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Item;
import com.revature.models.ShippingLog;
import com.revature.utils.ConnectionUtil;

public class ShippingLogDoa implements ShippingLogDaoInterface  {

	//C-create/insert, R-read/select, U-update, D-delete
	
	@Override
	public List<ShippingLog> createShippingLog() {
		// TODO Auto-generated method stub
		try (Connection conn = ConnectionUtil.getConnection()) {

			// initilaize an REsultSet object. this will sotre the results we get from DB
			ResultSet rs = null;

			// write out SQL query and store it in a String
			String sql = "select * from shippingLog";
			// if you have capital letters in your schema,
			// String sql = "SELECT * FROM \”schema_name”\.employees";
			// String sql = "select * from \”Krusty_Crab”\.employees";

			
			// put the SQL query into a Statement object
			Statement s = conn.createStatement();

			// Execute the query, putting results into our ResultSet object
			// the statement object has a method that takes String to execute as a SQL query
			rs = s.executeQuery(sql);

			// All the code above ^^ makes a call to our database .... Now we need to store
			// the data in a List

			// create an empty LIst to be filled with the data from the database
			List<ShippingLog> shippingLogList = new ArrayList<>();

			while (rs.next()) {// while there are results in the result set..

				// create a new employee object from each returned row...
				ShippingLog e = new ShippingLog(rs.getInt("shipmentID"), rs.getInt("customerID"));
				/*
				 * this.employee_id = employee_id; this.first_name = first_name; this.last_name
				 * = last_name; this.hire_date = hire_date; this.role_id = role_id;
				 */

				/*
				 * private int itemID; private String itemName; private int departmentID;
				 * private char size; private double cost; private int amountStocked; private
				 * double price;
				 */

				// and populate the ArrayList with each new Employee object
				shippingLogList.add(e);// e is the new Employee object we created above

			}
			// when there are no more results in the ResultSet the while loop will break...
			// return the populated List of Employees
			return shippingLogList;

		} catch (SQLException e) {
			System.out.println("something went wrong with your database");
			e.printStackTrace();
		}

		// we need this after the try/catch so java wont yell
		return null;
	}


	@Override
	public List<ShippingLog> createshipmentItems() {
		// TODO Auto-generated method stub
				try (Connection conn = ConnectionUtil.getConnection()) {

					// initilaize an REsultSet object. this will sotre the results we get from DB
					ResultSet rs = null;

					// write out SQL query and store it in a String
					String sql = "select * from shipmentItems";
					// if you have capital letters in your schema,
					// String sql = "SELECT * FROM \”schema_name”\.employees";
					// String sql = "select * from \”Krusty_Crab”\.employees";

					
					// put the SQL query into a Statement object
					Statement s = conn.createStatement();

					// Execute the query, putting results into our ResultSet object
					// the statement object has a method that takes String to execute as a SQL query
					rs = s.executeQuery(sql);

					// All the code above ^^ makes a call to our database .... Now we need to store
					// the data in a List

					// create an empty LIst to be filled with the data from the database
					List<ShippingLog> shippingLogList = new ArrayList<>();

					while (rs.next()) {// while there are results in the result set..

						// create a new employee object from each returned row...
						ShippingLog e = new ShippingLog(
								// we want to use rs.getXYZ for each column in the record
								rs.getInt("quantity"), rs.getInt("shipmentID"), 
								rs.getInt("itemID"), rs.getDouble("price"));
						/*
						 * this.employee_id = employee_id; this.first_name = first_name; this.last_name
						 * = last_name; this.hire_date = hire_date; this.role_id = role_id;
						 */

						/*
						 * private int itemID; private String itemName; private int departmentID;
						 * private char size; private double cost; private int amountStocked; private
						 * double price;
						 */

						// and populate the ArrayList with each new Employee object
						shippingLogList.add(e);// e is the new Employee object we created above

					}
					// when there are no more results in the ResultSet the while loop will break...
					// return the populated List of Employees
					return shippingLogList;

				} catch (SQLException e) {
					System.out.println("something went wrong with your database");
					e.printStackTrace();
				}

				// we need this after the try/catch so java wont yell
				return null;

}


	@Override
	public List<ShippingLog> getShippingLog() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<ShippingLog> getshipmentItems() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<ShippingLog> getShippingLogByName(String title) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<ShippingLog> getShippingLogById(int id) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			ResultSet rs = null;

			String sql = "select * from shipmentItems where shipmentID = ?";

			// when we need parameters we need to use a PREPARED statement, as opposed to a
			// statement (seen above)
			PreparedStatement ps = conn.prepareStatement(sql);

			// insert the methods argument (int id) as the first(and only) variable in our
			// SQL query
			ps.setInt(1, id);

			rs = ps.executeQuery();

			// create an empty LIst to be filled with the data from the database
			List<ShippingLog> shippingLogList = new ArrayList<>();
			
			//we dont need this while loop since only returning one result... but try to refractor this or make it its own method
			while (rs.next()) {// while there are results in the result set..

				// create a new employee object from each returned row...
				ShippingLog e = new ShippingLog(
						// we want to use rs.getXYZ for each column in the record
						rs.getInt("quantity"), rs.getInt("shipmentID"), 
						rs.getInt("itemID"), rs.getDouble("price"));

				// and populate the ArrayList with each new Employee object
				shippingLogList.add(e);// e is the new Employee object we created above

			}
			// when there are no more results in the ResultSet the while loop will break...
			// return the populated List of Employees
			return shippingLogList;

		} catch (SQLException e) {
			System.out.println("something went wrong with your database");
			e.printStackTrace();
		}

		return null;
	}


	@Override
	public void addShippingLog(ShippingLog shippingLog) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void removeShippingLog(int id) {
		// TODO Auto-generated method stub
		
	}

	
}

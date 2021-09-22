package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.revature.models.Item;
import com.revature.utils.ConnectionUtil;

public class ItemDao implements ItemDaoInterface {

	// C-create/insert, R-read/select, U-update, D-delete

	@Override
	public List<Item> getItems() {
		// TODO Auto-generated method stub
		try (Connection conn = ConnectionUtil.getConnection()) {

			// initilaize an REsultSet object. this will sotre the results we get from DB
			ResultSet rs = null;

			// write out SQL query and store it in a String
			String sql = "select * from items";
			// if you have capital letters in your schema,
			// String sql = "SELECT * FROM \�schema_name�\.employees";
			// String sql = "select * from \�Krusty_Crab�\.employees";

			// put the SQL query into a Statement object
			Statement s = conn.createStatement();

			// Execute the query, putting results into our ResultSet object
			// the statement object has a method that takes String to execute as a SQL query
			rs = s.executeQuery(sql);

			// All the code above ^^ makes a call to our database .... Now we need to store
			// the data in a List

			// create an empty LIst to be filled with the data from the database
			List<Item> itemList = new ArrayList<>();

			while (rs.next()) {// while there are results in the result set..

				// create a new employee object from each returned row...
				Item e = new Item(
						// we want to use rs.getXYZ for each column in the record
						rs.getInt("itemID"), rs.getString("itemName"), rs.getInt("departmentID"), rs.getString("size"),
						rs.getDouble("cost"), rs.getInt("amountStocked"), rs.getDouble("price"));
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
				itemList.add(e);// e is the new Employee object we created above

			}
			// when there are no more results in the ResultSet the while loop will break...
			// return the populated List of Employees
			return itemList;

		} catch (SQLException e) {
			System.out.println("something went wrong with your database");
			e.printStackTrace();
		}

		// we need this after the try/catch so java wont yell
		return null;
	}

	@Override
	public List<Item> getItemByName(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> getItemById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addItem(Item item) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			// write out SQL query and store it in a String
			String sql = "insert into items (itemName, departmentID, size, cost, amountStocked, price)"
					+ "values (?, ?, ?, ?, ?, ?)";// line break a sql statement in java by concatenation (not the +)

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, item.getItemName());
			ps.setInt(2, item.getDepartmentID());
			ps.setString(3, item.getSize());
			ps.setDouble(4, item.getCost());
			ps.setInt(5, item.getAmountStocked());
			ps.setDouble(6, item.getPrice());

			ps.executeUpdate();// for anything that is not a Select statement, we use executeUpdate()

			// send confirmation to the console if successful
			System.out.println("Item was created successful. \n" + "Item: " + item.getItemName());

		} catch (SQLException e) {
			System.out.println("something went wrong with your database");
			e.printStackTrace();
		}

	}

	/*
	@Override
	public void addItem(int itemID) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			// write out SQL query and store it in a String
			String sql = "insert into items (itemName, departmentID, size, cost, amountStocked, price)"
					+ "values (?, ?, ?, ?, ?, ?)";// line break a sql statement in java by concatenation (not the +)

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, item.getItemName());
			ps.setInt(2, item.getDepartmentID());
			ps.setString(3, item.getSize());
			ps.setDouble(4, item.getCost());
			ps.setInt(5, item.getAmountStocked());
			ps.setDouble(6, item.getPrice());

			ps.executeUpdate();// for anything that is not a Select statement, we use executeUpdate()

			// send confirmation to the console if successful
			System.out.println("Item was created successful. \n" + "Item: " + item.getItemName());

		} catch (SQLException e) {
			System.out.println("something went wrong with your database");
			e.printStackTrace();
		}

	}
*/
	
	@Override
	public void removeItem(int id) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "delete from items where itemID = ?";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, id);
			ps.executeUpdate();

			System.out.println("Enter the ItemID#: " + id);

		} catch (SQLException e) {
			System.out.println("You can't fire me i quit!");
			System.out.println("something went wrong with your database");
			e.printStackTrace();
		}
	}

	@Override
	public void updateItem(Item item) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateItemAllInfo(int itemID, String itemName, int departmentID, String size, Double cost,
			int amountStocked, double price) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateItemStock(int itemID, int amountStocked) {
		// TODO Auto-generated method stub

	}
}

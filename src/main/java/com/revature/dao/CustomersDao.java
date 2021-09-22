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
import com.revature.models.Customers;
import com.revature.models.ShippingLog;
import com.revature.utils.ConnectionUtil;

public class CustomersDao implements CustomersDaoInterface {

	// C-create/insert, R-read/select, U-update, D-delete

	@Override
	public List<Customers> getCustomers() {
		// TODO Auto-generated method stub
		try (Connection conn = ConnectionUtil.getConnection()) {

			// initilaize an REsultSet object. this will sotre the results we get from DB
			ResultSet rs = null;

			// write out SQL query and store it in a String
			String sql = "select * from buyers";
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
			List<Customers> custList = new ArrayList<>();

			while (rs.next()) {// while there are results in the result set..

				// create a new employee object from each returned row...
				Customers e = new Customers(
						// we want to use rs.getXYZ for each column in the record
						rs.getInt("customerID"), rs.getString("username"), rs.getString("address"),
						rs.getString("phonenumber"));
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
				custList.add(e);// e is the new Employee object we created above

			}
			// when there are no more results in the ResultSet the while loop will break...
			// return the populated List of Employees
			return custList;

		} catch (SQLException e) {
			System.out.println("something went wrong with your database");
			e.printStackTrace();
		}

		// we need this after the try/catch so java wont yell
		return null;
	}

	@Override
	public List<Customers> getCustomerByName(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customers> getCustomerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCustomer(Customers Customer) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			// write out SQL query and store it in a String
			String sql = "insert into buyers (username, address, phoneNumber)" + "values (?, ?, ?)";// line break a sql
																									// statement in java
																									// by concatenation
																									// (not the +)

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, Customer.getUsername());
			ps.setString(2, Customer.getAddress());
			ps.setString(3, Customer.getPhoneNumber());

			ps.executeUpdate();// for anything that is not a Select statement, we use executeUpdate()

			// send confirmation to the console if successful
			System.out.println("Customer was created successful. \n" + "Customer: " + Customer.getUsername());

		} catch (SQLException e) {
			System.out.println("something went wrong with your database");
			e.printStackTrace();
		}

	}

	@Override
	public void removeCustomer(int id) {
		// TODO Auto-generated method stub

	}

	/*
	 * 
	 * String sql requsting varbles used (?, ?, ?) (^^like_above^^) prepared
	 * statment to get new info execute print out
	 * 
	 * nested inside switch to go to get columne
	 * 
	 * down here some catch
	 * ------------------------------------------------------------------
	 * 
	 *
	 * try(Connection conn = ConnectionUtil.getConnection()){
	 * 
	 * // write out SQL query and store it in a String String sql =
	 * "insert into items (itemName, departmentID, size, cost, amountStocked, price)"
	 * + "values (?, ?, ?, ?, ?, ?)";//line break a sql statement in java by
	 * concatenation (not the +)
	 * 
	 * 
	 * PreparedStatement ps = conn.prepareStatement(sql);
	 * 
	 * ps.setString(1, item.getItemName()); ps.setInt(2, item.getDepartmentID());
	 * ps.setString(3, item.getSize()); ps.setDouble(4, item.getCost());
	 * ps.setInt(5, item.getAmountStocked()); ps.setDouble(6, item.getPrice());
	 * 
	 * 
	 * ps.executeUpdate();//for anything that is not a Select statement, we use
	 * executeUpdate()
	 * 
	 * //send confirmation to the console if successful
	 * System.out.println("Item was created successful. \n" + "Item: " +
	 * item.getItemName());
	 * 
	 * } catch (SQLException e) {
	 * System.out.println("something went wrong with your database");
	 * e.printStackTrace(); }
	 */

	/*
	 * try (Connection conn = ConnectionUtil.getConnection()) {
	 * 
	 * String sql = "delete from items where itemID = ?";
	 * 
	 * PreparedStatement ps = conn.prepareStatement(sql);
	 * 
	 * ps.setInt(1, id); ps.executeUpdate();
	 * 
	 * System.out.println("Enter the ItemID#: " + id);
	 * 
	 * 
	 * }catch (SQLException e) { System.out.println("You can't fire me i quit!");
	 * System.out.println("something went wrong with your database");
	 * e.printStackTrace(); }
	 */

	@Override
	public void updateCustomerAllInfo(int customerID, String username, String address, String phoneNumber) {

		try (Connection conn = ConnectionUtil.getConnection()) {

			// UPDATE avengers SET active = FALSE WHERE hero_name = 'Hulk';
			// String sql = "update roles set role_salary = ? where role_title = ?";

			// UPDATE buyers SET username= 'nerdstop', address= 'test', phonenumber=
			// '444-555-654' WHERE customerid= 1;
			String sql = "update buyers set username = ?, address= ?, phonenumber= ? where customerid = ?";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, username);
			ps.setString(2, address);
			ps.setString(3, phoneNumber);
			ps.setInt(4, customerID);

			ps.executeUpdate();

			System.out.println("user: " + customerID + " info has been updated");

		} catch (SQLException e) {
			System.out.println("Updating your info has failed");
			e.printStackTrace();
		}

	}

	@Override
	public void updateCustomerAdreess(int customerID, String address) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			// UPDATE avengers SET active = FALSE WHERE hero_name = 'Hulk';
			// String sql = "update roles set role_salary = ? where role_title = ?";
			String sql = "update buyers set address = ? where customerid = ?";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, address);
			ps.setInt(2, customerID);

			ps.executeUpdate();

			System.out.println("user: " + customerID + " address has been updated to: " + address);

		} catch (SQLException e) {
			System.out.println("Updating your info has failed");
			e.printStackTrace();
		}

	}

	@Override
	public void updateCustomer(Customers Customer) {
		// TODO Auto-generated method stub

	}

}

package com.revature.dao;

import java.util.List;

import com.revature.models.ShippingLog;

public interface ShippingLogDaoInterface {

	// C-create/insert, R-read/select, U-update, D-delete

	// SELECT *
	public List<ShippingLog> getShippingLog();// return a list of all employees

	// SELECT *
	public List<ShippingLog> createShippingLog();// return a list of all employees

	// SELECT *
	public List<ShippingLog> getshipmentItems();// return a list of all employees

	// SELECT *
	public List<ShippingLog> createshipmentItems();// return a list of all employees

	// SELECT WHERE
	public List<ShippingLog> getShippingLogByName(String title); // This will get employees with a certain role

	public List<ShippingLog> getShippingLogById(int id);

	// INSERT
	public void addShippingLog(int custID); // this will add an employee to the database

	public void addShipmentLog(int quantity, int shipmentID, int itemID, double price); // this will add an employee to
																						// the database

	// DELETE
	public void removeShippingLog(int id); // this will remove employees using their id

	List<ShippingLog> getAShipLogById(int id);

}

package com.revature.dao;

import java.util.List;

import com.revature.models.Item;
import com.revature.models.Customers;
import com.revature.models.ShippingLog;

public interface CustomersDaoInterface {

	// C-create/insert, R-read/select, U-update, D-delete

	// SELECT *
	public List<Customers> getCustomers();// return a list of all employees

	// SELECT WHERE
	public List<Customers> getCustomerByName(String title); // This will get employees with a certain role

	public List<Customers> getCustomerById(int id);

	// INSERT
	public void addCustomer(Customers Customer); // this will add an employee to the database

	// UPDATE
	// UPDATE avengers SET active = FALSE WHERE hero_name = 'Hulk';
	public void updateCustomer(Customers Customer);

	public void updateCustomerAllInfo(int customerID, String username, String address, String phoneNumber);

	public void updateCustomerAdreess(int customerID, String address);

	// DELETE
	public void removeCustomer(int id); // this will remove employees using their id

}

package com.revature.dao;

import java.util.List;

import com.revature.models.Customers;
import com.revature.models.Item;

public interface ItemDaoInterface {
	
	//C-create/insert, R-read/select, U-update, D-delete

	//SELECT *
		public List<Item> getItems();//return a list of all employees
		
		//SELECT WHERE
		public List<Item> getItemByName(String title); //This will get employees with a certain role
		
		public List<Item> getItemById(int id);
		
		//INSERT
		public void addItem(Item item); //this will add an employee to the database
		
		//DELETE
		public void removeItem(int id); // this will remove employees using their id

		//public void addItem(int itemID);
		
		//update
		public void updateItem(Item item);
		public void updateItemAllInfo(int itemID, String itemName, int departmentID, String size, Double cost, int amountStocked, double price);
		public void updateItemStock(int itemID, int amountStocked);
		
	
}

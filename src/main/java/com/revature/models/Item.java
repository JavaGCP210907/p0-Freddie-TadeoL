package com.revature.models;

public class Item {

	// fields for the Item class - must match those in your database
	private int itemID;
	private String itemName;
	private int departmentID;
	private String size;
	private double cost;
	private int amountStocked;
	private double price;

	// constustors and boilerplate code below----------------------

	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param itemID
	 * @param itemName
	 * @param departmentID
	 * @param size
	 * @param cost
	 * @param amountStocked
	 * @param price
	 */
	public Item(int itemID, String itemName, int departmentID, String size, double cost, int amountStocked,
			double price) {
		super();
		this.itemID = itemID;
		this.itemName = itemName;
		this.departmentID = departmentID;
		this.size = size;
		this.cost = cost;
		this.amountStocked = amountStocked;
		this.price = price;
	}

	/**
	 * @param itemName
	 * @param departmentID
	 * @param size
	 * @param cost
	 * @param amountStocked
	 * @param price
	 */
	public Item(String itemName, int departmentID, String size, double cost, int amountStocked, double price) {
		super();
		this.itemName = itemName;
		this.departmentID = departmentID;
		this.size = size;
		this.cost = cost;
		this.amountStocked = amountStocked;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [itemID=" + itemID + ", itemName=" + itemName + ", departmentID=" + departmentID + ", size=" + size
				+ ", cost=" + cost + ", amountStocked=" + amountStocked + ", price=" + price + "]";
	}

	/**
	 * @return the itemID
	 */
	public int getItemID() {
		return itemID;
	}

	/**
	 * @param itemID the itemID to set
	 */
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * @return the departmentID
	 */
	public int getDepartmentID() {
		return departmentID;
	}

	/**
	 * @param departmentID the departmentID to set
	 */
	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}

	/**
	 * @return the size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}

	/**
	 * @return the amountStocked
	 */
	public int getAmountStocked() {
		return amountStocked;
	}

	/**
	 * @param amountStocked the amountStocked to set
	 */
	public void setAmountStocked(int amountStocked) {
		this.amountStocked = amountStocked;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amountStocked;
		long temp;
		temp = Double.doubleToLongBits(cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + departmentID;
		result = prime * result + itemID;
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (amountStocked != other.amountStocked)
			return false;
		if (Double.doubleToLongBits(cost) != Double.doubleToLongBits(other.cost))
			return false;
		if (departmentID != other.departmentID)
			return false;
		if (itemID != other.itemID)
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		return true;
	}

}

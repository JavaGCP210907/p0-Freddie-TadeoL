package com.revature.models;

public class ShippingLog {

	// shippinglog table
	// shipmentID int PRIMARY KEY,
	// customerID int REFERENCES buyers (customerID)

	// ******************************************
	// shipmentItems table
	// quantity int,
	// shipmentID int REFERENCES shippingLog (shipmentID),
	// itemID int REFERENCES items (itemID), -- FOREIGN KEY: establishes a
	// relationship
	// price decimal,
	// PRIMARY KEY (shipmentID, itemID)

	private int shipmentID;
	private int customerID;
	private int quantity;
	private int itemID;
	private double price;

	// ***************Bolierplate code*********************

	/**
	 * 
	 */
	public ShippingLog() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param shipmentID
	 * @param customerID
	 */
	public ShippingLog(int shipmentID, int customerID) {
		super();
		this.shipmentID = shipmentID;
		this.customerID = customerID;
	}

	/**
	 * @param shipmentID
	 * @param customerID
	 * @param quantity
	 * @param itemID
	 * @param price
	 */
	public ShippingLog(int shipmentID, int customerID, int quantity, int itemID, double price) {
		super();
		this.shipmentID = shipmentID;
		this.customerID = customerID;
		this.quantity = quantity;
		this.itemID = itemID;
		this.price = price;
	}

	/**
	 * @param quantity
	 * @param shipmentID
	 * @param itemID
	 * @param price
	 */
	public ShippingLog(int quantity, int shipmentID, int itemID, double price) {
		super();
		this.quantity = quantity;
		this.shipmentID = shipmentID;
		this.itemID = itemID;
		this.price = price;
	}

	/**
	 * @return the shipmentID
	 */
	public int getShipmentID() {
		return shipmentID;
	}

	/**
	 * @param shipmentID the shipmentID to set
	 */
	public void setShipmentID(int shipmentID) {
		this.shipmentID = shipmentID;
	}

	/**
	 * @return the customerID
	 */
	public int getCustomerID() {
		return customerID;
	}

	/**
	 * @param customerID the customerID to set
	 */
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
	public String toString() {
		return "ShippingLog [shipmentID=" + shipmentID + ", customerID=" + customerID + ", quantity=" + quantity
				+ ", itemID=" + itemID + ", price=" + price + "]";
	}

	public String toString1() {
		return "ShippingLog [shipmentID=" + shipmentID + ", customerID=" + customerID + "]";
	}

	public String toString2() {
		return "ShippingLog [shipmentID=" + shipmentID + ", quantity=" + quantity + ", itemID=" + itemID + ", price="
				+ price + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + customerID;
		result = prime * result + itemID;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + quantity;
		result = prime * result + shipmentID;
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
		ShippingLog other = (ShippingLog) obj;
		if (customerID != other.customerID)
			return false;
		if (itemID != other.itemID)
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (quantity != other.quantity)
			return false;
		if (shipmentID != other.shipmentID)
			return false;
		return true;
	}

}

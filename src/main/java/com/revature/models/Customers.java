package com.revature.models;

public class Customers {

	private int customerID;
	private String username;
	private String address;
	private String phoneNumber;

	// ************BolierPlate code*****************

	/**
	 * 
	 */
	public Customers() {
		super();
		// TODO Auto-generated constructor stub
	}

	// all args
	/**
	 * @param customerID
	 * @param username
	 * @param address
	 * @param phoneNumber
	 */
	public Customers(int customerID, String username, String address, String phoneNumber) {
		super();
		this.customerID = customerID;
		this.username = username;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	// momst args but not customerID
	/**
	 * @param username
	 * @param address
	 * @param phoneNumber
	 */
	public Customers(String username, String address, String phoneNumber) {
		super();
		this.username = username;
		this.address = address;
		this.phoneNumber = phoneNumber;
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
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Customers [customerID=" + customerID + ", username=" + username + ", address=" + address
				+ ", phoneNumber=" + phoneNumber + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + customerID;
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Customers other = (Customers) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (customerID != other.customerID)
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}

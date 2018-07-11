package com.bridgelabz.main;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;


public class Employee  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	 * @param firstName
	 * @param lastName
	 * @param contactNo
	 */
	public Employee(int id,String firstName, String lastName, String contactNo) {
		super();
		this.id=id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNo = contactNo;
	}
	private int id;
	private String firstName;
	private String lastName;
	private String contactNo;
	public Employee() {
		super();
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the contactNo
	 */
	public String getContactNo() {
		return contactNo;
	}
	/**
	 * @param contactNo the contactNo to set
	 */
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
}
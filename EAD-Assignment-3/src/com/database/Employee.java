package com.database;

/**
 * Employee POJO contains details of employee
 * 
 * @author Arjita
 *
 */
public class Employee {
	private String fname;// first name of employee
	private String lname;// last name of employee
	private String email;// email of employee
	private int age;// age of employee

	// getters and setters
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}

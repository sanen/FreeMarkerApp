package com.cig.freemarker.mail;

public class Person {

	public Person(String firstName,String lastName){
		this.firstName=firstName;
		this.lastName=lastName;
	}
	private String firstName;
	private String lastName;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}

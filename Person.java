package com.claim;

public class Person {
	private String firstName;
	private String middleName;
	private String lastName;
	private String phoneNumber;
	private Address address;

	
	public Person() {
		
	}
	
	
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName
				+ ", phoneNumber=" + formatPhoneNumber(phoneNumber) + ", address=" + address + "]";
	}


	public Person(String firstName, String middleName, String lastName, String phoneNumber, Address address) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		
	}
	
	public String formatPhoneNumber(String phoneNumber) {
		phoneNumber = phoneNumber.trim();
		String	phoneSubstring1 ="";
		String	phoneSubstring2 ="";
		String	phoneSubstring3 ="";
		

		phoneSubstring1 = "("+phoneNumber.substring(0,3)+")-";
		phoneSubstring2 = phoneNumber.substring(3,6)+"-";
		phoneSubstring3 = phoneNumber.substring(6);
			
		phoneNumber = phoneSubstring1+phoneSubstring2+phoneSubstring3;
		return phoneNumber;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}


	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	

	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}

	public boolean equals(String phoneNumber) {
		if (phoneNumber.equals(phoneNumber))
			return true;
		return false;
	}

	

}

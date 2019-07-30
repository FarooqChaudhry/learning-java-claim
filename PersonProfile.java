package com.claim;

import java.util.Arrays;

public class PersonProfile {

	private Person person;
	private Person[] phoneBookArray = new Person[0];
	

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Person parseAndmakePerson(String userString) {

		String name = "";
		String streedAddress = "";
		String city = "";
		String state = "";
		String zipcode = "";
		String phoneNumber = "";
		
		String firstName = "";
		String lastName = "";
		String middleName = "";

		String[] words = userString.split(",");

		for (int i = 0; i < words.length; i++) {
			switch (i) {
				case 0: {
					name = words[i];
				}
				case 1: {
					streedAddress = words[i];
				}
				case 2: {
					city = words[i];
				}
				case 3: {
					state = words[i];
				}
				case 4: {
					zipcode = words[i];
				}
				case 5: {
					phoneNumber = words[i];
				}
			}

		}

		String[] nameArray = name.split("\\s");
		lastName = nameArray[nameArray.length - 1];

		for (int j = 0; j < nameArray.length; j++) {
			firstName = nameArray[0];
			switch (nameArray.length) {
				case 2: {
					break;
				}
				case 3: {
					middleName = nameArray[1];
					break;
				}
				case 4: {
					middleName = nameArray[1] + " " + nameArray[2];
				}
			}
		}
		 
		Address address = new Address(streedAddress.trim(), city.trim(), state.trim(), zipcode.trim());
		Person person = new Person(firstName.trim(), middleName.trim(), lastName.trim(), phoneNumber.trim(), address);
		
		return person;
	}


	public void addEntry(Person person) {
		
		if(searchPerson(person)){
			System.out.println("Duplicate phonebook entry, it will not be added");
		} else {
		
			Person[] newArray = new Person[phoneBookArray.length + 1];
	
			for (int i = 0; i < phoneBookArray.length; i++) {
				newArray[i] = phoneBookArray[i];
			}
	
			phoneBookArray = newArray;
	
			phoneBookArray[phoneBookArray.length - 1] = person;
			System.out.println("\nAdded entry  "+phoneBookArray[phoneBookArray.length - 1]); 
		
		}

	}
	
	
	public boolean searchPerson(Person person) {
		
		boolean isduplicate = false;
		for( int i = 0; i < phoneBookArray.length; i++) {
			if (person.getPhoneNumber().equals(phoneBookArray[i].getPhoneNumber())) {
				System.out.println("\nFound Entry\n");
				System.out.println(phoneBookArray[i]);
				isduplicate = true;
				break;
			}
		}
		if (isduplicate==false) System.out.println("\nDid not find entry\n");
		return isduplicate;
	}
	
	
	public void searchByFirstName(String firstName) {

		Person[] tempHolder = new Person[0];

		for (int i = 0; i < phoneBookArray.length; i++) {
			if (phoneBookArray[i].getFirstName().equalsIgnoreCase(firstName)) {
				tempHolder = expandArray(tempHolder,phoneBookArray[i]);
			} else continue;

		}
		if (tempHolder.length==0) {
			System.out.println("No phonebook entry for this First Name search");
		} else
			System.out.println("Found these results for First Name Search");
		printArray(tempHolder);	
	}

	
	
	public void searchByLastName(String lastName) {
		
		Person[] tempHolder = new Person[0];

		for (int i = 0; i < phoneBookArray.length; i++) {
			if (phoneBookArray[i].getLastName().equalsIgnoreCase(lastName)) {
				tempHolder = expandArray(tempHolder,phoneBookArray[i]);
			} else continue;

		}
		if (tempHolder.length==0) {
			System.out.println("No phonebook entry for this Last Name search");
		} else
			System.out.println("Found these results for Last Name Search");
		printArray(tempHolder);	
	}
	
	
	public void searchByFullName(String name) {
		
		String firstName = "";
		String middleName = "";
		String[] nameArray = name.split("\\s");
		String lastName = nameArray[nameArray.length - 1];
		Person[] tempHolder = new Person[0];

		for (int j = 0; j < nameArray.length; j++) {
			firstName = nameArray[0];
			switch (nameArray.length) {
				case 2: {
					break;
				}
				case 3: {
					middleName = nameArray[1];
					break;
				}
				case 4: {
					middleName = nameArray[1] + " " + nameArray[2];
				}
			}
		}
		
		for (int i = 0; i < phoneBookArray.length; i++) {
			if (firstName.equalsIgnoreCase(phoneBookArray[i].getFirstName()) 
					&& middleName.equalsIgnoreCase(phoneBookArray[i].getMiddleName())
					&& lastName.equalsIgnoreCase(phoneBookArray[i].getLastName())) {
				tempHolder = expandArray(tempHolder,phoneBookArray[i]);
			} else continue;
		}
		if (tempHolder.length==0) {
			System.out.println("No phonebook entry for this Full Name search");
		} else
			System.out.println("Found these results for Full Name Search");
		printArray(tempHolder);	

	}
	
	
	public boolean searchByPhoneNumber(String phoneNumber) {
		
		boolean isEmpty = true;

		Person[] tempHolder = new Person[0];
		
		for (int i = 0; i < phoneBookArray.length; i++) {
			if (phoneBookArray[i].getPhoneNumber().equals(phoneNumber)) {
				tempHolder = expandArray(tempHolder,phoneBookArray[i]);
				isEmpty = false;
			} else continue;
		}
		if (tempHolder.length==0) {
			System.out.println("No phonebook entry for this phone number search");
		} else
			System.out.println("Found these results for phone number Search");
		printArray(tempHolder);	
		
		return isEmpty;

	}
	
	
	public void searchByCityOrState(String cityOrState) {

		Person[] tempHolder = new Person[0];
		
		for (int i = 0; i < phoneBookArray.length; i++) {
			if (phoneBookArray[i].getAddress().getCityName().equalsIgnoreCase(cityOrState)
					|| phoneBookArray[i].getAddress().getStateName().equalsIgnoreCase(cityOrState)) {			
//				newArray[i] = phoneBookArray[i];
				tempHolder = expandArray(tempHolder,phoneBookArray[i]);
				
			} else continue;
		}
		if (tempHolder.length==0) {
			System.out.println("No phonebook entry for this city/state search");
		} else
			System.out.println("Found these results for city/state Search");
		printArray(tempHolder);	
	}
	
	
	public void deletePhoneNumber(String phoneNumber) {
		
		Person[] tempHolder = new Person[0];

		for (int i = 0; i < phoneBookArray.length; i++) {			
			if (!(phoneBookArray[i].getPhoneNumber().equals(phoneNumber))) {
				tempHolder = expandArray(tempHolder,phoneBookArray[i]);
			} else {
				continue;
			}
		}
		phoneBookArray = tempHolder;
//		printArray(phoneBookArray);
		System.out.println("Phonebook entry deleted");

	}
	
	
	public void sortArray() {
		
		Arrays.sort(phoneBookArray, (a, b) -> a.getLastName().compareTo(b.getLastName()));
		
		for (Person i:phoneBookArray) {
			if (i != null) {
			System.out.println(i.toString());
			}
	
		}
	}
	
	
	public Person[] expandArray(Person[] tempHolder,Person person) {
		
		Person[] tempArray = new Person[tempHolder.length + 1];
		
		for (int i = 0; i < tempHolder.length; i++) {
			tempArray[i] = tempHolder[i];
			
		}
		tempArray[tempArray.length-1] = person;

		return tempArray;
	}
	
	
	public static void printArray(Person[] personArray) {
		
		for (int i = 0; i < personArray.length; i++) {
			System.out.println(personArray[i].toString());

		}	
	}
	
	
}

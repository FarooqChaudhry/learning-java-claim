package com.claim;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PhoneBookApplication {
	
	public static int userInput;
	static Scanner sc = new Scanner(System.in);

	@SuppressWarnings("resource")
	public static void main(String[] args) 
	{
		
		Scanner sc1 = new Scanner(System.in);


	    try {
            userInput = entryScreen();
        } catch (InputMismatchException e) {
            System.out.println("You have entered invalid data type for integer value, try again");
        } 
		
		
		PersonProfile personProfile = new PersonProfile();
		
			
		while (userInput != 11) {
			
			
			switch (userInput) {
				case 1: {
					System.out.println("Please enter your entry for phone book");
					
					sc1 = new Scanner(System.in);
					
					String phoneEntry = sc1.nextLine();
	
					
					Person person = new Person();
					person = personProfile.parseAndmakePerson(phoneEntry);
					personProfile.addEntry(person);
					break;
	
				}
				case 2: {
					System.out.println("Search for an existing entry");
					sc1 = new Scanner(System.in);
					
					String phoneEntry = sc1.nextLine();
					Person person = new Person();
					person = personProfile.parseAndmakePerson(phoneEntry);
					personProfile.searchPerson(person);
					break;

				}
				case 3: {
					System.out.println("Search by first name");
					sc1 = new Scanner(System.in);
					String firstName = sc1.next();
					
					
					personProfile.searchByFirstName(firstName);
					break;
				}
				case 4: {
					System.out.println("Search by last name ");
					sc1 = new Scanner(System.in);
					String lastName = sc1.next();
					
					
					personProfile.searchByLastName(lastName);
					break;
				}
				case 5: {
					System.out.println("Search by full name ");
				    sc1 = new Scanner(System.in);
				    String fullName = sc1.nextLine();
				      

				    personProfile.searchByFullName(fullName);
					break;
				}
				case 6: {
					System.out.println("Search by telephone number");
					sc1 = new Scanner(System.in);
					String phoneNumber = sc1.next();
					
					
					personProfile.searchByPhoneNumber(phoneNumber);
					break;
				}
				case 7: {
					System.out.println("Search by city or state");
					sc1 = new Scanner(System.in);
					String phoneNumber = sc1.nextLine();
					
					
					personProfile.searchByCityOrState(phoneNumber);
					break;
				}
				case 8: {
					System.out.println("Delete a record for a given telephone number");
					sc1 = new Scanner(System.in);
					String phoneNumberToDelete = sc1.next();
					
					
					personProfile.deletePhoneNumber(phoneNumberToDelete);
					break;
				}
				case 9: {
					System.out.println("Update a record for a given telephone number");
					System.out.println("Enter phone # to be updated");
					sc1 = new Scanner(System.in);
					String phoneNumberToDelete = sc1.next();
					personProfile.deletePhoneNumber(phoneNumberToDelete);
					
					System.out.println("\n\nEnter full updated phonebook entry");
					sc1 = new Scanner(System.in);
					String phoneEntry = sc1.nextLine();
					
					Person person = new Person();
					person = personProfile.parseAndmakePerson(phoneEntry);
					personProfile.addEntry(person);		
					
					break;
				}
				case 10: {
					System.out.println("Show all records in asc order");
					personProfile.sortArray();
					break;
				}
				case 11: {
					System.out.println("option to exit the program");
					break;
				}
			}

		    try {
	            userInput = entryScreen();
	        } catch (InputMismatchException e) {
	            System.out.println("You have entered invalid data type for integer value, try again");
	            userInput = entryScreen();
	        } 
		}
		sc1.close();

	}
	
	public static int entryScreen() {
		
		sc = new Scanner(System.in);	
		System.out.println("\n1) Add new entries \n" + 
				"2) Search for an existing entry\n" + 
				"3) Search by first name \n" + 
				"4) Search by last name \n" + 
				"5) Search by full name \n" + 
				"6) Search by telephone number\n" + 
				"7) Search by city or state\n" + 
				"8) Delete a record for a given telephone number\n" + 
				"9) Update a record for a given telephone number\n" + 
				"10) Show all records in asc order\n" + 
				"11) option to exit the program \n"+
				"\n\nChoose your option from above"			
				);
		int userInput = sc.nextInt();

		return userInput;
	}
	


}

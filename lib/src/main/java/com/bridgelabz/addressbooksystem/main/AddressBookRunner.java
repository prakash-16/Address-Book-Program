package com.bridgelabz.addressbooksystem.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Scanner;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class AddressBookRunner {

	public static void main(String[] args) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {

		System.out.println(" Welcome to Address Book Program ");
		AddressBook addressBookOne = new AddressBook();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Enter index number :- ");
			String indexNo = sc.nextLine();
			System.out.println("Enter your first name :- ");
			String firstName = sc.nextLine();
			System.out.println("Enter your last name :- ");
			String lastName = sc.nextLine();
			System.out.println("Enter your address :- ");
			String address = sc.nextLine();
			System.out.println("Enter your city :- ");
			String city = sc.nextLine();
			System.out.println("Enter your state :- ");
			String state = sc.nextLine();
			System.out.println("Enter your zip code :- ");
			String zip = sc.nextLine();
			System.out.println("Enter your contact number :- ");
			String contactNumber = sc.nextLine();
			System.out.println("Enter your email :- ");
			String email = sc.nextLine();
			boolean result = addressBookOne.addContactDetails(indexNo, firstName, lastName, address, city, state, zip,
					contactNumber, email);
			if (result == true) {
				System.out.println("Contact details added successfully");
			} else {
				System.out.println("Please enter valid details");
			}
			System.out.println("Do you wish to add more contacts (Yes/No)");
			String choice = sc.nextLine();
			if (choice.toLowerCase().equals("no")) {
				break;
			}
		}
		addressBookOne.showDetails();
		addressBookOne.writeDataToCSV();
		addressBookOne.readDataToCSV("data.csv");
	}

}

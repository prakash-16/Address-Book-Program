package com.bridgelabz.addressbooksystem.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.stream.JsonWriter;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class AddressBook {

	public int i, j;

	ArrayList<String[]> addressBook = new ArrayList<String[]>();
	Dictionary statePersons = new Hashtable();
	Dictionary cityPersons = new Hashtable();
	String[] countPersons = new String[10];

	public boolean addContactDetails(String indexNo, String firstName, String lastName, String address, String city,
			String state, String zip, String contactNumber, String email) {
		String personDetails[] = new String[9];
		String name = firstName + " " + lastName;
		boolean result = checkDuplicateEntry(name);
		if (result == true) {
			System.out.println("There is an already entry for " + name);
			return false;
		}
		personDetails[0] = indexNo;
		personDetails[1] = firstName;
		personDetails[2] = lastName;
		personDetails[3] = address;
		personDetails[4] = city;
		personDetails[5] = state;
		personDetails[6] = zip;
		personDetails[7] = contactNumber;
		personDetails[8] = email;
		addressBook.add(personDetails);
		return true;
	}

	public boolean checkDuplicateEntry(String name) {
		ArrayList<String> usersName = new ArrayList<String>();
		for (i = 0; i < addressBook.size(); i++) {
			usersName.add(addressBook.get(i)[0] + " " + addressBook.get(i)[1]);
		}
		if (usersName.stream().anyMatch(n -> n != null && n.equals(name))) {
			return true;
		}
		return false;
	}

	public void showDetails() {
		for (i = 0; i < addressBook.size(); i++) {
			System.out.println("Index no. - " + (i + 1));
			for (j = 0; j < 8; j++) {
				System.out.println(addressBook.get(i)[j]);
			}
		}
	}

	public void searchName(String city, String state) {
		for (i = 0; i < addressBook.size(); i++) {
			if (addressBook.get(i)[3].equals(city) || addressBook.get(i)[4].equals(state)) {
				System.out.println("List of people live in " + city + state);
				System.out.println(addressBook.get(i)[0] + addressBook.get(i)[1]);
			}
		}
	}

	public void writeDataToCSV() throws IOException {
		try {
			File file = new File("data.csv");
			FileWriter outputFile = new FileWriter(file);
			CSVWriter writer = new CSVWriter(outputFile);
			ArrayList<String[]> data = new ArrayList<String[]>();
			String[] dataAddBook = new String[9];
			data.add(new String[] { "Index no", "First name", "Last name", "Address", "City", "State", "Zip code",
					"Contact number", "Email-Id" });
			for (i = 0; i < addressBook.size(); i++) {
				for (j = 0; j < 9; j++) {
					dataAddBook[j] = addressBook.get(i)[j];
				}
				data.add(dataAddBook);
				writer.writeAll(data);
			}
			writer.close();
			System.out.println("CSV file is created");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readDataToCSV(String fileName) throws IOException {
		try {
			Files.lines(new File(fileName).toPath()).forEach(System.out::println);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}

package com.bridgelabz.addressbook;

import java.util.*;

public class AddressBook {
	public int i, j;

	ArrayList<String[]> addressBook = new ArrayList<String[]>();
	Dictionary statePersons = new Hashtable();
	Dictionary cityPersons = new Hashtable();
	String[] countPersons = new String[10];

	public boolean addContactDetails(String firstName, String lastName, String address, String city, String state,
			String zip, String contactNumber, String email) {
		String personDetails[] = new String[8];
		String name = firstName + " " + lastName;
		boolean result = checkDuplicateEntry(name);
		if (result == true) {
			System.out.println("There is an already entry for " + name);
			return false;
		}
		personDetails[0] = firstName;
		personDetails[1] = lastName;
		personDetails[2] = address;
		personDetails[3] = city;
		personDetails[4] = state;
		personDetails[5] = zip;
		personDetails[6] = contactNumber;
		personDetails[7] = email;
		addressBook.add(personDetails);
		return true;
	}

	public boolean checkDuplicateEntry(String name) {
		ArrayList<String> userDetails = new ArrayList<String>();
		for (i = 0; i < addressBook.size(); i++) {
			for (j = 0; i < 8; j++) {
				userDetails.add(addressBook.get(i)[0] + " " + addressBook.get(i)[1]);
			}
			if (userDetails.stream().anyMatch(n -> n != null && n.equals(name)))
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
		String details = city + " ," + state;
		ArrayList<String> userDetails = new ArrayList<String>();
		for (i = 0; i < addressBook.size(); i++) {
			for (j = 0; i < 8; j++) {
				userDetails.add(addressBook.get(i)[3] + " ," + addressBook.get(i)[4]);
			}
			if (userDetails.stream().anyMatch(n -> n != null && n.equals(details)))
				System.out.println(addressBook.get(i)[0] + addressBook.get(i)[1]);
		}
	}

	public void dictOfStateAndPersons() {
		for (i = 0; i < addressBook.size(); i++) {
			statePersons.put(addressBook.get(i)[4], (addressBook.get(i)[0] + " " + addressBook.get(i)[1]));
		}
	}

	public void dictOfCityAndPersons() {
		for (i = 0; i < addressBook.size(); i++) {
			cityPersons.put(addressBook.get(i)[3], (addressBook.get(i)[0] + " " + addressBook.get(i)[1]));
		}
	}

	public void printDictStateAndPersons() {
		System.out.println("The dictionary of states and persons are : " + statePersons);
	}

	public void printDictCityAndPersons() {
		System.out.println("The dictionary of city and persons are : " + cityPersons);
	}

	public int countPersons() {
		int count = 0;
		Enumeration<String> key = cityPersons.keys();
		while (key.hasMoreElements()) {
			String keys = key.nextElement();
			count++;
			return count;
		}
		System.out.println("List is empty.");
		return 0;
	}
	
	public StringBuffer writeData(String bookName) {
		StringBuffer file = new StringBuffer("AddressBook" + bookName + "\n");
		for (i = 0; i < addressBook.size(); i++) {
			System.out.println("Index no. - " + (i + 1));
			file.append("\nFirst Name - "+addressBook.get(i)[0]);
			file.append("\nLast Name - "+addressBook.get(i)[1]);
			file.append("\nAddress - "+addressBook.get(i)[2]);
			file.append("\nCity - "+addressBook.get(i)[3]);
			file.append("\nState - "+addressBook.get(i)[4]);
			file.append("\nZip Code - "+addressBook.get(i)[5]);
			file.append("\nContact Number - "+addressBook.get(i)[6]);
			file.append("\nEmail-Id - "+addressBook.get(i)[7]);
			file.append("\n------------\n");
	    }
		return file;
	}
		

}

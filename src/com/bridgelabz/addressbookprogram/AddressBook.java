package com.bridgelabz.addressbookprogram;

import java.util.*;

public class AddressBook {
	
	public int i, j;

	ArrayList<String[]> addressBook = new ArrayList<String[]>();

	public boolean addContactDetails(String firstName, String lastName, String address, String city, String state,
			String zip, String contactNumber, String email) {
		String personDetails[] = new String[8];
		for(i = 0; i < addressBook.size(); i++) {
			if(addressBook.get(i)[0].equals(firstName) && addressBook.get(i)[1].equals(lastName)) {
				System.out.println("Duplicate Entry");
				return false;
			}
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
		

	public void showDetails() {
		for (i = 0; i < addressBook.size(); i++) {
			System.out.println("Index no. - " + (i + 1));
			for (j = 0; j < 8; j++) {
				System.out.println(addressBook.get(i)[j]);
			}
		}
	}

}

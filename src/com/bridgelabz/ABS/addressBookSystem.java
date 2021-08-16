package com.bridgelabz.ABS;
import java.util.Arrays;
class contacts {
	public static int j = 0;
	public static String contactList[][] = new String[10][10];

	public void contactDetails(String firstName, String lastName, String address, String city, String state, String zip,
			String contactNumb, String email) {
		contactList[j][0] = firstName;
		contactList[j][1] = lastName;
		contactList[j][2] = address;
		contactList[j][3] = city;
		contactList[j][4] = state;
		contactList[j][5] = zip;
		contactList[j][6] = contactNumb;
		contactList[j][7] = email;
		j++;
		System.out.println("Contact details added successfully");
	}

	public void showDetails() {
		int i;
		if (contactList[0][0] == null) {
			System.out.println("The contact list is empty");
		} 
		else {
			for (i = 0; i < contactList.length; i++) {
				if (contactList[i][0] != null) {
					System.out.println((i + 1) + "\nFirst name - " + contactList[i][0] + "\nLast name - "
							+ contactList[i][1] + "\nAddress - " + contactList[i][2] + "\nCity - " + contactList[i][3]
							+ "\nState - " + contactList[i][4] + "\nZip code - " + contactList[i][5]
							+ "\nContact number - " + contactList[i][6] + "\nEmail Id - " + contactList[i][7]);
				}
			}
		}
	}
	public void edit(String name, int indexNum, String dataToBeChanged) {
		int i;
		if (contactList[0][0] == null) {
			System.out.println("The contact list is empty");
		}
		for(i=0;i<contactList.length;i++) {
			if (contactList[i][0] != null) {
				if(contactList[i][0] == name ) {
					contactList[i][indexNum] = dataToBeChanged;
				}
				else {
					System.out.println("Name is not in the list");
				}
			}
		}
		
	}
	public void delete(String name) {
		int i;
		if (contactList[0][0] == null) {
			System.out.println("The contact list is empty");
		}
		for(i=0;i<contactList.length;i++) {
			if (contactList[i][0] != null) {
				if(contactList[i][0] == name ) {
					if(contactList[i+1][0] != null) {
						contactList[i][0] = contactList[i+1][0];
						contactList[i+1][0] =null;
					}
					else {
						contactList[i][0] =null;
					}
				}
				else {
					System.out.println("Name is not in the list");
				}
			}
		}
		
	}
}

public class addressBookSystem {

	public static void main(String[] args) {
		System.out.println(" Welcome to Address Book Program ");
		contacts obj1 = new contacts();
		obj1.contactDetails("Amit", "Singh", "Street 1", "California", "Texas", "100101", "6152551651",
				"amits@gmail.com");
		obj1.showDetails();
		obj1.edit("Amit",2,"Street 2");
		obj1.showDetails();
		obj1.contactDetails("Sachin", "Patel", "Street 3", "California", "Texas", "100101", "5151651651",
				"sachinp@gmail.com");
		obj1.showDetails();
		obj1.delete("Amit");
		obj1.showDetails();

	}

}

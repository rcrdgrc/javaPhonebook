package phonebook;

import java.util.Scanner;

public class Application {
	// main is the method that will run first in app

	public static void makeSelection() {
		String newLine = System.getProperty("line.separator");
		System.out.println("Menu" + newLine + "1. Add New Record" + newLine + "2. Update Record");
		System.out.println("3. Delete Record" + newLine + "4. Search By FirstName" + newLine + "5. Search By LastName");
		System.out.println("6. Search By First and Last Name" + newLine + "7. Search By PhoneNumber" + newLine
				+ "8. Search By City");
		System.out.println("9. Search by State" + newLine + "10. Show All Records" + newLine + "11. Exit" + newLine);
		System.out.println("Enter Selection: " + newLine);
	}

	private static Person[] expandArray(Person[] phoneBook) {
		Person[] target = new Person[phoneBook.length + 1];
		for (int i = 0; i < phoneBook.length; i++) {
			target[i] = phoneBook[i];
		}
		return target;
	}

	private static Person[] expandNewArray(Person[] phoneBook) {
		Person[] target = new Person[phoneBook.length + 1];
		for (int i = 0; i < phoneBook.length; i++) {
			target[i] = phoneBook[i];
		}
		return target;
	}

	private static Person setAll(String name, String last, String phone, String street, String city, String state,
			String zip) {

		Person p = new Person(name, last, phone);
		Address a = new Address();
		a.setStreet(street);
		a.setCity(city);
		a.setState(state);
		a.setZip(zip);
		p.setAddress(a);
		return p;
	}

	public static void main(String[] args) {// This will
		// line separator
		String newLine = System.getProperty("line.separator");
		// Person p = new Person();
		Address a = new Address();
		Person[] phoneBook = new Person[0];
		boolean hasEnded = false;

		makeSelection();

		while (!hasEnded) {
			Scanner scanner = new Scanner(System.in);
			String selection = scanner.nextLine();

			switch (selection) {
			case "1":
				// code block
				System.out.println("Please enter enter record in the following format: " + newLine
						+ "Without spaces after commas" + newLine
						+ "firstName,lastName,phoneNumber(000)-000-0000,street,city,state,zip" + newLine + "Enter:");
				scanner = new Scanner(System.in);
				selection = scanner.nextLine();
				String[] s = selection.split(",");

				phoneBook = expandArray(phoneBook);
				phoneBook[phoneBook.length - 1] = setAll(s[0], s[1], s[2], s[3], s[4], s[5], s[6]);

				makeSelection();

				System.out.println("Record Added!");
				System.out.println("Enter Another Selection: ");
				break;
			case "2":
				System.out.println("Enter Phone Number Associated With Person Being Updated: ");
				scanner = new Scanner(System.in);
				selection = scanner.nextLine();

				for (int i = 0; i < phoneBook.length; i++) {
					if (selection.equalsIgnoreCase(phoneBook[i].getPhoneNumber())) {
						System.out.println("Record Found");
						System.out.println(phoneBook[i]);
						System.out.println("Please update record in the following format: " + newLine
								+ "firstName, lastName, phoneNumber(000-000-0000), street,  city, state, zip" + newLine
								+ "Enter:");
						scanner = new Scanner(System.in);
						selection = scanner.nextLine();

						s = selection.split(",");
						phoneBook[i] = setAll(s[0], s[1], s[2], s[3], s[4], s[5], s[6]);
						System.out.println(phoneBook[i]);
						System.out.println("Record Updated! ");
						System.out.println("Make Another Selection: ");
					} else {
						System.out.println("Record Not Found Try A Different Menu Item: ");
					}
				}
				break;
			case "3":
				System.out.println("Enter Phone Number Associated With Person Being Deleted: ");
				scanner = new Scanner(System.in);
				selection = scanner.nextLine();

				for (int i = 0; i < phoneBook.length; i++) {
					if (selection.equalsIgnoreCase(phoneBook[i].getPhoneNumber())) {
						System.out.println("Record Found");
						System.out.println(phoneBook[i]);
						System.out.println("Are you sure you want to delete person " + newLine
								+ "Enter 1 for yes and 2 for no" + newLine + "Enter:");

						scanner = new Scanner(System.in);
						selection = scanner.nextLine();
						Person recordFound = phoneBook[i];
						Person[] updatedBook = new Person[phoneBook.length - 1];

						if (selection.equals("1")) {
							for (int i1 = 0; i1 < phoneBook.length; i1++) {
								if (!phoneBook[i1].getPhoneNumber().equals(recordFound.getPhoneNumber())) {
									// updatedBook =
									// expandNewArray(updatedBook);
									updatedBook[i1] = phoneBook[i1];
								}
							}
							phoneBook = updatedBook;
						} else {
							System.out.println("No record was deleted: ");
							System.out.println("Make Another Selection: ");
							break;
						}

						System.out.println(phoneBook.length);
						System.out.println("Record Deleted! ");
						System.out.println("Make Another Selection: ");
					} else {
						System.out.println("Record Not Found Try A Different Menu Item: ");
					}
				}
				break;
			case "4":
				System.out.println("Enter First Name: ");
				scanner = new Scanner(System.in);
				selection = scanner.nextLine();

				for (int i = 0; i < phoneBook.length; i++) {
					if (selection.equalsIgnoreCase(phoneBook[i].getFirstName())) {
						System.out.println("Record Found!");
						System.out.println(phoneBook[i]);
						System.out.println("Enter Selection: ");
					} else if (phoneBook.length - 1 == i && !selection.equalsIgnoreCase(phoneBook[i].getFirstName())) {
						System.out.println("Retry Or Enter A Different Selection: ");
					}
				}

				break;
			case "5":
				System.out.println("Enter Last Name: ");
				scanner = new Scanner(System.in);
				selection = scanner.nextLine();

				for (int i = 0; i < phoneBook.length; i++) {
					if (selection.equalsIgnoreCase(phoneBook[i].getLastName())) {
						System.out.println("Record Found!");
						System.out.println(phoneBook[i]);
						System.out.println("Enter Selection: ");
					} else if (phoneBook.length - 1 == i && !selection.equalsIgnoreCase(phoneBook[i].getLastName())) {
						System.out.println("Retry Or Enter A Different Selection: ");
					}
				}

				break;
			case "10":
				for (int i = 0; i < phoneBook.length; i++) {
					System.out.println(phoneBook[i]);
				}
				System.out.println("Showing All Records: ");
				System.out.println("Enter Another Selection: ");
				break;
			case "11":
				System.out.println("Thank you, Good Bye!");
				hasEnded = true;
				// code block
				break;
			default:
				// code block
			}
		}

	}

}


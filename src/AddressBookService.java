import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AddressBookService {

	public void display(LinkedList<Person> contacts) {
		// System.out.println("size " + contacts.size());
		for (int i = 0; i < contacts.size(); i++) {
			System.out.println("contact number " + (i + 1) + " = " + contacts.get(i).getName() + ", "
					+ contacts.get(i).getAddress() + ", " + contacts.get(i).getPhone() + ", "
					+ contacts.get(i).getEmail());
		}
	}

	public int findIndex(String email, LinkedList<Person> contacts) {

		int index = 0;
		for (int i = 0; i < contacts.size(); i++) {
			Person p = contacts.get(i);

			if (p.getEmail().equals(email)) {
				index = i;
			}
		}

		return index;
	}

	public LinkedList<Person> removePerson(int index, LinkedList<Person> contacts) {
		// System.out.println("in removePerson");
		contacts.remove(index);
		return contacts;
	}

	public LinkedList<Person> editAddress(int index, LinkedList<Person> contacts, Scanner scanner) {

		System.out.println("what do you want to edit? Enter name, address, phone or email");
		String s = scanner.next();
		Person p = contacts.get(index);
		if (s.equals("address")) {
			System.out.println("enter the new address");
			String newAddress = scanner.next();
			p.setAddress(newAddress);
		} else if (s.equals("phone")) {
			System.out.println("enter new phone number");
			String phone = scanner.next();
			p.setPhone(phone);
		} else if (s.equals("email")) {
			System.out.println("enter new email address");
			String email = scanner.next();
			p.setEmail(email);
		} else
			System.out.println("incorrect entry");
		return contacts;
	}

	public Person createContact(Person con, Scanner scanner) {
		con.setName(scanner.nextLine());
		System.out.println("Please enter the person's name");
		con.setName(scanner.nextLine());
		System.out.println("Please enter the address");
		con.setAddress(scanner.nextLine());
		System.out.println("Please enter the phone number");
		con.setPhone(scanner.nextLine());
		System.out.println("Please enter the email address");
		con.setEmail(scanner.nextLine());

		return con;
	}

	public void displayMenu() {
		System.out.println("Please choose from the following options");
		System.out.println("1) Read the data from the file");
		System.out.println("2) Create a new Consultant");
		System.out.println("3) Create a new Contractor");
		System.out.println("4) Display address book");
		System.out.println("5) Delete an entry - enter a number");
		System.out.println("6) To Exit");
	}

	public LinkedList<Person> sort(LinkedList<Person> contacts) {
		// Collections.sort((List<T>) contacts);
		return null;
	}
}

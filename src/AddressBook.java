import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {

	private List<Person> contacts;
	private String name;

	public AddressBook(String name, List<Person> contacts) {
		this.contacts = contacts;
		this.name = name;
	}

	public void addContact(Person contact) {
		contacts.add(contact);
	}

	public List<Person> getContacts() {
		return contacts;
	}

	public void setContacts(List<Person> contacts) {
		this.contacts = contacts;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void display(LinkedList<Person> contacts) {
		for (Person p : contacts) {
		System.out.println(p.toString());
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
		contacts.remove(index);
		return contacts;
	}

	public LinkedList<Person> editDetails(int index, LinkedList<Person> contacts, Scanner scanner) {
		Person p = contacts.get(index);
		if (p.getClass().equals(Consultant.class)) {
			System.out.println(
					"What do you want to edit? You cannot change the name. Enter address, phone, email or language");
			String s = scanner.next();
			Consultant c = (Consultant) p;

			if (s.equals("address")) {
				System.out.println("enter the new address");
				String newAddress = scanner.next();
				c.setAddress(newAddress);
			} else if (s.equals("phone")) {
				System.out.println("enter new phone number");
				String phone = scanner.next();
				c.setPhone(phone);
			} else if (s.equals("email")) {
				System.out.println("enter new email address");
				String email = scanner.next();
				c.setEmail(email);
			} else if (s.equals("language")) {
				System.out.println("enter new language");
				String language = scanner.next();
				c.setLanguage(language);
			} else
				System.out.println("incorrect entry");
		} else {
			System.out.println(
					"what do you want to edit? You cannot change the name. Enter address, phone, email or car reg");
			String s = scanner.next();
			Contractor c = (Contractor) p;

			if (s.equals("address")) {
				System.out.println("enter the new address");
				String newAddress = scanner.next();
				c.setAddress(newAddress);
			} else if (s.equals("phone")) {
				System.out.println("enter new phone number");
				String phone = scanner.next();
				c.setPhone(phone);
			} else if (s.equals("email")) {
				System.out.println("enter new email address");
				String email = scanner.next();
				c.setEmail(email);
			} else if (s.equals("car reg")) {
				System.out.println("car reg");
				String reg = scanner.next();
				c.setCarRegistration(reg);
			} else
				System.out.println("incorrect entry");
		}
		return contacts;
	}

	public Person createContact(Person person, Scanner scanner) {
		System.out.println("Please enter the person's name");
		String name = scanner.next();
		System.out.println("Please enter the address");
		String address = scanner.next();
		System.out.println("Please enter the phone number");
		String phone = scanner.next();
		System.out.println("Please enter the email address");
		String email = scanner.next();
		if (person instanceof Consultant) {
			System.out.println("Please enter language type");
			String language = scanner.next();
			return person = new Consultant(name, address, phone, email, language);
		} else {
			System.out.println("please enter contractors car regisration");
			String reg = scanner.next();
			return person = new Contractor(name, address, phone, email, reg);
		}
	}

	

	public void sort(LinkedList<Person> contacts, String s) {

		if (contacts.size() > 0) {
			Collections.sort(contacts, new Comparator<Person>() {
				@Override
				public int compare(final Person person1, final Person person2) {
					if (s.equals("name"))
						return person1.getName().compareTo(person2.getName());
					else if (s.equals("address"))
						return person1.getAddress().compareTo(person2.getAddress());
					else
						return 0;
				}
			});
		}
	}

	public static void getAddressBooks(String fileName) {
		File f = new File(fileName);
		File[] listOfFiles = f.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
			String s = listOfFiles[i].toString();
			String newString = s.substring(5);
			System.out.println((i + 1) + ") " + newString);
		}
	}
}
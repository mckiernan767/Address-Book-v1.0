import java.util.LinkedList;
import java.util.Scanner;
import java.io.InputStreamReader;

public class Test {
	final static String DATA_FOLDER = "data"; 
	
	public static void main(String[] args) {
				
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		LinkedList<Person> contacts = new LinkedList<Person>();
		AddressBook ab;
		String nameOfAddressBook;

		AddressBook.getAddressBooks(DATA_FOLDER);
		System.out.println("Enter the name of the address book you want to view or type 'new' to create a new address book");

		String name = scanner.next();

		if (name.equals("new")) {
			System.out.println("Enter the name of the new AddressBook");
			String newName = scanner.next();
			nameOfAddressBook = newName;
			CSVFileWriter.writeCSV(contacts, DATA_FOLDER + "\\" + newName + ".csv");
			contacts = CSVFileReader.readFile(DATA_FOLDER + "\\" + newName + ".csv");
			ab = new AddressBook(newName, contacts);
		} else {
			contacts = CSVFileReader.readFile(DATA_FOLDER + "\\" + name + ".csv");
			ab = new AddressBook(name, contacts);
			nameOfAddressBook = name;
		}
	
		boolean hasBeenModified = false;

		displayMenu();
		int number = scanner.nextInt();

		while (number != 9) {
			switch (number) {
			case 1:
				System.out.println("Enter the name of the new AddressBook");
				String newName = scanner.next();
				CSVFileWriter.writeCSV(contacts, DATA_FOLDER + "\\" + newName + ".csv");
				break;
			case 2:
				Person consultant = new Consultant();
				consultant = ab.createContact(consultant, scanner);
				contacts.add(consultant);
				hasBeenModified = true;
				break;
			case 3:
				Person contractor = new Contractor();
				contractor = ab.createContact(contractor, scanner);
				contacts.add(contractor);
				hasBeenModified = true;
				break;
			case 4:
				ab.display(contacts);
				break;
			case 5:
				System.out.println("Please enter the number of the person you wish to delete");
				ab.display(contacts);
				number = scanner.nextInt();
				ab.removePerson((number - 1), contacts);
				hasBeenModified = true;
				break;
			case 6:
				System.out.println("Please enter the number of the person you wish to edit");
				ab.display(contacts);
				number = scanner.nextInt();
				ab.editDetails((number - 1), contacts, scanner);
				hasBeenModified = true;
				break;
			case 7:
				displayMenu();
				break;
			case 8:
				System.out.println("What would you like to sort by, 'name' or 'address'?");
				String s = scanner.next();
				ab.sort(contacts, s);
				break;
			default:
				System.out.println("Invalid entry");
				break;
			}
			if (number != 9 && number != 5)
				System.out.println("Enter next choice, enter 7 to view menu");
			number = scanner.nextInt();
		}
		System.out.println("exit");
		if (hasBeenModified == true)
			System.out.println("do you want to save your changes?");
		String answer = scanner.next();
		if (answer.equals("yes"))
			CSVFileWriter.writeCSV(contacts, DATA_FOLDER + "\\" + nameOfAddressBook + ".csv");
	}
	
	public static void displayMenu() {
		System.out.println("Please choose from the following options");
		System.out.println("1) Read the data from the file");
		System.out.println("2) Create a new Consultant");
		System.out.println("3) Create a new Contractor");
		System.out.println("4) Display address book");
		System.out.println("5) Delete an entry - enter a number");
		System.out.println("6) Edit a contact");
		System.out.println("7) Display Menu");
		System.out.println("8) Sort");
		System.out.println("9) To Exit");
	}
}

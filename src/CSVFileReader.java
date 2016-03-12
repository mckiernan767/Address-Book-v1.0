import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

public class CSVFileReader {
	static String COMMA_DELIMITER = ",";

	public static LinkedList<Person> readFile(String fileName) {
		BufferedReader reader = null;
		LinkedList<Person> contacts = new LinkedList<Person>();

		try {
			String line = null;
			reader = new BufferedReader(new FileReader(fileName));
			reader.readLine();

			while ((line = reader.readLine()) != null) {
				String[] tokens = line.split(COMMA_DELIMITER);
				if (tokens.length > 0) {
					if (tokens[5].contains("consultant")) {
						Consultant con = new Consultant();
						con.setName(tokens[0]);
						con.setAddress(tokens[1]);
						con.setPhone(tokens[2]);
						con.setEmail(tokens[3]);
						con.setLanguage(tokens[4]);
						contacts.add(con);
					} else if (tokens[5].contains("contractor")) {
						Contractor con = new Contractor();
						con.setName(tokens[0]);
						con.setAddress(tokens[1]);
						con.setPhone(tokens[2]);
						con.setEmail(tokens[3]);
						con.setCarRegistration(tokens[4]);
						contacts.add(con);
					}
				}
			}
			reader.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("No file exists");
		}
		return contacts;
	}
}

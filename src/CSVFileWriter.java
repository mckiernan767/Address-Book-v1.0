import java.util.LinkedList;
import java.io.FileWriter;

public class CSVFileWriter {

	static String NEW_LINE_SEPARATOR = "\n";
	static String FILE_HEADER = "name,city,number,email, additional, type";

	public static void writeCSV(LinkedList<Person> contacts, String fileName) {

		FileWriter fileWriter = null;

		try {
			fileWriter = new FileWriter(fileName);
			fileWriter.append(FILE_HEADER);
			for (Person p : contacts) {
				fileWriter.append(NEW_LINE_SEPARATOR);
				if (p.getClass().equals(Consultant.class)) {
					Consultant con = (Consultant) p;
					fileWriter.append(con.toString());

				} else if (p.getClass().equals(Contractor.class)) {
					Contractor con = (Contractor) p;
					fileWriter.append(con.toString());
				}
			}
			fileWriter.flush();
			fileWriter.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

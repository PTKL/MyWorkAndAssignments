import java.io.*;
import java.util.*;

public class Dictionary {
	private ArrayList<String> list;
	String[] array;

	// A constructor that takes in the file name as an argument
	public Dictionary(String name) {
		String line = null;
		try {
			Scanner scan = new Scanner(new File(name));
			list = new ArrayList<String>();
			// Goes through the file adding the strings to the array list.
			while (scan.hasNext()) {
				line = scan.nextLine();
				list.add(line.toLowerCase());
			}
			// Closes the scanner.
			scan.close();

			array = list.toArray(new String[list.size()]);

			System.out.println(list.size());

		} catch (FileNotFoundException e) {
			System.out.println("File is not found");
			e.printStackTrace();
		}
	}

	public boolean linearSearch(String s) {
		for (int i = 0; i < array.length; i++) {
			if (array[i].contains(s)) {
				return true;
			}
		}
		return false;
	}

}

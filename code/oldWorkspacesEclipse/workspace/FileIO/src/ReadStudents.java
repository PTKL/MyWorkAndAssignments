import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadStudents {

	public static void main(String[] args) {
		String inputFilename = "Students.txt";

		File inputFile = new File(inputFilename);

		Scanner fileReader;
		try {
			fileReader = new Scanner(inputFile);
			while (fileReader.hasNextLine()) {
				System.out.println(fileReader.nextLine());
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found" + e);
			e.printStackTrace();
		}

	}
}

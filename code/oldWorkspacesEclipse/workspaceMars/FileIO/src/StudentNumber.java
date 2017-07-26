import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class StudentNumber {

	public static void main(String[] args) {
		String inputFilename = "Students.txt";
		String outputFilename = "StudentNumber.txt";

		File inputFile = new File(inputFilename);

		Scanner fileReader;
		try {
			fileReader = new Scanner(inputFile);
			PrintWriter fileWriter = new PrintWriter(outputFilename);
			int studentNumb = 1;
			while (fileReader.hasNextLine()) {
				fileWriter.println(studentNumb + " " +fileReader.nextLine());
				studentNumb++;
			}
			fileReader.close();
			fileWriter.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found" + e);
			e.printStackTrace();
		}

	}
}

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class TestClass {

	public static void main(String[] args) {
		String allAlpha = "The quick brown fox jumps over the lazy dog";

		String outputFilename = "MyFile.txt";

		try {
			PrintWriter fileWriter = new PrintWriter(outputFilename);

			fileWriter.println(allAlpha);

			for (int i = 0; i < 10; i++)
				fileWriter.print(i + " ");

			fileWriter.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error: Unable to write to " + outputFilename);
		}
	}
}

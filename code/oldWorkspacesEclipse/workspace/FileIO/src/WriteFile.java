import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class WriteFile {

	public static void main(String[] args) {
		String allAlpha = "Will is going CRAZY!";
		String outputFile = "MyFile.txt";
		
		try {
			PrintWriter fileWriter = new PrintWriter(outputFile);
			fileWriter.println(allAlpha);
			for (int i = 0; i<10; i++) {
				fileWriter.print(i + " ");
			}
			fileWriter.close();
		} catch (FileNotFoundException e) {
			System.out.println("Unable to write to file " + e);
			e.printStackTrace();
		}

	}

}

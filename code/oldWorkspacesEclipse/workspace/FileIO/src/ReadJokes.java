import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ReadJokes {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);

		System.out.println("which one do you want to read. 1 or 2");
		try {
			int choice = kbd.nextInt();
			
			if (choice < 1 || choice > 2) {
				throw new Exception("Enter 1 or 2");
			}

			File file;

			if (choice == 1) {
				file = new File("ifjoke.txt");
			} else {
				file = new File("whilejoke.txt");

			}

			Scanner fileRead = new Scanner(file);

			while (fileRead.hasNextLine()) {
				System.out.println(fileRead.nextLine());
			}
			fileRead.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found" + e);
			e.printStackTrace();
		} catch (InputMismatchException e) {
			System.out.println("Enter a int " + e);
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Enter 1 or 2 " + e);
			e.printStackTrace();
		} 

		kbd.close();

	}
}
